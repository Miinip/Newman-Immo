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

import fr.adaming.model.Conseiller;
import fr.adaming.service.IConseillerService;

@RestController
@RequestMapping("/conseiller")
public class ConseillerRestController {
	
	@Autowired
	private IConseillerService conseillerService;

	public void setConseillerService(IConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/add",method=RequestMethod.POST,consumes="application/json")
	public ResponseEntity addConseillerRest(@RequestBody Conseiller c) {
		int status = conseillerService.addConseillerService(c);
		if(status == 1){
			System.out.println("-------- addConseillerRest [OK] --------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("-------- addConseillerRest [BAD_REQUEST] --------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/update",method=RequestMethod.PUT,consumes="application/json")
	public ResponseEntity updateConseillerRest(@RequestBody Conseiller c) {
		int status = conseillerService.updateConseillerService(c);
		if(status == 1){
			System.out.println("-------- updateConseillerRest [OK] --------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("-------- updateConseillerRest [BAD_REQUEST] --------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity deleteConseillerRest(@PathVariable("id") int id) {
		int status = conseillerService.deleteConseillerService(id);
		if(status == 1){
			System.out.println("-------- deleteConseillerRest [OK] --------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("-------- deleteConseillerRest [BAD_REQUEST] --------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value="/all",method=RequestMethod.GET,produces="application/json")
	public List<Conseiller> getAllConseillerRest() {
		return conseillerService.getAllConseillerService();
	}

	@RequestMapping(value="/one/{id}",method=RequestMethod.GET,produces="application/json")
	public Conseiller getByIdConseillerRest(@PathVariable("id") int id) {
		return conseillerService.getByIdConseillerService(id);
	}
	
}
