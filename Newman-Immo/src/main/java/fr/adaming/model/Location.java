package fr.adaming.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Location extends BienImmobilier {

	public double caution;
	public double loyer;
	public double charge;
	public String bail;
	public String garniture;
	

	public Location() {
		super();
	}


	public Location(byte[] photo, String statut, Date dateSoumission, Date dateMiseDispo, double revenuCadastral,
			Adresse localisation, double caution, double loyer, double charge, String bail, String garniture) {
		super(photo, statut, dateSoumission, dateMiseDispo, revenuCadastral, localisation);
		this.caution = caution;
		this.loyer = loyer;
		this.charge = charge;
		this.bail = bail;
		this.garniture = garniture;
	}


	public Location(int id, byte[] photo, String statut, Date dateSoumission, Date dateMiseDispo,
			double revenuCadastral, Adresse localisation, double caution, double loyer, double charge, String bail,
			String garniture) {
		super(id, photo, statut, dateSoumission, dateMiseDispo, revenuCadastral, localisation);
		this.caution = caution;
		this.loyer = loyer;
		this.charge = charge;
		this.bail = bail;
		this.garniture = garniture;
	}


	public double getCaution() {
		return caution;
	}


	public void setCaution(double caution) {
		this.caution = caution;
	}


	public double getLoyer() {
		return loyer;
	}


	public void setLoyer(double loyer) {
		this.loyer = loyer;
	}


	public double getCharge() {
		return charge;
	}


	public void setCharge(double charge) {
		this.charge = charge;
	}


	public String getBail() {
		return bail;
	}


	public void setBail(String bail) {
		this.bail = bail;
	}


	public String getGarniture() {
		return garniture;
	}


	public void setGarniture(String garniture) {
		this.garniture = garniture;
	}


	@Override
	public String toString() {
		return "Location [caution=" + caution + ", loyer=" + loyer + ", charge=" + charge + ", bail=" + bail
				+ ", garniture=" + garniture + "]";
	}
	
	
}
