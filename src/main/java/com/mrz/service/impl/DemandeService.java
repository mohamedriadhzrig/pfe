package com.mrz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrz.Iservice.IDemandeService;
import com.mrz.dao.DemandeRepository;
import com.mrz.entities.Demande;

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
