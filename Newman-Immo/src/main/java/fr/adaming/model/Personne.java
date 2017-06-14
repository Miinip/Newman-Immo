package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Proxy;

@MappedSuperclass
@SuppressWarnings("serial")
public abstract class Personne implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String nom;
	private String prenom;
	private String telPro;
	private String telPerso;

	@Embedded
	private Adresse adresse;

	public Personne() {
		super();
	}

	public Personne(String nom, String prenom, String telPro, String telPerso, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telPro = telPro;
		this.telPerso = telPerso;
		this.adresse = adresse;
	}

	public Personne(int id, String nom, String prenom, String telPro, String telPerso, Adresse adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telPro = telPro;
		this.telPerso = telPerso;
		this.adresse = adresse;
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the telPro
	 */
	public String getTelPro() {
		return telPro;
	}

	/**
	 * @param telPro the telPro to set
	 */
	public void setTelPro(String telPro) {
		this.telPro = telPro;
	}

	/**
	 * @return the telPerso
	 */
	public String getTelPerso() {
		return telPerso;
	}

	/**
	 * @param telPerso the telPerso to set
	 */
	public void setTelPerso(String telPerso) {
		this.telPerso = telPerso;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


}
