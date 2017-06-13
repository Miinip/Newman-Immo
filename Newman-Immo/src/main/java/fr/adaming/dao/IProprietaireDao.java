package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Proprietaire;

public interface IProprietaireDao {

	public int createProprietaire (Proprietaire prop);
	
	public int updateProprietaire (Proprietaire prop);
	
	public int deleteProprietaire (int id);
	
	public Proprietaire getOnePropbyId (Proprietaire prop);
	
	public int attributePropToConseiller (Proprietaire prop, BienImmobilier bienImmo);
	
	public List<Proprietaire> getAllProprietaires();
	
}
