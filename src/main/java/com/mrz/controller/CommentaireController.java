package com.mrz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrz.dao.CommentaireRepository;
import com.mrz.entities.Commentaire;
import com.mrz.service.impl.CommentaireService;

@RestController
public class CommentaireController {

	@Autowired 
	private CommentaireService commentaireService;
	
	@RequestMapping(value = "/commentaires", method = RequestMethod.GET)
	public List<Commentaire> getCommentaires(){
		return commentaireService.findAll();
	}

	@RequestMapping(value = "/commentaires/{id}", method = RequestMethod.GET)
	public Commentaire getCommentaireAvecId(@PathVariable Long id) {
		return commentaireService.findOne(id);
	}

	@RequestMapping(value = "/commentaires", method = RequestMethod.POST)
	public Commentaire ajouterCommentaire(@RequestBody Commentaire c) {
		return commentaireService.save(c);
	}
	
	@RequestMapping(value = "/commentaires/{id}", method = RequestMethod.PUT)
	public Commentaire mettreAJour(@PathVariable Long id,@RequestBody Commentaire c) {
		c.setIdCommentaire(id);
		return commentaireService.save(c);
	}

	@RequestMapping(value ="/commentaires/{id}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		commentaireService.delete(id);
		return true;
	}
}
