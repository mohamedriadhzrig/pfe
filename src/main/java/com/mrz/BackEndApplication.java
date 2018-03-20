package com.mrz;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mrz.dao.UtilisateurRepository;
import com.mrz.entities.Utilisateur;

@SpringBootApplication
public class BackEndApplication implements CommandLineRunner {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df =new SimpleDateFormat();
		utilisateurRepository.save(new Utilisateur());
	}
}
