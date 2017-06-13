package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Visite;

public interface IVisiteService {
	
	public int addVisite(Visite v);
	public List<Visite> getAllVisite();
	public int updateVisite(Visite v);
	public int deleteVisite(int id);
	public Visite getByIdVisite(int id);
}
