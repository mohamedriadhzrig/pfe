package com.mrz.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrz.dao.UtilisateurRepository;
import com.mrz.entities.Utilisateur;

@RestController
public class UtilisateurService {
	@Autowired 
	private UtilisateurRepository utilisateurRepository;
	
	@RequestMapping(value = "/utilisateurs", method = RequestMethod.GET)
	public List<Utilisateur> getUtilisateurs(){
		return utilisateurRepository.findAll();
	}

	@RequestMapping(value = "/utilisateurs/{id}", method = RequestMethod.GET)
	public Utilisateur getUtilisateurAvecId(@PathVariable Long id) {
		return utilisateurRepository.findOne(id);
	}

	@RequestMapping(value = "/utilisateurs", method = RequestMethod.POST)
	public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur c) {
		return utilisateurRepository.save(c);
	}
	
	@RequestMapping(value = "/utilisateurs/{id}", method = RequestMethod.PUT)
	public Utilisateur mettreAJour(@PathVariable Long id,@RequestBody Utilisateur c) {
		c.setIdUtilisateur(id);
		return utilisateurRepository.save(c);
	}

	@RequestMapping(value ="/utilisateurs/{id}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		utilisateurRepository.delete(id);
		return true;
	}

}
