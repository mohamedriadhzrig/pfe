package com.mrz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrz.entities.Demande;

public interface DemandeRepository extends JpaRepository<Demande, Long> {

}
