package com.mrz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrz.entities.Demande;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {

}
