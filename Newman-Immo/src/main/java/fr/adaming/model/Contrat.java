package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "contrats")
public class Contrat implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_con")
	private int id;

	private double prix;
	private Date date;
	private int numeroRef;

	@ManyToOne
	@JoinColumn(name = "bien_id", referencedColumnName = "id_bi")
	private BienImmobilier bien;

	/** Constructeur vide */
	public Contrat() {
		super();
	}

	/** Constructeur param sans id */
	public Contrat(double prix, Date date, int numeroRef, BienImmobilier bien) {
		super();
		this.prix = prix;
		this.date = date;
		this.numeroRef = numeroRef;
		this.bien = bien;
	}

	/** Constructeur param avec id */
	public Contrat(int id, double prix, Date date, int numeroRef, BienImmobilier bien) {
		super();
		this.id = id;
		this.prix = prix;
		this.date = date;
		this.numeroRef = numeroRef;
		this.bien = bien;
	}

	public int getId() {
		return id;
	}

	public double getPrix() {
		return prix;
	}

	public Date getDate() {
		return date;
	}

	public int getNumeroRef() {
		return numeroRef;
	}

	@JsonIgnoreProperties({ "clientAcquereur", "conseiller", "listeVisites", "listeContrats", "classeStandard",
			"proprietaire" })
	public BienImmobilier getBien() {
		return bien;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setNumeroRef(int numeroRef) {
		this.numeroRef = numeroRef;
	}

	public void setBien(BienImmobilier bien) {
		this.bien = bien;
	}

	@Override
	public String toString() {
		return "Contrat [id=" + id + ", prix=" + prix + ", date=" + date + ", numeroRef=" + numeroRef + "]";
	}

}
