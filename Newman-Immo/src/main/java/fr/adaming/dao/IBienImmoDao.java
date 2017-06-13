package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.BienImmobilier;

public interface IBienImmoDao {

	public int createBienImmo(BienImmobilier bi);
	
	public List<BienImmobilier> afficherBienImmo();
	
	public BienImmobilier getById(int id);
	
	public int updateBienImmo(BienImmobilier bi);
	
	public int deleteBienImmo(int id);
}
