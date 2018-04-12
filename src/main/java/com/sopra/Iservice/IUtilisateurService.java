package com.sopra.Iservice;

import java.util.List;

import com.sopra.entities.Article;
import com.sopra.entities.Utilisateur;

public interface IUtilisateurService {

public Utilisateur save(Utilisateur utilisateur);
	
	public List<Utilisateur> findAll();
	
	public Utilisateur findOne(Long id);
	
	public void delete(Long id);
}
