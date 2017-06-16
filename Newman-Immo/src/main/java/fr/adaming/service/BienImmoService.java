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
		if(bi.getPhoto()==null){
				bi.setPhoto(bDao.getById(bi.getId()).getPhoto());
		}
		
		if(bi.getConseiller()!=null){
			if(bi.getConseiller().getId()==0){
				bi.setConseiller(null);
			}else{
				bi.setConseiller(conDao.getByIdConseillerDao(bi.getConseiller().getId()));
			}
		}
		if(bi.getClientAcquereur()!=null){
			if(bi.getClientAcquereur().getId()==0){
				bi.setClientAcquereur(null);
			}else{
			bi.setClientAcquereur(clDao.getByIdClient(bi.getClientAcquereur().getId()));
			}
		}
		if(bi.getProprietaire()!=null){
			if(bi.getProprietaire().getId()==0){
				bi.setProprietaire(null);
			}else{
			bi.setProprietaire(pDao.getOnePropbyId(bi.getProprietaire().getId()));
			}
		}
		return bDao.updateBienImmo(bi);
	}

	public int deleteBienImmo(int id) {
		return bDao.deleteBienImmo(id);
	}

}
