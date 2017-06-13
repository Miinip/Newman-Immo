package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Conseiller;

public interface IConseillerDao {
	public int addConseillerDao(Conseiller p);
	public int updateConseillerDao(Conseiller p);
	public int deleteConseillerDao(int id);
	public List<Conseiller> getAllConseillerDao();
	public Conseiller getByIdConseillerDao(int id);
}
