package rva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.model.Rociste;
import rva.model.Ucesnik;

public interface RocisteRepository extends JpaRepository<Rociste, Long> {

	public abstract List<Rociste> findBySudnicaContainingIgnoreCase(String sudnica);
	List<Rociste> findByUcesnik(Ucesnik ucesnik);
}
