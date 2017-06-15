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

import fr.adaming.model.ClasseStandard;
import fr.adaming.service.IClasseStandardService;

@RestController
@RequestMapping("/classeStandard")
public class ClasseStandardRestController {

	@Autowired
	private IClasseStandardService classeStandardService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/add", method=RequestMethod.POST,consumes="application/json")
	public ResponseEntity addClasseStandard(@RequestBody ClasseStandard cs){
		int status = classeStandardService.addClasseStandard(cs);
		if(status == 1){
			System.out.println("-------- addConseillerRest [OK] --------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("-------- addConseillerRest [BAD_REQUEST] --------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET,produces="application/json")
	public List<ClasseStandard> getAllClasseStandard(){
		return classeStandardService.getAllClasseStandard();
	}
	
	@RequestMapping(value="/one/{code}",method=RequestMethod.GET,produces="application/json")
	public ClasseStandard getByIdClasseStandard(@PathVariable("code")int code){
		return classeStandardService.getByIdClasseStandard(code);
		}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/update",method=RequestMethod.PUT, produces="application/json",consumes="application/json")
	public ResponseEntity updateClasseStandard(@RequestBody ClasseStandard cs){
		int status = classeStandardService.updateClasseStandard(cs);
		if(status == 1){
			System.out.println("-------- addConseillerRest [OK] --------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("-------- addConseillerRest [BAD_REQUEST] --------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/delete/{code}",method=RequestMethod.DELETE)
	public ResponseEntity deleteClasseStandard(@PathVariable("code") int code){
		int status = classeStandardService.deleteClasseStandard(code);
		if(status == 1){
			System.out.println("-------- addConseillerRest [OK] --------");
			return new ResponseEntity(HttpStatus.OK);
		}else{
			System.out.println("-------- addConseillerRest [BAD_REQUEST] --------");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
