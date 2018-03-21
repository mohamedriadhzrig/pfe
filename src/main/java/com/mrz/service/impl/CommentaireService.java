package com.mrz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrz.Iservice.ICommentairService;
import com.mrz.dao.CommentaireRepository;
import com.mrz.entities.Article;
import com.mrz.entities.Commentaire;

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
