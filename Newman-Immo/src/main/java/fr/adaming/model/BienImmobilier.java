package fr.adaming.model;

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

	@OneToMany
	private List<Visite> listeVisites;
	
	@OneToMany
	private List<Contrat> listeContrats;
	
	@OneToOne
	private ClasseStandard classeStandard;
	
	@OneToOne
	private Proprietaire proprietaire;
	
}
