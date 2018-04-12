package com.sopra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sopra.security.TokenHelper;
import com.sopra.security.auth.AuthenticationFailureHandler;
import com.sopra.security.auth.AuthenticationSuccessHandler;
import com.sopra.security.auth.LogoutSuccess;
import com.sopra.security.auth.RestAuthenticationEntryPoint;
import com.sopra.security.auth.TokenAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${jwt.cookie}")
	private String TOKEN_COOKIE;

	@Autowired
	TokenHelper tokenHelper;

	@Autowired
	UserDetailsService jwtUserDetailsService;

	@Bean
	public TokenAuthenticationFilter jwtAuthenticationTokenFilter() throws Exception {
		return new TokenAuthenticationFilter(tokenHelper, jwtUserDetailsService);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Autowired
	private LogoutSuccess logoutSuccess;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());

	}

	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;

	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http.csrf().ignoringAntMatchers("/api/login", "/api/signup")
		 * .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
		 * .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
		 * and()
		 * .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).
		 * and()
		 * 
		 * .addFilterBefore(jwtAuthenticationTokenFilter(),
		 * BasicAuthenticationFilter.class)
		 * .authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage
		 * ("/api/login")
		 * 
		 * .and().logout().logoutRequestMatcher(new
		 * AntPathRequestMatcher("/api/logout"))
		 * .logoutSuccessHandler(logoutSuccess).deleteCookies(TOKEN_COOKIE);
		 */
			
		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
				.authenticationEntryPoint(restAuthenticationEntryPoint).and()
				.addFilterBefore(jwtAuthenticationTokenFilter(), BasicAuthenticationFilter.class)

				.authorizeRequests().antMatchers("/articles/**").hasAuthority("ROLE_ADMIN").anyRequest().authenticated()
				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/api/logout"))
				.logoutSuccessHandler(logoutSuccess).deleteCookies(TOKEN_COOKIE);
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user/**").authenticated();

		http.csrf().ignoringAntMatchers("/api/login", "/api/signup");
		http.csrf().disable();
		
	}

	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("POST", "GET", "DELETE", "PUT", "OPTIONS")
						.allowedOrigins("*");

			}
		};
	} 
	
}
