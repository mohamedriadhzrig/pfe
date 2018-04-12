package com.sopra.Iservice;

import java.util.List;

import com.sopra.entities.Article;
import com.sopra.entities.Demande;

public interface IDemandeService {

public Demande save(Demande demande);
	
	public List<Demande> findAll();
	
	public Demande findOne(Long id);
	
	public void delete(Long id);
}
