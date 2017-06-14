package fr.adaming.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "proprietaires")
@SuppressWarnings("serial")
public class Proprietaire extends Personne {

	@OneToMany(mappedBy = "proprietaire")
	private List<BienImmobilier> listeBien;

	/** Constructeur vide */
	public Proprietaire() {
		super();
	}

	/** Constructeur param sans id */
	public Proprietaire(String nom, String prenom, String telPro, String telPerso, Adresse adresse) {
		super(nom, prenom, telPro, telPerso, adresse);

	}

	/** Constructeur param avec id */
	public Proprietaire(int id, String nom, String prenom, String telPro, String telPerso, Adresse adresse) {
		super(id, nom, prenom, telPro, telPerso, adresse);
	}

	@JsonIgnoreProperties({ "clientAcquereur", "conseiller", "listeVisites", "listeContrats", "classeStandard",
			"proprietaire" })
	public List<BienImmobilier> getListeBien() {
		return listeBien;
	}

	public void setListeBien(List<BienImmobilier> listeBien) {
		this.listeBien = listeBien;
	}

}
