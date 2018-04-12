package com.sopra.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.Iservice.UserService;
import com.sopra.data.UserData;
import com.sopra.data.UserWithToken;
import com.sopra.entities.User;
import com.sopra.entities.UserTokenState;
import com.sopra.security.DeviceProvider;
import com.sopra.security.TokenHelper;
import com.sopra.security.auth.JwtAuthenticationRequest;
import com.sopra.service.impl.CustomUserDetailsService;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private UserService userService;

	@Autowired
	TokenHelper tokenHelper;

	@Autowired
	DeviceProvider deviceProvider;

	@Value("${jwt.expires_in}")
	private int EXPIRES_IN;

	@Value("${jwt.cookie}")
	private String TOKEN_COOKIE;

	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> changePassword(@RequestBody PasswordChanger passwordChanger) {
		userDetailsService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword);
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		return ResponseEntity.accepted().body(result);
	}

	static class PasswordChanger {
		public String oldPassword;
		public String newPassword;
	}

	@CrossOrigin("*")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
			HttpServletResponse response, Device device) throws AuthenticationException, IOException {

		// Perform the security
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
						authenticationRequest.getPassword()));

		// Inject into security context
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// token creation
		User user = (User) authentication.getPrincipal();
		String jws = tokenHelper.generateToken(user.getUsername(), device, user.getId(), user.getAuthorities(),
				user.getFirstname() + user.getLastname());

		User appUser = new User();
		appUser = userService.findByUsername(user.getUsername());
		UserData userData = new UserData(appUser.getId() + "", appUser.getUsername(), appUser.getUsername(),
				appUser.getUsername(), appUser.getUsername());

		return ResponseEntity.ok(userResponse(new UserWithToken(userData, jws)));
	}

	private Map<String, Object> userResponse(UserWithToken userWithToken) {
		return new HashMap<String, Object>() {
			{
				put("user", userWithToken);
			}
		};
	}

	@CrossOrigin("*")
	@GetMapping(value = "/user")
	public ResponseEntity currentUser(@AuthenticationPrincipal User currentUser,
			@RequestHeader(value = "Authorization") String authorization) {
		User appUser = new User();
		System.out.println("Autorization: " + authorization);
		System.out.println("Current User: " + currentUser);
		appUser = userService.findById(currentUser.getId());
		UserData userData = new UserData(appUser.getId() + "", appUser.getUsername(), appUser.getUsername(),
				appUser.getUsername(), appUser.getUsername());
		return ResponseEntity.ok(userResponse(new UserWithToken(userData, authorization.split(" ")[1])));
	}

	private Cookie createAuthCookie(String jwt, int expiresIn) {
		Cookie authCookie = new Cookie(tokenHelper.AUTH_COOKIE, (jwt));
		authCookie.setPath("/");
		authCookie.setHttpOnly(true);
		authCookie.setMaxAge(expiresIn);
		return authCookie;
	}

	@CrossOrigin("*")
	@RequestMapping(value = "/refresh", method = RequestMethod.GET)
	public ResponseEntity<?> refreshAuthenticationToken(HttpServletRequest request, HttpServletResponse response,
			Principal principal) {

		String authToken = tokenHelper.getToken(request);

		Device device = deviceProvider.getCurrentDevice(request);

		if (authToken != null && principal != null) {

			// TODO check user password last update
			String refreshedToken = tokenHelper.refreshToken(authToken, device);
			int expiresIn = tokenHelper.getExpiredIn(device);

			// Add cookie to response
			response.addCookie(createAuthCookie(refreshedToken, expiresIn));

			return ResponseEntity.ok(new UserTokenState(refreshedToken, expiresIn));
		} else {
			UserTokenState userTokenState = new UserTokenState();
			return ResponseEntity.accepted().body(userTokenState);
		}
	}

}
