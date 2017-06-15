package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienImmoDao;
import fr.adaming.dao.IContratDao;
import fr.adaming.model.Contrat;

@Service
@Transactional
public class ContratServiceImpl implements IContratService{

	@Autowired
	private IContratDao contratDao;
	
	@Autowired
	private IBienImmoDao bDao;
	
	public void setContratDao(IContratDao contratDao) {
		this.contratDao = contratDao;
	}
	
	public void setbDao(IBienImmoDao bDao) {
		this.bDao = bDao;
	}

	
	public int addContrat(Contrat c) {
		if(c.getBien()!=null){
			c.setBien(bDao.getById(c.getBien().getId()));
		}
		return contratDao.addContrat(c);
	}


	public List<Contrat> getAllContrat() {
		
		return contratDao.getAllContrat();
	}

	public int updateContrat(Contrat c) {
		if(c.getBien()!=null){
		c.setBien(bDao.getById(c.getBien().getId()));
	}
		return contratDao.updateContrat(c);
	}
	public int deleteContrat(int id) {
		
		return contratDao.deleteContrat(id);
	}

	public Contrat getByIdContrat(int id) {
		
		return contratDao.getByIdContrat(id);
	}

}
