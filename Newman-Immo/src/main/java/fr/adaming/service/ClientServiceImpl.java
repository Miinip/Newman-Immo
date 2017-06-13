package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDao cDao;
	
	public void setcDao(IClientDao cDao) {
		this.cDao = cDao;
	}

	public int createClient(Client cl) {
		return cDao.createClient(cl);
	}

	public List<Client> afficherClient() {
		return cDao.afficherClient();
	}

	public Client getByIdClient(int id) {		
		return cDao.getByIdClient(id);
	}

	public int updateClient(Client cl) {
		return cDao.updateClient(cl);
	}

	public int deleteClient(int id) {
		return cDao.deleteClient(id);
	}

}
