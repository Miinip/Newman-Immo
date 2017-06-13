package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.BienImmobilier;

@Repository
public class BienImmoDaoImpl implements IBienImmoDao {

	@Autowired
	private SessionFactory sf;

	private Session s;
	
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	public int createBienImmo(BienImmobilier bi) {
		s=sf.getCurrentSession();
		try {
			s.save(bi);
			return 1;
		} catch (Exception ex) {
			return 0;
		}
	}

	public List<BienImmobilier> afficherBienImmo() {
		s=sf.getCurrentSession();
		String req="From BienImmobilier";
		Query query=s.createQuery(req);
		return query.list();
	}

	public BienImmobilier getById(int id) {
		s=sf.getCurrentSession();
		return (BienImmobilier) s.get(BienImmobilier.class, id);
	}
	
	

}
