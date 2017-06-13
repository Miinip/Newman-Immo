package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="classesStandards")
@Proxy(lazy = false)
public class ClasseStandard {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cs")
	private int code;
	private String modeOffre;
	private double prix;
	private double superficie;
	
	@OneToOne(mappedBy="classeStandard")
	private BienImmobilier typeBien;

	public ClasseStandard() {
		super();
	}

	public ClasseStandard(String modeOffre, double prix, double superficie) {
		super();
		this.modeOffre = modeOffre;
		this.prix = prix;
		this.superficie = superficie;
	}

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

	public void setCode(int code) {
		this.code = code;
	}

	public String getModeOffre() {
		return modeOffre;
	}

	public void setModeOffre(String modeOffre) {
		this.modeOffre = modeOffre;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public BienImmobilier getTypeBien() {
		return typeBien;
	}

	public void setTypeBien(BienImmobilier typeBien) {
		this.typeBien = typeBien;
	}

	@Override
	public String toString() {
		return "ClasseStandard [code=" + code + ", modeOffre=" + modeOffre + ", prix=" + prix + ", superficie="
				+ superficie + "]";
	}
	
	
}
