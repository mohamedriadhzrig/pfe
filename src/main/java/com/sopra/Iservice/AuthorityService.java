package com.sopra.Iservice;

import java.util.List;

import com.sopra.entities.Authority;

public interface AuthorityService {
  List<Authority> findById(Long id);

  List<Authority> findByname(String name);

}
