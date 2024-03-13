package rva.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rva.model.Ucesnik;
import rva.service.UcesnikService;


@CrossOrigin
@RestController
public class UcesnikController {

	
	@Autowired
	private UcesnikService service;
	
	
	@GetMapping("/ucesnik")
	public ResponseEntity<List<Ucesnik>> getAllUcesnik(){
		List<Ucesnik> ucesnici = service.gettAll();
		return new ResponseEntity<>(ucesnici, HttpStatus.OK);
	}
	
	
	@GetMapping("/ucesnik/{id}")
	public ResponseEntity<?> getUcesnikById(@PathVariable long id){
		
		if(service.existsById(id)) {
			return ResponseEntity.ok(service.getById(id));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).
					body("Ucesnik with requested ID is not found!");
		}
	}
	
	@GetMapping("/ucesnik/ime/{ime}")
	public ResponseEntity<?> getUcesnikByIme(@PathVariable String ime){
		if(!service.getByIme(ime).get().isEmpty()) {
			return ResponseEntity.ok(service.getByIme(ime));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ucesnik with requested name (" + ime + ") does not exist!");
		}
	}
	
	
	@PostMapping("/ucesnik")
	public ResponseEntity<?> createUcesnik(@RequestBody Ucesnik ucesnik){
		
		Ucesnik savedUcesnik;
		
		if(!service.existsById(ucesnik.getId())) {
			savedUcesnik = service.save(ucesnik);
		} else {
			
			List<Ucesnik> lista = service.gettAll();
			long najvecaVrednost = 1;
			
			for (int i = 0; lista.size() > i; i++) {
				
				if(najvecaVrednost <= lista.get(i).getId()) {
					najvecaVrednost = lista.get(i).getId();
				}
				
				if(i == lista.size() - 1) {
					najvecaVrednost++;
				}
			}
			
			ucesnik.setId(najvecaVrednost);
			savedUcesnik = service.save(ucesnik);
		}
		
		URI uri = URI.create("/ucesnik/" + savedUcesnik.getId());
		return ResponseEntity.created(uri).body(savedUcesnik);
	}
	
	@PutMapping("/ucesnik/{id}")
	public ResponseEntity<?> updateUcesnik(@RequestBody Ucesnik ucesnik, @PathVariable long id){
		
		if(service.existsById(id)) {
			ucesnik.setId(id);
			Ucesnik updatedUcesnik = service.save(ucesnik);
			return ResponseEntity.ok(updatedUcesnik);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource with requested ID: " + id + " has not been found");
		}
	}
	
	
	@DeleteMapping ("/ucesnik/{id}")
	public ResponseEntity<?> deleteUcesnik (@PathVariable long id) {
		
		if(service.existsById(id)) {
			service.deleteById(id);
			return ResponseEntity.ok("Rescourse with ID: " + id + " has been deleted");	
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource with requested ID: " + id + " has not been found");
		}
	}
}
