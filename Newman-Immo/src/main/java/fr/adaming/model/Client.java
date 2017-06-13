package fr.adaming.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;


@Entity
@Table(name="clients")
@Proxy(lazy = false)
@SuppressWarnings("serial")
public class Client extends Personne{
	
	@OneToMany(orphanRemoval=true)
	@JoinColumn(name="id_cs")
	private List<ClasseStandard> listeVoeux;
	
	@OneToMany(mappedBy="clientVisiteur")
	private List<Visite> listeVisitePrevue;
	
	@OneToOne(mappedBy="clientAcquereur")
	private BienImmobilier bienImmo;

	public Client() {
		super();
	}

	public Client(String nom, String prenom, int telPro, int telPerso, Adresse adresse) {
		super(nom, prenom, telPro, telPerso, adresse);
	}

	public Client(int id, String nom, String prenom, int telPro, int telPerso, Adresse adresse) {
		super(id, nom, prenom, telPro, telPerso, adresse);
	}

	public List<ClasseStandard> getListeVoeux() {
		return listeVoeux;
	}

	public void setListeVoeux(List<ClasseStandard> listeVoeux) {
		this.listeVoeux = listeVoeux;
	}

	public List<Visite> getListeVisitePrevue() {
		return listeVisitePrevue;
	}

	public void setListeVisitePrevue(List<Visite> listeVisitePrevue) {
		this.listeVisitePrevue = listeVisitePrevue;
	}

	public BienImmobilier getBienImmo() {
		return bienImmo;
	}

	public void setBienImmo(BienImmobilier bienImmo) {
		this.bienImmo = bienImmo;
	}
	
	
	
}
