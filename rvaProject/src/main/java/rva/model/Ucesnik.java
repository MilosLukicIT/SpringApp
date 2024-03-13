package rva.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Ucesnik implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "UCESNIK_ID_GENERATOR", sequenceName = "UCESNIK_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UCESNIK_ID_GENERATOR")
	private long id;
	private String ime;
	private String prezime;
	private String mbr;
	private String status;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ucesnik", cascade = CascadeType.REMOVE)
	private List<Rociste> rociste;
	
	
	public Ucesnik() {
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


	public String getMbr() {
		return mbr;
	}


	public void setMbr(String mbr) {
		this.mbr = mbr;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<Rociste> getRociste() {
		return rociste;
	}


	public void setRociste(List<Rociste> rociste) {
		this.rociste = rociste;
	}
	
	
	
	
}
