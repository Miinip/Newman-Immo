package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Visite {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_v")
	private int id;
	private Date date;
	private Date heure;
	
	@ManyToOne
	@JoinColumn(name="bien_id", referencedColumnName="id_bi")
	private BienImmobilier bienImmo;
	
	@ManyToOne
	private List<Client> listeClientsVisiteurs;
	
	
	// constructeur vide
	public Visite() {
		super();
	}


	// constructeur sans id avec param
	public Visite(Date date, Date heure, BienImmobilier bienImmo, List<Client> listeClientsVisiteurs) {
		super();
		this.date = date;
		this.heure = heure;
		this.bienImmo = bienImmo;
		this.listeClientsVisiteurs = listeClientsVisiteurs;
	}
	
	// constructeur avec id avec param
	public Visite(int id, Date date, Date heure, BienImmobilier bienImmo, List<Client> listeClientsVisiteurs) {
		super();
		this.id = id;
		this.date = date;
		this.heure = heure;
		this.bienImmo = bienImmo;
		this.listeClientsVisiteurs = listeClientsVisiteurs;
	}

	
	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
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
	

	public BienImmobilier getBienImmo() {
		return bienImmo;
	}


	public void setBienImmo(BienImmobilier bienImmo) {
		this.bienImmo = bienImmo;
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
		return "Visite [id=" + id + ", date=" + date + ", heure=" + heure + ", bienImmo=" + bienImmo
				+ ", listeClientsVisiteurs=" + listeClientsVisiteurs + "]";
	}



}
