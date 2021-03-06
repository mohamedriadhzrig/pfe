package com.sopra.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Demande implements Serializable{

	@Id
	@GeneratedValue
	private Long idDemande;
	private String nomDemande;
	private String Contenu;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDemande;
	private String satus;
	
	@ManyToOne
	private Utilisateur utilisateur;
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Long getIdDemande() {
		return idDemande;
	}
	public void setIdDemande(Long idDemande) {
		this.idDemande = idDemande;
	}
	public String getNomDemande() {
		return nomDemande;
	}
	public void setNomDemande(String nomDemande) {
		this.nomDemande = nomDemande;
	}
	public String getContenu() {
		return Contenu;
	}
	public void setContenu(String contenu) {
		Contenu = contenu;
	}
	public Date getDateDemande() {
		return dateDemande;
	}
	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}
	public String getSatus() {
		return satus;
	}
	public void setSatus(String satus) {
		this.satus = satus;
	}
	public Demande(String nomDemande, String contenu, Date dateDemande, String satus) {
		super();
		this.nomDemande = nomDemande;
		Contenu = contenu;
		this.dateDemande = dateDemande;
		this.satus = satus;
	}
	
	
	public Demande(String nomDemande, String contenu, Date dateDemande, String satus, Utilisateur utilisateur) {
		super();
		this.nomDemande = nomDemande;
		Contenu = contenu;
		this.dateDemande = dateDemande;
		this.satus = satus;
		this.utilisateur = utilisateur;
	}
	public Demande() {
		super();
	}
	
	
}
