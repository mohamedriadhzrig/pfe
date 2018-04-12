package com.sopra.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.Iservice.IDemandeService;
import com.sopra.dao.DemandeRepository;
import com.sopra.entities.Demande;

@Service
public class DemandeService implements IDemandeService {

	@Autowired
	DemandeRepository demandeRepository;
	@Override
	public Demande save(Demande demande) {
		
		return demandeRepository.save(demande);
	}

	@Override
	public List<Demande> findAll() {
		
		return demandeRepository.findAll();
	}

	@Override
	public Demande findOne(Long id) {
		
		return demandeRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		demandeRepository.delete(id);
	}

}
