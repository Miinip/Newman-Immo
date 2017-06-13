package fr.adaming.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;


@Entity
@Table(name="proprietaires")
@SuppressWarnings("serial")
public class Proprietaire extends Personne {

	@OneToMany(mappedBy="proprietaire")
	private List<BienImmobilier> listeBien;

	public Proprietaire() {
		super();
	}

	public Proprietaire(String nom, String prenom, int telPro, int telPerso, Adresse adresse,
			List<BienImmobilier> listeBien) {
		super(nom, prenom, telPro, telPerso, adresse);
		this.listeBien = listeBien;
	}

	public Proprietaire(int id, String nom, String prenom, int telPro, int telPerso, Adresse adresse,
			List<BienImmobilier> listeBien) {
		super(id, nom, prenom, telPro, telPerso, adresse);
		this.listeBien = listeBien;
	}

	/**
	 * @return the listeBien
	 */
	public List<BienImmobilier> getListeBien() {
		return listeBien;
	}

	/**
	 * @param listeBien the listeBien to set
	 */
	public void setListeBien(List<BienImmobilier> listeBien) {
		this.listeBien = listeBien;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Proprietaire [listeBien=" + listeBien + ", getId()=" + getId() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getTelPro()=" + getTelPro() + ", getTelPerso()=" + getTelPerso()
				+ ", getAdresse()=" + getAdresse() + "]";
	}
	
	
	
}
