package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Visite;


public interface IVisiteDao {
	
	public int addVisite(Visite v);

	public List<Visite> getAllVisite();

	public int updateVisite(Visite v);

	public int deleteVisite(int idClient, int idBienImmo);

}
