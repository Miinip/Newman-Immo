package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Visite {

	private Date date;
	private Date heure;
	
	@ManyToMany(mappedBy="listeVisites")
	private List<BienImmobilier> listeBienVisite;
	
	@ManyToOne
	private List<Client> listeClientsVisiteurs;
	
	
	// constructeur vide
	public Visite() {
		super();
	}

	// constructeur avec param
	public Visite(Date date, Date heure, List<BienImmobilier> listeBienVisite, List<Client> listeClientsVisiteurs) {
		super();
		this.date = date;
		this.heure = heure;
		this.listeBienVisite = listeBienVisite;
		this.listeClientsVisiteurs = listeClientsVisiteurs;
	}

	
	// Getters & Setters
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Date getHeure() {
		return heure;
	}


	public void setHeure(Date heure) {
		this.heure = heure;
	}


	public List<BienImmobilier> getListeBienVisite() {
		return listeBienVisite;
	}


	public void setListeBienVisite(List<BienImmobilier> listeBienVisite) {
		this.listeBienVisite = listeBienVisite;
	}


	public List<Client> getListeClientsVisiteurs() {
		return listeClientsVisiteurs;
	}


	public void setListeClientsVisiteurs(List<Client> listeClientsVisiteurs) {
		this.listeClientsVisiteurs = listeClientsVisiteurs;
	}


	// toString
	@Override
	public String toString() {
		return "Visite [date=" + date + ", heure=" + heure + ", listeBienVisite=" + listeBienVisite
				+ ", listeClientsVisiteurs=" + listeClientsVisiteurs + "]";
	}
	
	
	
	
}
