package fr.adaming.model;

import java.util.Date;
import java.util.List;

public class BienImmobilier {

	private int id;
	private byte photo;
	private String statut;
	private ClasseStandard classeStandard;
	private Date dateSoumission;
	private Adresse localisation;
	private Date dateMiseDispo;
	private double revenuCadastral;
	private Conseiller conseiller;
	private List<Client> listeClients;
	private List<Visite> listeVisites;
	private List<Contrat> listeContrats;
	private Proprietaire proprietaire;
	
}
