package fr.adaming.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "clients")
@SuppressWarnings("serial")
public class Client extends Personne {

	@Fetch(FetchMode.SELECT)
	@OneToMany(orphanRemoval = true, fetch=FetchType.EAGER)
	@JoinColumn(name = "id_cs")
	private List<ClasseStandard> listeVoeux;

	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "clientVisiteur", fetch=FetchType.EAGER)
	private List<Visite> listeVisitePrevue;

	@OneToOne(mappedBy = "clientAcquereur")
	private BienImmobilier bienImmo;

	public Client() {
		super();
	}


	public Client(String nom, String prenom, String telPro, String telPerso, Adresse adresse) {
		super(nom, prenom, telPro, telPerso, adresse);
	}


	public Client(int id, String nom, String prenom, String telPro, String telPerso, Adresse adresse) {
		super(id, nom, prenom, telPro, telPerso, adresse);
	}


	@JsonIgnoreProperties("typeBien")
	public List<ClasseStandard> getListeVoeux() {
		return listeVoeux;
	}

	@JsonIgnoreProperties({"clientVisiteur","bienImmo"})
	public List<Visite> getListeVisitePrevue() {
		return listeVisitePrevue;
	}

	@JsonIgnoreProperties({ "clientAcquereur", "conseiller", "listeVisites", "listeContrats", "classeStandard",
	"proprietaire" })
	public BienImmobilier getBienImmo() {
		return bienImmo;
	}

	public void setListeVoeux(List<ClasseStandard> listeVoeux) {
		this.listeVoeux = listeVoeux;
	}

	public void setListeVisitePrevue(List<Visite> listeVisitePrevue) {
		this.listeVisitePrevue = listeVisitePrevue;
	}

	public void setBienImmo(BienImmobilier bienImmo) {
		this.bienImmo = bienImmo;
	}	
	
}
