package fr.adaming.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
