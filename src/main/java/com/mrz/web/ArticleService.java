package com.mrz.web;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrz.dao.ArticleRepository;
import com.mrz.entities.Article;

@RestController
public class ArticleService {
	private ArticleRepository articleRepository;
	@RequestMapping(value="/demandes",method = RequestMethod.GET)
	public List<Article> getArticles(){
		return articleRepository.findAll();
	}

	@RequestMapping(value="/articles/{id}",method = RequestMethod.GET)
	public Article getArticleAvecId(@PathVariable Long id) {
		return articleRepository.findOne(id);
	}
	
	@RequestMapping(value = "/articles", method = RequestMethod.POST)
	public Article ajouterUtilisateur(@RequestBody Article c) {
		return articleRepository.save(c);
	}
	
	@RequestMapping(value = "/articles/{id}", method = RequestMethod.PUT)
	public Article mettreAJour(@PathVariable Long id,@RequestBody Article c) {
		c.setIdArticle(id);
		return articleRepository.save(c);
	}

	@RequestMapping(value ="/articles/{id}", method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		articleRepository.delete(id);
		return true;
	}
}
