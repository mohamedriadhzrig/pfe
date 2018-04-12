package com.sopra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.entities.Demande;
import com.sopra.service.impl.DemandeService;


@RestController
public class DemandeController {

	@Autowired
	private DemandeService demandeService;
	
	@RequestMapping(value = "/demandes", method = RequestMethod.GET)
	public List<Demande> getDemandes(){
		return demandeService.findAll();
	}

	@RequestMapping(value = "/demandes/{id}", method = RequestMethod.GET)
	public Demande getDemandeAvecId(@PathVariable Long id) {
		return demandeService.findOne(id);
	}

	@RequestMapping(value = "/demandes", method = RequestMethod.POST)
	public Demande ajouterDemande(@RequestBody Demande c) {
		return demandeService.save(c);
	}
	
	@RequestMapping(value = "/demandes/{id}", method = RequestMethod.PUT)
	public Demande mettreAJour(@PathVariable Long id,@RequestBody Demande c) {
		c.setIdDemande(id);
		return demandeService.save(c);
	}

	@RequestMapping(value ="/demandes/{id}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		demandeService.delete(id);
		return true;
	}
}
