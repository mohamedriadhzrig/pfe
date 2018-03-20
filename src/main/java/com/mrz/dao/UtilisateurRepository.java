package com.mrz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrz.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
