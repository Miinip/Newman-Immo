package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Proprietaire;

public interface IProprietaireDao {

	public int createProprietaire (Proprietaire prop);
	
	public int updateProprietaire (Proprietaire prop);
	
	public int deleteProprietaire (int id);
	
	public Proprietaire getOnePropbyId (Proprietaire prop);
	
	public List<Proprietaire> getAllProprietaires();
	
}
