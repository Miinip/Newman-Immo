package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Visite;

@Repository
public class ClasseStandardDaoImpl implements IClasseStandardDao{

	@Autowired
	private SessionFactory sf;

	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public int addClasseStandard(ClasseStandard cs) {
		Session s = sf.getCurrentSession();
		try {
			s.save(cs);
			return 1;
		} catch(Exception ex){
		return 0;
		}
	}

	public List<ClasseStandard> getAllClasseStandard() {
		Session s = sf.getCurrentSession();
		Query query =s.createQuery("SELECT cs FROM ClasseStandard as cs");
		return query.list();
	}

	public int updateClasseStandard(ClasseStandard cs) {
		Session s = sf.getCurrentSession();
		try{
			ClasseStandard csBD = (ClasseStandard) s.get(ClasseStandard.class, cs.getCode());
			csBD.setCode(cs.getCode());
			csBD.setModeOffre(cs.getModeOffre());
			csBD.setPrix(cs.getPrix());
			csBD.setSuperficie(cs.getSuperficie());
			s.merge(csBD);
			return 1;
		}catch(Exception ex){
		return 0;
		}
	}
	public int deleteClasseStandard(int code) {
		Session s = sf.getCurrentSession();
		try{
			ClasseStandard cs = (ClasseStandard) s.get(ClasseStandard.class, code);
			s.delete(cs);
			return 1;
		}catch(Exception ex){
		return 0;
		}
	}

	public ClasseStandard getByIdClasseStandard(int code) {
		Session s = sf.getCurrentSession();
		ClasseStandard cs = (ClasseStandard) s.get(ClasseStandard.class, code);
		return cs;
	}

}
