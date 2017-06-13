package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienImmobilier;

public interface IBienImmoService {

	/**
	 * toto
	 * 
	 * @param bi
	 */
	public int createBienImmo(BienImmobilier bi);

	public List<BienImmobilier> afficherBienImmo();

	public BienImmobilier getById(int id);

	public int updateBienImmo(BienImmobilier bi);

	public int deleteBienImmo(int id);
}
