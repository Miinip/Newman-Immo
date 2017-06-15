package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienImmoDao;
import fr.adaming.dao.IClientDao;
import fr.adaming.dao.IVisiteDao;
import fr.adaming.model.Visite;

@Service
@Transactional
public class VisiteServiceImpl implements IVisiteService{
	
	@Autowired
	private IVisiteDao visiteDao;
	
	@Autowired
	private IBienImmoDao bDao;
	
	@Autowired
	private IClientDao clDao;
	
	
	
	public void setVisiteDao(IVisiteDao visiteDao) {
		this.visiteDao = visiteDao;
	}
	
	public int addVisite(Visite v) {
		return visiteDao.addVisite(v);
	}
	
	public void setBiDao(IBienImmoDao bDao) {
		this.bDao = bDao;
	}

	public void setClDao(IClientDao clDao) {
		this.clDao = clDao;
	}

	
	
	
	public List<Visite> getAllVisite() {
		return visiteDao.getAllVisite();
	}

	public int updateVisite(Visite v) {
		if(v.getBienImmo()!=null){
			v.setBienImmo(bDao.getById(v.getBienImmo().getId()));;
		}
		if(v.getClientVisiteur()!=null){
			v.setClientVisiteur(clDao.getByIdClient(v.getClientVisiteur().getId()));
		}
		
		return visiteDao.updateVisite(v);
	}

	public int deleteVisite(int id) {
		return visiteDao.deleteVisite(id);
	}

	public Visite getByIdVisite(int id) {
		return visiteDao.getByIdVisite(id);
	}

}
