package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienImmoDao;
import fr.adaming.model.BienImmobilier;

@Service
@Transactional
public class BienImmoService implements IBienImmoService{

	@Autowired
	private IBienImmoDao bDao;
	
	public void setbDao(IBienImmoDao bDao) {
		this.bDao = bDao;
	}

	public int createBienImmo(BienImmobilier bi) {
		return bDao.createBienImmo(bi);
	}

	public List<BienImmobilier> afficherBienImmo() {
		return bDao.afficherBienImmo();
	}

	public BienImmobilier getById(int id) {
		return bDao.getById(id);
	}
	
	

}
