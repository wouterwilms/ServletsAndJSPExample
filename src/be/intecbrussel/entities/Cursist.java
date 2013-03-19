package be.intecbrussel.entities;

import java.io.Serializable;

public class Cursist implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int idCursist;
	
	private String naam;
	
	private  int cursisNummer;

	public Cursist () {
		
		this.idCursist = 0;
		
		this.naam = "geenNaam";
		
		this.cursisNummer = 9999;
		
	}
	
	public Cursist(int idCursist, String naam, int cursisNummer) {
		
		this.idCursist = idCursist;
		
		this.naam = naam;
		
		this.cursisNummer = cursisNummer;
		
	}

	public int getIdCursist() {
		return idCursist;
	}

	public void setIdCursist(int idCursist) {
		this.idCursist = idCursist;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public int getCursisNummer() {
		return cursisNummer;
	}

	public void setCursisNummer(int cursisNummer) {
		this.cursisNummer = cursisNummer;
	}	
	
}
