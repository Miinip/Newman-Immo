package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Conseiller;
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
		Session s = sf.getCurrentSession();
		Proprietaire prop_rec = (Proprietaire) s.get(Proprietaire.class, prop.getId());
		prop_rec.setNom(prop.getNom());
		prop_rec.setPrenom(prop.getPrenom());
		prop_rec.setTelPerso(prop.getTelPerso());
		prop_rec.setTelPro(prop.getTelPro());
		prop_rec.setAdresse(prop.getAdresse());
		prop_rec.setListeBien(prop.getListeBien());
		return 1;
	}

	public int deleteProprietaire(int id) {
		Session s = sf.getCurrentSession();
		Proprietaire prop =(Proprietaire) s.get(Proprietaire.class, id);
		s.delete(prop);
		return 1;
	}

	public Proprietaire getOnePropbyId(Proprietaire prop) {
		Session s = sf.getCurrentSession();
		Proprietaire prop_rec = (Proprietaire) s.get(Proprietaire.class, prop.getId());
		return prop_rec;
	}

	public List<Proprietaire> getAllProprietaires() {
		Session s = sf.getCurrentSession();
		Query query = s.createQuery("SELECT pr FROM Proprietaire as pr");
		return query.list();
	}

	public int attributePropToConseiller(Proprietaire prop, BienImmobilier bienImmo) {
		Session s = sf.getCurrentSession();
		Query query = s.createQuery("UPDATE Proprietaire prop SET prop.id=:pIdProp WHERE bienImmo.id=:pIdBienImmobilier");
		query.setParameter("pIdProp", prop.getId());
		query.setParameter("pIdBienImmobilier", bienImmo.getId());
		query.executeUpdate();
		return 1;
	}

}
