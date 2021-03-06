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
import fr.adaming.service.IBienImmoService;

@RestController
@RequestMapping("/bienImmobilier")
public class BienImmoRestController {

	@Autowired
	private IBienImmoService bService;
	
	public void setbService(IBienImmoService bService) {
		this.bService = bService;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/add", method=RequestMethod.POST,consumes="application/json")
	public ResponseEntity addBienImmo(@RequestBody BienImmobilier bi){
		int status = bService.createBienImmo(bi);
		if(status == 1){
			System.out.println("-------- addConseillerRest [OK] --------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("-------- addConseillerRest [BAD_REQUEST] --------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET,produces="application/json")
	public List<BienImmobilier> getAllBienImmo(){
		return bService.afficherBienImmo();
	}
	
	@RequestMapping(value="/one/{id}",method=RequestMethod.GET,produces="application/json")
	public BienImmobilier getByIdBienImmo(@PathVariable("id")int id){
		return bService.getById(id);
		}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT, produces="application/json",consumes="application/json")
	public ResponseEntity updateBienImmo(@RequestBody BienImmobilier bi){
		int status = bService.updateBienImmo(bi);
		if(status == 1){
			System.out.println("-------- addConseillerRest [OK] --------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("-------- addConseillerRest [BAD_REQUEST] --------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity deleteBienImmo(@PathVariable("id") int id){
		int status = bService.deleteBienImmo(id);
		if(status == 1){
			System.out.println("-------- addConseillerRest [OK] --------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("-------- addConseillerRest [BAD_REQUEST] --------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
