package fr.adaming.model;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	
	private String rue;
	private String numero;
	private int codePostal;
	private String localite;
	private String pays;
	
	
	public Adresse() {
		super();
	}


	public Adresse(String rue, String numero, int codePostal, String localite, String pays) {
		super();
		this.rue = rue;
		this.numero = numero;
		this.codePostal = codePostal;
		this.localite = localite;
		this.pays = pays;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public int getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}


	public String getLocalite() {
		return localite;
	}


	public void setLocalite(String localite) {
		this.localite = localite;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", numero=" + numero + ", codePostal=" + codePostal + ", localite=" + localite
				+ ", pays=" + pays + "]";
	}
	
	
	
	
	
	
	

}
