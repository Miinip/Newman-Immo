package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProprietaireDao;
import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Proprietaire;

@Service
@Transactional
public class ProprietaireServiceImpl implements IProprietaireService{

	@Autowired
	private IProprietaireDao propDao;
	
	/**
	 * @param propDao the propDao to set
	 */
	public void setPropDao(IProprietaireDao propDao) {
		this.propDao = propDao;
	}

	public int createProprietaire(Proprietaire prop) {
		
		return propDao.createProprietaire(prop);
	}

	public int updateProprietaire(Proprietaire prop) {
		
		return propDao.updateProprietaire(prop);
	}

	public int deleteProprietaire(int id) {
		
		return propDao.deleteProprietaire(id);
	}

	public Proprietaire getOnePropbyId(int id) {
		
		return propDao.getOnePropbyId(id);
	}

	public List<Proprietaire> getAllProprietaires() {
		
		return propDao.getAllProprietaires();
	}

	public int attributePropToBienImmo(Proprietaire prop, BienImmobilier bienImmo) {
		
		return propDao.attributePropToBienImmo(prop, bienImmo);
	}

}
