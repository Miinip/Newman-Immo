package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl implements IClientDao {

	@Autowired
	private SessionFactory sf;

	private Session s;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	public int createClient(Client cl) {
		s = sf.getCurrentSession();
		try {
			s.save(cl);
			return 1;
		} catch (Exception ex) {
			return 0;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Client> afficherClient() {
		s = sf.getCurrentSession();
		return s.createQuery("SELECT FROM Client").list();
	}

	public Client getByIdClient(int id) {
		s = sf.getCurrentSession();
		return (Client) s.get(Client.class, id);
	}

	public int updateClient(Client cl) {
		s = sf.getCurrentSession();
		try {
			s.saveOrUpdate(cl);
			return 1;
		} catch (Exception ex) {
			return 0;
		}
	}

	public int deleteClient(int id) {
		s = sf.getCurrentSession();
		try {
			s.delete(s.get(Client.class, id));
			return 1;
		} catch (Exception ex) {
			return 0;
		}
	}
	
	

}
