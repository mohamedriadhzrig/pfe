package com.mrz.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Commentaire implements Serializable {

	@Id
	@GeneratedValue
	private Long idCommentaire;
	private String contenu;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCommentaire;
	private Long Evaluation;
	public Long getIdCommentaire() {
		return idCommentaire;
	}
	public void setIdCommentaire(Long idCommentaire) {
		this.idCommentaire = idCommentaire;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDateCommentaire() {
		return dateCommentaire;
	}
	public void setDateCommentaire(Date dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}
	public Long getEvaluation() {
		return Evaluation;
	}
	public void setEvaluation(Long evaluation) {
		Evaluation = evaluation;
	}
	public Commentaire(String contenu, Date dateCommentaire, Long evaluation) {
		super();
		this.contenu = contenu;
		this.dateCommentaire = dateCommentaire;
		Evaluation = evaluation;
	}
	public Commentaire() {
		super();
	}
	
	
	
}
