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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="bienImmos")
public class BienImmobilier {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_bi")
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
	@JoinColumn(name="client_id", referencedColumnName="id")
	private Client clientAcquereur;
	
	@ManyToOne
	@JoinColumn(name="conseiller_id",referencedColumnName="id")
	private Conseiller conseiller;

	@ManyToMany
	@JoinTable(name="table_assoc_visite_bien",
	joinColumns=@JoinColumn(name="visite_id"),
	inverseJoinColumns=@JoinColumn(name="id_v"))
	private List<Visite> listeVisites;
	
	@OneToMany
	@JoinColumn(name="contrat_id",referencedColumnName="id_con")
	private List<Contrat> listeContrats;
	
	@OneToOne
	@JoinColumn(name="cS_id",referencedColumnName="id_cs")
	private ClasseStandard classeStandard;
	
	@ManyToOne
	@JoinColumn(name="proprio_id", referencedColumnName="id")
	private Proprietaire proprietaire;

	// Constructeur vide
	public BienImmobilier() {
		super();
	}

	// Constructeur param - id
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

	// Constructeur param + id
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

	// Getters et Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateSoumission() {
		return dateSoumission;
	}

	public void setDateSoumission(Date dateSoumission) {
		this.dateSoumission = dateSoumission;
	}

	public Date getDateMiseDispo() {
		return dateMiseDispo;
	}

	public void setDateMiseDispo(Date dateMiseDispo) {
		this.dateMiseDispo = dateMiseDispo;
	}

	public double getRevenuCadastral() {
		return revenuCadastral;
	}

	public void setRevenuCadastral(double revenuCadastral) {
		this.revenuCadastral = revenuCadastral;
	}

	public Adresse getLocalisation() {
		return localisation;
	}

	public void setLocalisation(Adresse localisation) {
		this.localisation = localisation;
	}

	public Client getClientAcquereur() {
		return clientAcquereur;
	}

	public void setClientAcquereur(Client clientAcquereur) {
		this.clientAcquereur = clientAcquereur;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public List<Visite> getListeVisites() {
		return listeVisites;
	}

	public void setListeVisites(List<Visite> listeVisites) {
		this.listeVisites = listeVisites;
	}

	public List<Contrat> getListeContrats() {
		return listeContrats;
	}

	public void setListeContrats(List<Contrat> listeContrats) {
		this.listeContrats = listeContrats;
	}

	public ClasseStandard getClasseStandard() {
		return classeStandard;
	}

	public void setClasseStandard(ClasseStandard classeStandard) {
		this.classeStandard = classeStandard;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	@Override
	public String toString() {
		return "BienImmobilier [id=" + id + ", photo=" + Arrays.toString(photo) + ", statut=" + statut
				+ ", dateSoumission=" + dateSoumission + ", dateMiseDispo=" + dateMiseDispo + ", revenuCadastral="
				+ revenuCadastral + ", localisation=" + localisation + "]";
	}
	
	
	
	
	
}
