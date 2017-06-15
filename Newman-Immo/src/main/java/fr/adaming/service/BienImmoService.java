package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienImmoDao;
import fr.adaming.dao.IClientDao;
import fr.adaming.dao.IConseillerDao;
import fr.adaming.dao.IProprietaireDao;
import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Conseiller;

@Service
@Transactional
public class BienImmoService implements IBienImmoService {

	@Autowired
	private IBienImmoDao bDao;

	@Autowired
	private IClientDao clDao;

	@Autowired
	private IConseillerDao conDao;

	@Autowired
	private IProprietaireDao pDao;

	public void setbDao(IBienImmoDao bDao) {
		this.bDao = bDao;
	}

	public void setClDao(IClientDao clDao) {
		this.clDao = clDao;
	}

	public void setConDao(IConseillerDao conDao) {
		this.conDao = conDao;
	}

	public void setpDao(IProprietaireDao pDao) {
		this.pDao = pDao;
	}

	// methodes
	public int createBienImmo(BienImmobilier bi) {
		return bDao.createBienImmo(bi);
	}

	public List<BienImmobilier> afficherBienImmo() {
		return bDao.afficherBienImmo();
	}

	public BienImmobilier getById(int id) {
		return bDao.getById(id);
	}

	public int updateBienImmo(BienImmobilier bi) {
		bi.setConseiller(conDao.getByIdConseillerDao(bi.getId()));
		bi.setClientAcquereur(clDao.getByIdClient(bi.getId()));
		bi.setProprietaire(pDao.getOnePropbyId(bi.getId()));
		return bDao.updateBienImmo(bi);
	}

	public int deleteBienImmo(int id) {
		return bDao.deleteBienImmo(id);
	}

}
