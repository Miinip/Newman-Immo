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

import fr.adaming.model.Visite;
import fr.adaming.service.IVisiteService;

@RestController
@RequestMapping("/visite")
public class VisiteRestController {
	
	@Autowired
	private IVisiteService visiteService;

	public void setVisiteService(IVisiteService visiteService) {
		this.visiteService = visiteService;
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST,consumes="application/json")
	public ResponseEntity addVisiteRest(@RequestBody Visite v) {
		int status = visiteService.addVisite(v);
		if(status == 1){
			System.out.println("-------- addVisiteRest [OK] --------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("-------- addVisiteRest [BAD_REQUEST] --------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT,consumes="application/json")
	public ResponseEntity updateVisiteRest(@RequestBody Visite v) {
		int status = visiteService.updateVisite(v);
		if(status == 1){
			System.out.println("-------- updateVisiteRest [OK] --------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("-------- updateVisiteRest [BAD_REQUEST] --------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity deleteVisiteRest(@PathVariable("id") int id) {
		int status = visiteService.deleteVisite(id);
		if(status == 1){
			System.out.println("-------- deleteVisiteRest [OK] --------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("-------- deleteVisiteRest [BAD_REQUEST] --------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	@RequestMapping(value="/all",method=RequestMethod.GET,produces="application/json")
	public List<Visite> getAllVisiteRest() {
		return visiteService.getAllVisite();
	}
	
	@RequestMapping(value="/one/{id}",method=RequestMethod.GET,produces="application/json")
	public Visite getByIdVisiteRest(@PathVariable("id") int id) {
		return visiteService.getByIdVisite(id);
	}
	

}
