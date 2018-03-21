package com.mrz.Iservice;

import java.util.List;

import com.mrz.entities.Article;
import com.mrz.entities.Utilisateur;

public interface IUtilisateurService {

public Utilisateur save(Utilisateur utilisateur);
	
	public List<Utilisateur> findAll();
	
	public Utilisateur findOne(Long id);
	
	public void delete(Long id);
}
