package com.sopra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.dao.UtilisateurRepository;
import com.sopra.entities.Utilisateur;
import com.sopra.service.impl.UtilisateurService;

@RestController
public class UtilisateurController {
	@Autowired 
	private UtilisateurService utilisateurService;
	
	@RequestMapping(value = "/utilisateurs", method = RequestMethod.GET)
	public List<Utilisateur> getUtilisateurs(){
		return utilisateurService.findAll();
	}

	@RequestMapping(value = "/utilisateurs/{id}", method = RequestMethod.GET)
	public Utilisateur getUtilisateurAvecId(@PathVariable Long id) {
		return utilisateurService.findOne(id);
	}

	@RequestMapping(value = "/utilisateurs", method = RequestMethod.POST)
	public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur c) {
		return utilisateurService.save(c);
	}
	
	@RequestMapping(value = "/utilisateurs/{id}", method = RequestMethod.PUT)
	public Utilisateur mettreAJour(@PathVariable Long id,@RequestBody Utilisateur c) {
		c.setIdUtilisateur(id);
		return utilisateurService.save(c);
	}

	@RequestMapping(value ="/utilisateurs/{id}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		utilisateurService.delete(id);
		return true;
	}

}
