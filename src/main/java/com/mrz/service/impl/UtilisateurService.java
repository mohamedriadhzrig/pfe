package com.mrz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrz.Iservice.IUtilisateurService;
import com.mrz.dao.CommentaireRepository;
import com.mrz.dao.UtilisateurRepository;
import com.mrz.entities.Utilisateur;

@Service
public class UtilisateurService implements IUtilisateurService {

	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public List<Utilisateur> findAll() {
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur findOne(Long id) {
		
		return utilisateurRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		utilisateurRepository.delete(id);
	}

}
