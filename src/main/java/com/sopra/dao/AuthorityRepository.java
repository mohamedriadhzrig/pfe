package com.sopra.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.entities.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	Authority findByName(String name);
}
