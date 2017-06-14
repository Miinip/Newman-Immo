package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "visites")
public class Visite implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_v")
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Temporal(TemporalType.TIME)
	private Date heure;

	@ManyToOne
	@JoinColumn(name = "bien_id", referencedColumnName = "id_bi")
	private BienImmobilier bienImmo;

	@ManyToOne
	@JoinColumn(name = "clientV_id", referencedColumnName = "id")
	private Client clientVisiteur;

	/** Constructeur vide */
	public Visite() {
		super();
	}

	/** Constructeur param sans id */
	public Visite(Date date, Date heure, BienImmobilier bienImmo, Client clientVisiteur) {
		super();
		this.date = date;
		this.heure = heure;
		this.bienImmo = bienImmo;
		this.clientVisiteur = clientVisiteur;
	}

	/** Constructeur param avec id */
	public Visite(int id, Date date, Date heure, BienImmobilier bienImmo, Client clientVisiteur) {
		super();
		this.id = id;
		this.date = date;
		this.heure = heure;
		this.bienImmo = bienImmo;
		this.clientVisiteur = clientVisiteur;
	}

	// Getters & Setters
	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public Date getHeure() {
		return heure;
	}

	@JsonIgnoreProperties({ "clientAcquereur", "conseiller", "listeVisites", "listeContrats", "classeStandard",
			"proprietaire" })
	public BienImmobilier getBienImmo() {
		return bienImmo;
	}

	@JsonIgnoreProperties({ "listeVoeux", "listeVisitePrevue", "bienImmo" })
	public Client getClientVisiteur() {
		return clientVisiteur;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setHeure(Date heure) {
		this.heure = heure;
	}

	public void setBienImmo(BienImmobilier bienImmo) {
		this.bienImmo = bienImmo;
	}

	public void setClientVisiteur(Client clientVisiteur) {
		this.clientVisiteur = clientVisiteur;
	}

}
