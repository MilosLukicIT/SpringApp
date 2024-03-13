package rva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.Predmet;
import rva.model.Sud;
import rva.repository.PredmetRepository;

@Service
public class PredmetService {

	
	
	@Autowired
	private PredmetRepository repo;
	
	
	public List<Predmet> getAll(){
		return repo.findAll();
	}
	
	public Optional<Predmet> getById(long id){
		return repo.findById(id);
	}
	
	
	public Optional<List<Predmet>> getByAktivanTrue(){
		Optional<List<Predmet>> lista = Optional.of(repo.findByAktivanTrue());
		return lista;
	}
	
	public Predmet addPredmet(Predmet predmet) {
		return repo.save(predmet);
	}
	
	public boolean existsById(long id) {
		if(getById(id).isPresent()) {
			return true;
		} else
			return false;
	}
	
	public void deleteById(long id) {
		repo.deleteById(id);
	}
	
	public Optional<List<Predmet>> getBySud(Sud sud){
		return Optional.of(repo.findBySud(sud));
	}
	
	
	
}

