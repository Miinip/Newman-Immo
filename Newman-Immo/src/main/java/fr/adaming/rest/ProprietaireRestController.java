package fr.adaming.rest;

import org.springframework.web.bind.annotation.RestController;

import fr.adaming.service.IProprietaireService;

@RestController
public class ProprietaireRestController {

	private IProprietaireService propService;

	/**
	 * @param propService the propService to set
	 */
	public void setPropService(IProprietaireService propService) {
		this.propService = propService;
	}
	

	
	
}
