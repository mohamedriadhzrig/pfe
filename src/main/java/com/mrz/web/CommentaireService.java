package com.mrz.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrz.dao.CommentaireRepository;
import com.mrz.entities.Commentaire;

@RestController
public class CommentaireService {

	@Autowired 
	private CommentaireRepository commentaireRepository;
	
	@RequestMapping(value = "/commentaires", method = RequestMethod.GET)
	public List<Commentaire> getCommentaires(){
		return commentaireRepository.findAll();
	}

	@RequestMapping(value = "/commentaires/{id}", method = RequestMethod.GET)
	public Commentaire getCommentaireAvecId(@PathVariable Long id) {
		return commentaireRepository.findOne(id);
	}

	@RequestMapping(value = "/commentaires", method = RequestMethod.POST)
	public Commentaire ajouterCommentaire(@RequestBody Commentaire c) {
		return commentaireRepository.save(c);
	}
	
	@RequestMapping(value = "/commentaires/{id}", method = RequestMethod.PUT)
	public Commentaire mettreAJour(@PathVariable Long id,@RequestBody Commentaire c) {
		c.setIdCommentaire(id);
		return commentaireRepository.save(c);
	}

	@RequestMapping(value ="/commentaires/{id}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		commentaireRepository.delete(id);
		return true;
	}
}
