package com.mrz.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Article implements Serializable {

	@Id
	@GeneratedValue
	private Long idArticle;
	private String nomArticle;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateArticle;
	private String type;
	private Long evaluation;
	private String chemin;
	private String description;
	private String statut;
	public Long getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public Date getDateArticle() {
		return dateArticle;
	}
	public void setDateArticle(Date dateArticle) {
		this.dateArticle = dateArticle;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Long evaluation) {
		this.evaluation = evaluation;
	}
	public String getChemin() {
		return chemin;
	}
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Article(String nomArticle, Date dateArticle, String type, Long evaluation, String chemin, String description,
			String statut) {
		super();
		this.nomArticle = nomArticle;
		this.dateArticle = dateArticle;
		this.type = type;
		this.evaluation = evaluation;
		this.chemin = chemin;
		this.description = description;
		this.statut = statut;
	}
	public Article() {
		super();
	}
	
	
	
	
}
