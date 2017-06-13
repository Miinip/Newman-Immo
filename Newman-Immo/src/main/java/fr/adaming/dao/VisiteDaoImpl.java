package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Conseiller;
import fr.adaming.model.Visite;

@Repository
public class VisiteDaoImpl implements IVisiteDao{

	@Autowired
	private SessionFactory sf;
	private Session s;
	
	
	
	
	public int addVisite(Visite v) {
		
		s = sf.getCurrentSession();
		try {
			s.save(v);
			return 1;
		} catch (Exception ex) {
			return 0;
		}
	}

//  **************************************************************  //
	public List<Visite> getAllVisite() {

		s = sf.getCurrentSession();
		
		return s.createQuery("SELECT v FROM Visite AS v").list();
	}

//  **************************************************************  //
	public int updateVisite(Visite v) {
		
		s = sf.getCurrentSession();
		try {
			Visite vUpdate = (Visite) s.get(Visite.class);
			vUpdate = v;
			s.saveOrUpdate(vUpdate);
			return 1;
		} catch (Exception ex) {
			return 0;
		}
	}

//  **************************************************************  //
	public int deleteVisite(int idClient, int idBienImmo) {
		
		s = sf.getCurrentSession();
		return 0;
		
	}



}
