package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProprietaireDao;
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
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteProprietaire(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Proprietaire getOnePropbyId(Proprietaire prop) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Proprietaire> getAllProprietaires() {
		// TODO Auto-generated method stub
		return null;
	}

}
