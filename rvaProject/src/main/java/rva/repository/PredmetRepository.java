package rva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.model.Predmet;
import rva.model.Sud;

public interface PredmetRepository extends JpaRepository<Predmet, Long>{
	
	//Sloj perzistencije - komunicira sa bazom (izvrsava komande) - svi interfejsi
	
	public abstract List<Predmet> findByAktivanTrue();
	List<Predmet> findBySud(Sud sud);
	
}
