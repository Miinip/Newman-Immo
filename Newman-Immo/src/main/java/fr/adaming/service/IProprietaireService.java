package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Proprietaire;

public interface IProprietaireService {

	public int createProprietaire (Proprietaire prop);
	
	public int updateProprietaire (Proprietaire prop);
	
	public int deleteProprietaire (int id);
	
	public Proprietaire getOnePropbyId (int id);
	
	public List<Proprietaire> getAllProprietaires();
	
	public int attributePropToBienImmo (Proprietaire prop, BienImmobilier bienImmo);
}
