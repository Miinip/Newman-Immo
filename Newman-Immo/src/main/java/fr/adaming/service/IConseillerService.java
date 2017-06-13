package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Conseiller;

public interface IConseillerService {
	public int addConseillerService(Conseiller c);
	public int updateConseillerService(Conseiller c);
	public int deleteConseillerService(int id);
	public List<Conseiller> getAllConseillerService();
	public Conseiller getByIdConseillerService(int id);
}
