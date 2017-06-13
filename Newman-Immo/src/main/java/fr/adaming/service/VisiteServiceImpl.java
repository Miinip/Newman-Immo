package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVisiteDao;
import fr.adaming.model.Visite;

@Service
@Transactional
public class VisiteServiceImpl implements IVisiteService{
	
	@Autowired
	private IVisiteDao visiteDao;
	
	public void setVisiteDao(IVisiteDao visiteDao) {
		this.visiteDao = visiteDao;
	}
	
	
	public int addVisite(Visite v) {
		return visiteDao.addVisite(v);
	}

	public List<Visite> getAllVisite() {
		return visiteDao.getAllVisite();
	}

	public int updateVisite(Visite v) {
		return visiteDao.updateVisite(v);
	}

	public int deleteVisite(int id) {
		return visiteDao.deleteVisite(id);
	}

	public Visite getByIdVisite(int id) {
		return visiteDao.getByIdVisite(id);
	}

}
