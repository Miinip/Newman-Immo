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

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@RestController
@RequestMapping("/client")
public class ClientRestController {

	@Autowired
	private IClientService clientService;

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/add", method=RequestMethod.POST,consumes="application/json")
	public ResponseEntity addClient(@RequestBody Client cl){
		int status = clientService.createClient(cl);
		if(status == 1){
			System.out.println("-------- addConseillerRest [OK] --------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("-------- addConseillerRest [BAD_REQUEST] --------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET,produces="application/json")
	public List<Client> getAllClient(){
		return clientService.afficherClient();
	}
	
	@RequestMapping(value="/one/{id}",method=RequestMethod.GET,produces="application/json")
	public Client getByIdClient(@PathVariable("id")int id){
		return clientService.getByIdClient(id);
		}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT, produces="application/json",consumes="application/json")
	public ResponseEntity updateClient(@RequestBody Client cl){
		int status = clientService.updateClient(cl);
		if(status == 1){
			System.out.println("-------- addConseillerRest [OK] --------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("-------- addConseillerRest [BAD_REQUEST] --------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE, produces="application/json",consumes="application/json")
	public ResponseEntity deleteClient(@PathVariable("id") int id){
		int status = clientService.deleteClient(id);
		if(status == 1){
			System.out.println("-------- addConseillerRest [OK] --------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("-------- addConseillerRest [BAD_REQUEST] --------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
}
