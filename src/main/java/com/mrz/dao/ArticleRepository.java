package com.mrz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrz.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
