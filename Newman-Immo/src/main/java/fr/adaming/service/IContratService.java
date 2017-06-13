package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Contrat;

public interface IContratService {

	
	public int addContrat(Contrat c);
	public List<Contrat> getAllContrat();
	public int updateContrat(Contrat c);
	public int deleteContrat(int id);
	public Contrat getByIdContrat(int id);
}
