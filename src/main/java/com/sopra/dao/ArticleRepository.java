package com.sopra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sopra.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

	@Query("select c from Article c where c.utilisateur.idUtilisateur like :x")
	public List<Article> chercherLesArticlesDUtilisateur(@Param("x")Long id);
}
