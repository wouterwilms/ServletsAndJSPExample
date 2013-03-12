package be.intecbrussel.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class FilmTicket implements Serializable{
	
	static final long serialVersionUID = 1L;
	
	private String titel;
	private int duur;
	private int score;
	private BigDecimal prijs;
	
	public FilmTicket () {
		this.titel = "eenFilmTitel";
		this.duur = 0;
		this.score = 0;
		this.prijs = new BigDecimal (0);
	}
	
	public FilmTicket(String titel, int duur, int score, BigDecimal prijs) {
		this.titel = titel;
		this.duur = duur;
		this.score = score;
		this.prijs = prijs;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public int getDuur() {
		return duur;
	}
	public void setDuur(int duur) {
		this.duur = duur;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public BigDecimal getPrijs() {
		return prijs;
	}
	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}
	

}
