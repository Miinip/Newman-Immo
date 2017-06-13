package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Contrat;

@Repository
public class ContratDaoImpl implements IContratDao{

	@Autowired
	private SessionFactory sf;
	private Session s;
	
	
	public int addContrat(Contrat c) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Contrat> getAllContrat() {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateContrat(Contrat c) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteContrat(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Contrat getByIdContrat(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
