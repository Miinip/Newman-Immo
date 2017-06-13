package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {

	public int createClient(Client cl);

	public List<Client> afficherClient();

	public Client getByIdClient(int id);

	public int updateClient(Client cl);

	public int deleteClient(int id);
	
}
