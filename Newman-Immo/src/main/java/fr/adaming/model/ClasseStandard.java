package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "classesStandards")
public class ClasseStandard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cs")
	private int code;
	private String modeOffre;
	private double prix;
	private double superficie;

	@OneToOne(mappedBy = "classeStandard")
	private BienImmobilier typeBien;

	/** Constructeur vide */
	public ClasseStandard() {
		super();
	}

	/** Constructeur param sans code */
	public ClasseStandard(String modeOffre, double prix, double superficie) {
		super();
		this.modeOffre = modeOffre;
		this.prix = prix;
		this.superficie = superficie;
	}

	/** Constructeur param avec code */
	public ClasseStandard(int code, String modeOffre, double prix, double superficie) {
		super();
		this.code = code;
		this.modeOffre = modeOffre;
		this.prix = prix;
		this.superficie = superficie;
	}

	
	public int getCode() {
		return code;
	}

	public String getModeOffre() {
		return modeOffre;
	}

	public double getPrix() {
		return prix;
	}

	public double getSuperficie() {
		return superficie;
	}

	@JsonManagedReference
	public BienImmobilier getTypeBien() {
		return typeBien;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setModeOffre(String modeOffre) {
		this.modeOffre = modeOffre;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public void setTypeBien(BienImmobilier typeBien) {
		this.typeBien = typeBien;
	}

	@Override
	public String toString() {
		return "ClasseStandard [code=" + code + ", modeOffre=" + modeOffre + ", prix=" + prix + ", superficie="
				+ superficie + ", typeBien=" + typeBien + "]";
	}

}
