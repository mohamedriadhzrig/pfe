package com.sopra.Iservice;

import java.util.List;

import com.sopra.entities.Article;
import com.sopra.entities.Commentaire;

public interface ICommentairService {

public Commentaire save(Commentaire article);
	
	public List<Commentaire> findAll();
	
	public Commentaire findOne(Long id);
	
	public void delete(Long id);
}
