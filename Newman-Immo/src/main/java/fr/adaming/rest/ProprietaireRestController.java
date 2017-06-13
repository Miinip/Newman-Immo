package fr.adaming.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Proprietaire;
import fr.adaming.service.IProprietaireService;

@RestController
@RequestMapping("/proprietaire")
public class ProprietaireRestController {

	private IProprietaireService propService;

	/**
	 * @param propService the propService to set
	 */
	public void setPropService(IProprietaireService propService) {
		this.propService = propService;
	}
	

	@RequestMapping(value="/add",method=RequestMethod.POST,consumes="application/json")
	public ResponseEntity addProprietaireRest (@RequestBody Proprietaire prop){
		int status = propService.createProprietaire(prop);
		if (status==1){
			System.out.println("-------- addProprietaireRest [OK] --------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("-------- addProprietaireRest [BAD_REQUEST] -------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
}
