package com.mrz;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mrz.dao.ArticleRepository;
import com.mrz.dao.CommentaireRepository;
import com.mrz.dao.DemandeRepository;
import com.mrz.dao.UtilisateurRepository;
import com.mrz.entities.Article;
import com.mrz.entities.Commentaire;
import com.mrz.entities.Demande;
import com.mrz.entities.Utilisateur;

@SpringBootApplication
public class BackEndApplication implements CommandLineRunner {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private CommentaireRepository commentaireRepository;
	@Autowired
	private DemandeRepository demandeRepository;
	@Autowired
	private ArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Utilisateur u = new Utilisateur("Zrig", "Med Riadh", "mohamedriadhzrig@gmail.com", "123",
				df.parse("16/07/1990"), "53921625", "stagiaire", "ISV", "image.png");
		Commentaire c = new Commentaire("C'est un tres bon sujet", new Date(), 2, u);
		Demande d = new Demande("demande de tuto", "je voulais savoir comment modifier la gestion de paie", new Date(),
				"en cours de traitement", u);
		Article a = new Article("Gestion de paie", new Date(), "Video", 1, "http://sopra/ttuto/video.jpeg",
				"Ce tuto consiste a montrer comment gerer les employés", "Validé", u);

		utilisateurRepository.save(u);
	}
}
