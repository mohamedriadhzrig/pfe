package com.mrz.Iservice;

import java.util.List;

import com.mrz.entities.Article;
import com.mrz.entities.Commentaire;

public interface ICommentairService {

public Commentaire save(Commentaire article);
	
	public List<Commentaire> findAll();
	
	public Commentaire findOne(Long id);
	
	public void delete(Long id);
}
