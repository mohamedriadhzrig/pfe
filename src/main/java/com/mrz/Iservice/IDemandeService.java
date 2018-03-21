package com.mrz.Iservice;

import java.util.List;

import com.mrz.entities.Article;
import com.mrz.entities.Demande;

public interface IDemandeService {

public Demande save(Demande demande);
	
	public List<Demande> findAll();
	
	public Demande findOne(Long id);
	
	public void delete(Long id);
}
