package com.mrz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrz.Iservice.IArticleService;
import com.mrz.dao.ArticleRepository;
import com.mrz.entities.Article;
import com.mrz.entities.Commentaire;

@Service
public class ArticleService implements IArticleService{

	
	@Autowired
	ArticleRepository articleRepo;
	
	@Override
	public Article save(Article article) {
		return articleRepo.saveAndFlush(article);
	}

	@Override
	public List<Article> findAll() {
		return articleRepo.findAll();
	}

	@Override
	public Article findOne(Long id) {
		return articleRepo.findOne(id);
	}

	@Override
	public void delete(Long id) {
		articleRepo.delete(id);
	}

	@Override
	public List<Article> findByUser(Long id) {
		
		return articleRepo.chercherLesArticlesDUtilisateur(id);
	}

	

}
