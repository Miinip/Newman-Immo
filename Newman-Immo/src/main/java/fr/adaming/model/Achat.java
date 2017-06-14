package fr.adaming.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Achat extends BienImmobilier{

	public double prixAchat;
	public String Etat;
	
	public Achat() {
		super();
	}

	public Achat(byte[] photo, String statut, Date dateSoumission, Date dateMiseDispo, double revenuCadastral,
			Adresse localisation, double prixAchat, String etat) {
		super(photo, statut, dateSoumission, dateMiseDispo, revenuCadastral, localisation);
		this.prixAchat = prixAchat;
		Etat = etat;
	}

	public Achat(int id, byte[] photo, String statut, Date dateSoumission, Date dateMiseDispo, double revenuCadastral,
			Adresse localisation, double prixAchat, String etat) {
		super(id, photo, statut, dateSoumission, dateMiseDispo, revenuCadastral, localisation);
		this.prixAchat = prixAchat;
		Etat = etat;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public String getEtat() {
		return Etat;
	}

	public void setEtat(String etat) {
		Etat = etat;
	}

	@Override
	public String toString() {
		return "Achat [prixAchat=" + prixAchat + ", Etat=" + Etat + "]";
	}
	
	
}
