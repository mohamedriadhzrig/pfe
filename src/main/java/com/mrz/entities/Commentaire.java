package com.mrz.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private int Evaluation;
	@ManyToOne
	private Utilisateur utilisateur;
	
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
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
	public int getEvaluation() {
		return Evaluation;
	}
	public void setEvaluation(int evaluation) {
		Evaluation = evaluation;
	}
	public Commentaire(String contenu, Date dateCommentaire, int i) {
		super();
		this.contenu = contenu;
		this.dateCommentaire = dateCommentaire;
		Evaluation = i;
	}
	
	
	public Commentaire(String contenu, Date dateCommentaire, int evaluation, Utilisateur utilistaur) {
		super();
		this.contenu = contenu;
		this.dateCommentaire = dateCommentaire;
		Evaluation = evaluation;
		this.utilisateur = utilistaur;
	}
	public Commentaire() {
		super();
	}
	
	
	
}
