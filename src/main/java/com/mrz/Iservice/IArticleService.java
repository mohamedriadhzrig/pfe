package com.mrz.Iservice;

import java.util.List;

import com.mrz.entities.Article;

public interface IArticleService {

	public Article save(Article article);

	public List<Article> findAll();

	public Article findOne(Long id);

	public void delete(Long id);
	
	public List<Article> findByUser(Long id);

}
