package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Conseiller;
import fr.adaming.model.Proprietaire;
import fr.adaming.service.IProprietaireService;

@RestController
@RequestMapping("/proprietaire")
public class ProprietaireRestController {

	@Autowired
	private IProprietaireService propService;

	/**
	 * @param propService the propService to set
	 */
	public void setPropService(IProprietaireService propService) {
		this.propService = propService;
	}
	

	@SuppressWarnings("rawtypes")
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
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/update",method=RequestMethod.PUT,consumes="application/json")
	public ResponseEntity updateProprietaireRest(@RequestBody Proprietaire prop) {
		int status = propService.updateProprietaire(prop);
		if(status == 1){
			System.out.println("-------- updateProprietaireRest [OK] --------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("-------- updateProprietaireRest [BAD_REQUEST] --------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity deleteProprietaireRest(@PathVariable("id") int id) {
		int status = propService.deleteProprietaire(id);
		if(status == 1){
			System.out.println("-------- deleteProprietaireRest [OK] --------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("-------- deleteProprietaireRest [BAD_REQUEST] --------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET,produces="application/json")
	public List<Proprietaire> getAllProprietaireRest() {
		return propService.getAllProprietaires();
	}

	@RequestMapping(value="/one/{id}",method=RequestMethod.GET,produces="application/json")
	public Proprietaire getByIdProprietaireRest(@PathVariable("id") int id) {
		return propService.getOnePropbyId(id);
	}
	
	
}
