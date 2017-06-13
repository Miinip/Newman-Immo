package fr.adaming.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "bienImmos")
public class BienImmobilier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bi")
	private int id;
	@Lob
	private byte[] photo;
	private String statut;

	@Temporal(TemporalType.DATE)
	private Date dateSoumission;

	@Temporal(TemporalType.DATE)
	private Date dateMiseDispo;

	private double revenuCadastral;

	@Embedded
	private Adresse localisation;

	@OneToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	private Client clientAcquereur;

	@ManyToOne
	@JoinColumn(name = "conseiller_id", referencedColumnName = "id")
	private Conseiller conseiller;

	@OneToMany(mappedBy = "bienImmo")
	private List<Visite> listeVisites;

	@OneToMany(mappedBy = "bien")
	private List<Contrat> listeContrats;

	@OneToOne
	@JoinColumn(name = "cs_id", referencedColumnName = "id_cs")
	private ClasseStandard classeStandard;

	@ManyToOne
	@JoinColumn(name = "proprio_id", referencedColumnName = "id")
	private Proprietaire proprietaire;

	/** Constructeur vide */
	public BienImmobilier() {
		super();
	}

	/** Constructeur param sans id */
	public BienImmobilier(byte[] photo, String statut, Date dateSoumission, Date dateMiseDispo, double revenuCadastral,
			Adresse localisation) {
		super();
		this.photo = photo;
		this.statut = statut;
		this.dateSoumission = dateSoumission;
		this.dateMiseDispo = dateMiseDispo;
		this.revenuCadastral = revenuCadastral;
		this.localisation = localisation;
	}

	/** Constructeur param avec id */
	public BienImmobilier(int id, byte[] photo, String statut, Date dateSoumission, Date dateMiseDispo,
			double revenuCadastral, Adresse localisation) {
		super();
		this.id = id;
		this.photo = photo;
		this.statut = statut;
		this.dateSoumission = dateSoumission;
		this.dateMiseDispo = dateMiseDispo;
		this.revenuCadastral = revenuCadastral;
		this.localisation = localisation;
	}

	public int getId() {
		return id;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public String getStatut() {
		return statut;
	}

	public Date getDateSoumission() {
		return dateSoumission;
	}

	public Date getDateMiseDispo() {
		return dateMiseDispo;
	}

	public double getRevenuCadastral() {
		return revenuCadastral;
	}

	public Adresse getLocalisation() {
		return localisation;
	}

	@JsonManagedReference
	public Client getClientAcquereur() {
		return clientAcquereur;
	}

	@JsonManagedReference
	public Conseiller getConseiller() {
		return conseiller;
	}

	@JsonBackReference
	public List<Visite> getListeVisites() {
		return listeVisites;
	}

	@JsonBackReference
	public List<Contrat> getListeContrats() {
		return listeContrats;
	}

	@JsonManagedReference
	public ClasseStandard getClasseStandard() {
		return classeStandard;
	}

	@JsonManagedReference
	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public void setDateSoumission(Date dateSoumission) {
		this.dateSoumission = dateSoumission;
	}

	public void setDateMiseDispo(Date dateMiseDispo) {
		this.dateMiseDispo = dateMiseDispo;
	}

	public void setRevenuCadastral(double revenuCadastral) {
		this.revenuCadastral = revenuCadastral;
	}

	public void setLocalisation(Adresse localisation) {
		this.localisation = localisation;
	}

	public void setClientAcquereur(Client clientAcquereur) {
		this.clientAcquereur = clientAcquereur;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public void setListeVisites(List<Visite> listeVisites) {
		this.listeVisites = listeVisites;
	}

	public void setListeContrats(List<Contrat> listeContrats) {
		this.listeContrats = listeContrats;
	}

	public void setClasseStandard(ClasseStandard classeStandard) {
		this.classeStandard = classeStandard;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	@Override
	public String toString() {
		return "BienImmobilier [id=" + id + ", photo=" + Arrays.toString(photo) + ", statut=" + statut
				+ ", dateSoumission=" + dateSoumission + ", dateMiseDispo=" + dateMiseDispo + ", revenuCadastral="
				+ revenuCadastral + ", localisation=" + localisation + ", clientAcquereur=" + clientAcquereur
				+ ", conseiller=" + conseiller + ", listeVisites=" + listeVisites + ", listeContrats=" + listeContrats
				+ ", classeStandard=" + classeStandard + ", proprietaire=" + proprietaire + "]";
	}

}
