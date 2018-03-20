package com.mrz.web;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrz.dao.DemandeRepository;
import com.mrz.entities.Demande;


@RestController
public class DemandeService {

	private DemandeRepository demandeRepository;
	
	@RequestMapping(value = "/demandes", method = RequestMethod.GET)
	public List<Demande> getDemandes(){
		return demandeRepository.findAll();
	}

	@RequestMapping(value = "/demandes/{id}", method = RequestMethod.GET)
	public Demande getDemandeAvecId(@PathVariable Long id) {
		return demandeRepository.findOne(id);
	}

	@RequestMapping(value = "/demandes", method = RequestMethod.POST)
	public Demande ajouterDemande(@RequestBody Demande c) {
		return demandeRepository.save(c);
	}
	
	@RequestMapping(value = "/demandes/{id}", method = RequestMethod.PUT)
	public Demande mettreAJour(@PathVariable Long id,@RequestBody Demande c) {
		c.setIdDemande(id);
		return demandeRepository.save(c);
	}

	@RequestMapping(value ="/demandes/{id}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		demandeRepository.delete(id);
		return true;
	}
}
