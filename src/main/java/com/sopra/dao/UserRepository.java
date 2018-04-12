package com.sopra.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.entities.User;

/**
 * Created by fan.jin on 2016-10-15.
 */
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
