package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IConseillerDao;
import fr.adaming.model.Conseiller;

@Service
@Transactional
public class ConseillerServiceImpl implements IConseillerService{
	
	@Autowired
	private IConseillerDao conseillerDao;
	
	public void setConseillerDao(IConseillerDao conseillerDao) {
		this.conseillerDao = conseillerDao;
	}

	public int addConseillerService(Conseiller c) {
		return conseillerDao.addConseillerDao(c);
	}

	public int updateConseillerService(Conseiller c) {
		return conseillerDao.updateConseillerDao(c);
	}

	public int deleteConseillerService(int id) {
		return conseillerDao.deleteConseillerDao(id);
	}

	public List<Conseiller> getAllConseillerService() {
		return conseillerDao.getAllConseillerDao();
	}

	public Conseiller getByIdConseillerService(int id) {
		return conseillerDao.getByIdConseillerDao(id);
	}

}
