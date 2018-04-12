package com.sopra.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.Iservice.ICommentairService;
import com.sopra.dao.CommentaireRepository;
import com.sopra.entities.Article;
import com.sopra.entities.Commentaire;

@Service
public class CommentaireService implements ICommentairService{

	@Autowired
	CommentaireRepository commentaireRepository;
	@Override
	public Commentaire save(Commentaire entity) {
		
		return commentaireRepository.save(entity);
	}

	@Override
	public List<Commentaire> findAll() {
		
		return commentaireRepository.findAll();
	}

	@Override
	public Commentaire findOne(Long id) {
		return commentaireRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		commentaireRepository.delete(id);		
	}

}
