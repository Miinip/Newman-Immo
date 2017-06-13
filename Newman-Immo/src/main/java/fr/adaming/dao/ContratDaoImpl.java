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

		s = sf.getCurrentSession();
		try {
			s.save(c);
			return 1;
		} catch (Exception ex) {
			return 0;
		}
	}

//  **************************************************************  //
	public List<Contrat> getAllContrat() {

		s = sf.getCurrentSession();
		
		return s.createQuery("SELECT c FROM Contrat AS c").list();
	}

//  **************************************************************  //
	public int updateContrat(Contrat c) {

		s = sf.getCurrentSession();
		try {
			Contrat cUpdate = (Contrat) s.get(Contrat.class, c.getId());
			cUpdate = c;
			s.saveOrUpdate(cUpdate);
			return 1;
		} catch (Exception ex) {
			return 0;
		}
	}

//  **************************************************************  //
	public int deleteContrat(int id) {

		s = sf.getCurrentSession();
		try {
			s.delete(s.get(Contrat.class, id));
			return 1;
		} catch (Exception ex) {
			return 0;
		}
	}

//  **************************************************************  //
	public Contrat getByIdContrat(int id) {

		s = sf.getCurrentSession();
		return (Contrat) s.get(Contrat.class, id);
	}

}
