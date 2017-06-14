package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Conseiller;

@Repository
public class ConseillerDaoImpl implements IConseillerDao {

	@Autowired
	private SessionFactory sf;
	private Session s;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public int addConseillerDao(Conseiller c) {
		s = sf.getCurrentSession();
		try {
			s.save(c);
			return 1;
		} catch (Exception ex) {
			return 0;
		}
	}

	public int updateConseillerDao(Conseiller c) {
		s = sf.getCurrentSession();
		try {
			s.saveOrUpdate(c);
			return 1;
		} catch (Exception ex) {
			return 0;
		}
	}

	public int deleteConseillerDao(int id) {
		s = sf.getCurrentSession();
		try {
			s.delete(s.get(Conseiller.class, id));
			return 1;
		} catch (Exception ex) {
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Conseiller> getAllConseillerDao() {
		s = sf.getCurrentSession();
		return s.createQuery("SELECT c FROM Conseiller AS c").list();
	}

	public Conseiller getByIdConseillerDao(int id) {
		s = sf.getCurrentSession();
		return (Conseiller) s.get(Conseiller.class, id);
	}

}
