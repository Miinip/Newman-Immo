package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contrats")
public class Contrat {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_con")
	private int id;
	
	
	private double prix;
	private Date date;
	private int numeroRef;
	
	@ManyToOne
	private BienImmobilier bien;
	
	
	
	public Contrat() {
		super();
	}



	public Contrat(double prix, Date date, int numeroRef, BienImmobilier bien) {
		super();
		this.prix = prix;
		this.date = date;
		this.numeroRef = numeroRef;
		this.bien = bien;
	}



	public Contrat(int id, double prix, Date date, int numeroRef, BienImmobilier bien) {
		super();
		this.id = id;
		this.prix = prix;
		this.date = date;
		this.numeroRef = numeroRef;
		this.bien = bien;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}



	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}



	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}



	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}



	/**
	 * @return the numeroRef
	 */
	public int getNumeroRef() {
		return numeroRef;
	}



	/**
	 * @param numeroRef the numeroRef to set
	 */
	public void setNumeroRef(int numeroRef) {
		this.numeroRef = numeroRef;
	}



	/**
	 * @return the bien
	 */
	public BienImmobilier getBien() {
		return bien;
	}



	/**
	 * @param bien the bien to set
	 */
	public void setBien(BienImmobilier bien) {
		this.bien = bien;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Contrat [id=" + id + ", prix=" + prix + ", date=" + date + ", numeroRef=" + numeroRef + ", bien=" + bien
				+ "]";
	}
	
	
}
