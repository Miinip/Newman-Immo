package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "conseillers")
@SuppressWarnings("serial")
public class Conseiller extends Personne {

	@Column(name = "username")
	private String login;
	private String password;

	@OneToMany(mappedBy = "conseiller", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<BienImmobilier> ListeGestionDesBien;

	/** Constructeur vide */
	public Conseiller() {
		super();
	}

	/** Constructeur param sans id */
	public Conseiller(String nom, String prenom, int telPro, int telPerso, Adresse adresse, String login,
			String password) {
		super(nom, prenom, telPro, telPerso, adresse);
		this.login = login;
		this.password = password;

	}

	/** Constructeur param avec id */
	public Conseiller(int id, String nom, String prenom, int telPro, int telPerso, Adresse adresse, String login,
			String password) {
		super(id, nom, prenom, telPro, telPerso, adresse);
		this.login = login;
		this.password = password;

	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	@JsonBackReference
	public List<BienImmobilier> getListeGestionDesBien() {
		return ListeGestionDesBien;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setListeGestionDesBien(List<BienImmobilier> listeGestionDesBien) {
		ListeGestionDesBien = listeGestionDesBien;
	}

	@Override
	public String toString() {
		return "Conseiller [login=" + login + ", password=" + password + ", ListeGestionDesBien=" + ListeGestionDesBien
				+ "]";
	}

}
