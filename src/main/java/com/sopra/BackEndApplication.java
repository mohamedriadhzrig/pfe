package com.sopra;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sopra.entities.Article;
import com.sopra.entities.Authority;
import com.sopra.entities.Commentaire;
import com.sopra.entities.Demande;
import com.sopra.entities.User;
import com.sopra.entities.Utilisateur;
import com.sopra.service.impl.ArticleService;
import com.sopra.service.impl.CommentaireService;
import com.sopra.service.impl.DemandeService;
import com.sopra.service.impl.UserServiceImpl;
import com.sopra.service.impl.UtilisateurService;

@SpringBootApplication
public class BackEndApplication implements CommandLineRunner {

	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private CommentaireService commentaireService;
	@Autowired
	private DemandeService demandeService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserServiceImpl userServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User();
		Authority userAuthority1 = new Authority();
		userAuthority1.setName("ROLE_USER");
		List<Authority> userAuthorities = new ArrayList<>();
		userAuthorities.add(userAuthority1);
		user1.setUsername("user");
		user1.setAuthorities(userAuthorities);

		Authority userAuthority = new Authority();
		Authority adminAuthority = new Authority();
		userAuthority.setName("ROLE_USER");
		adminAuthority.setName("ROLE_ADMIN");
		List<Authority> adminAuthorities = new ArrayList<>();
		adminAuthorities.add(userAuthority);
		adminAuthorities.add(adminAuthority);
		User admin = new User();
		admin.setUsername("admin");
		admin.setAuthorities(adminAuthorities);

		// userServiceImpl.save(user1);

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Utilisateur u = new Utilisateur("Zrig", "Med Riadh", "mohamedriadhzrig@gmail.com", "123",
				df.parse("16/07/1990"), "53921625", "stagiaire", "ISV", "image.png");
		Utilisateur u1 = new Utilisateur("Zrig1", "Med Riadh1", "mohamedriadhzrig1@gmail.com", "1231",
				df.parse("16/07/1991"), "53921625", "stagiaire", "ISV", "image.png");
		Utilisateur u2 = new Utilisateur("Zrig2", "Med Riadh2", "mohamedriadhzrig2@gmail.com", "1232",
				df.parse("16/07/1992"), "53921625", "stagiaire", "ISV", "image.png");
		Commentaire c = new Commentaire("C'est un tres bon sujet", new Date(), 2, u);
		Commentaire c1 = new Commentaire("C'est un tres bon sujet1", new Date(), 2, u);
		Commentaire c2 = new Commentaire("C'est un tres bon sujet", new Date(), 2, u2);
		Demande d = new Demande("demande de tuto", "je voulais savoir comment modifier la gestion de paie", new Date(),
				"en cours de traitement", u1);
		Article a = new Article("xxxxxxxxxx", new Date(), "Image", 1, "http://sopra/ttuto/video.jpeg",
				"Ce tuto consiste a montrer comment gerer les employés", "Validé", u);
		Long id = (long) 2;
		c.setArticle(articleService.findOne(id));
		utilisateurService.save(u);
		utilisateurService.save(u1);
		utilisateurService.save(u2);
		commentaireService.save(c);
		demandeService.save(d);
		articleService.save(a);

	}
}
