package com.mrz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrz.entities.Commentaire;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

}
