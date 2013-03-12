package be.intecbrussel.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class Auto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String merk;
	private String model;
	private String motor;
	private BigDecimal prijs;
	
	public Auto() {
		this.merk = "geenMerk";
		this.model = "geenModel";
		this.motor = "geenMotor";
		this.prijs = new BigDecimal(0);		
	}
	
	public Auto(String merk, String model, String motor, BigDecimal prijs) {
		this.merk = merk;
		this.model = model;
		this.motor = motor;
		this.prijs = prijs;
	}
	
	public String getMerk() {
		return merk;
	}
	public void setMerk(String merk) {
		this.merk = merk;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public BigDecimal getPrijs() {
		return prijs;
	}
	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}

}
