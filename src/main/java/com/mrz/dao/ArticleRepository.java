package com.mrz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrz.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
