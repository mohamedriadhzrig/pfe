package com.sopra.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopra.entities.Commentaire;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

}
