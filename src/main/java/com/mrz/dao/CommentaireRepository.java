package com.mrz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrz.entities.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire , Long> {

}
