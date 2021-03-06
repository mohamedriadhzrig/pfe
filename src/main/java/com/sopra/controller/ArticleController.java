package com.sopra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.Iservice.IArticleService;
import com.sopra.dao.ArticleRepository;
import com.sopra.entities.Article;

@RestController
public class ArticleController {
	
	@Autowired
	private IArticleService articleservice;
	
	@RequestMapping(value = "/articlesUtilisateur", method = RequestMethod.GET)
	public List<Article> chercher(@RequestParam(name = "id") Long id) 
	{
		return articleservice.findByUser(id);
	}
	
	@RequestMapping(value="/articles",method = RequestMethod.GET)
	public List<Article> getArticles(){
		
		
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
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
