package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "conseillers")
@SuppressWarnings("serial")
public class Conseiller extends Personne {

	@Column(name="username")
	private String login;
	private String password;
	
	public Conseiller() {
		super();
	}

	public Conseiller(String nom, String prenom, int telPro, int telPerso, Adresse adresse, String login, String password) {
		super(nom, prenom, telPro, telPerso, adresse);
		this.login = login;
		this.password = password;
	}

	public Conseiller(int id, String nom, String prenom, int telPro, int telPerso, Adresse adresse, String login, String password) {
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

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Conseiller [login=" + login + ", password=" + password + "]";
	}
	
}
