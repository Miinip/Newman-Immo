package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Proprietaire;

@Repository
public class ProprietaireDaoImpl implements IProprietaireDao {

	@Autowired
	private SessionFactory sf;
	
	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public int createProprietaire(Proprietaire prop) {
		Session s = sf.getCurrentSession();
		s.save(prop);
		return 1;
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
