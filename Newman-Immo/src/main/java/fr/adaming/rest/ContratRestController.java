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

import fr.adaming.model.Contrat;
import fr.adaming.service.IContratService;

@RestController
@RequestMapping("/contrat")
public class ContratRestController {

	@Autowired
	private IContratService contratService;

	/**
	 * @param contratService the contratService to set
	 */
	public void setContratService(IContratService contratService) {
		this.contratService = contratService;
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/add",method=RequestMethod.POST,consumes="applicaiton/json")
	public ResponseEntity addContratRest (@RequestBody Contrat contrat){
		int status = contratService.addContrat(contrat);
		if(status==1){
			System.out.println("------- addContratRest [OK] ---------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("------- addContratRest [BAD_REQUEST] -------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/update",method=RequestMethod.PUT,consumes="application/json")
	public ResponseEntity updateContratRest (@RequestBody Contrat contrat){
		int status = contratService.updateContrat(contrat);
		if(status==1){
			System.out.println("------- updateContratRest [OK] ---------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("------- updateContratRest [BAD_REQUEST] -------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity deleteContratRest (@PathVariable("id") int id){
		int status = contratService.deleteContrat(id);
		if(status==1){
			System.out.println("------- deleteContratRest [OK] ---------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("------- deleteContratRest [BAD_REQUEST] -------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET,produces="application/json")
	public List<Contrat> getAllContratRest() {
		return contratService.getAllContrat();
	}
	
	
	@RequestMapping(value="/one/{id}",method=RequestMethod.GET, produces="application/json")
	public Contrat getByIdContratRest(@PathVariable("id") int id) {
		return contratService.getByIdContrat(id);
	}
	
}
