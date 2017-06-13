package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client {
	
	@OneToMany
	private List<ClasseStandard> listeVoeux;
	
	@OneToMany
	private List<Visite> listeVisitePrevue;
	
	@OneToOne(mappedBy="clientAcquereur")
	private BienImmobilier bienImmo;
	
}
