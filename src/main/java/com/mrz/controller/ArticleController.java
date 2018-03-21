package com.mrz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrz.Iservice.IArticleService;
import com.mrz.dao.ArticleRepository;
import com.mrz.entities.Article;

@RestController
public class ArticleController {
	
	@Autowired
	private IArticleService articleservice;
	
	@RequestMapping(value="/articles",method = RequestMethod.GET)
	public List<Article> getArticles(){
		return articleservice.findAll();
	}

	@RequestMapping(value="/articles/{id}",method = RequestMethod.GET)
	public Article getArticleAvecId(@PathVariable Long id) {
		return articleservice.findOne(id);
	}
	
	@RequestMapping(value = "/articles", method = RequestMethod.POST)
	public Article ajouterUtilisateur(@RequestBody Article c) {
		return articleservice.save(c);
	}
	
	@RequestMapping(value = "/articles/{id}", method = RequestMethod.PUT)
	public Article mettreAJour(@PathVariable Long id,@RequestBody Article c) {
		c.setIdArticle(id);
		return articleservice.save(c);
	}

	@RequestMapping(value ="/articles/{id}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		articleservice.delete(id);
		return true;
	}
}
