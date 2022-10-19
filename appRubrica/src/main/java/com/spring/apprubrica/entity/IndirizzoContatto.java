package com.spring.apprubrica.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class IndirizzoContatto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIndirizzoC;
	
	private String tipo;
	

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "FK_indirizzo")
	private Indirizzo indirizzo;
	
	
	public IndirizzoContatto() {
		
	}
	
	public IndirizzoContatto(String tipo, Indirizzo indirizzo) {
		super();
		this.tipo = tipo;
		this.indirizzo = indirizzo;
	}
	

	public int getIdIndirizzoC() {
		return idIndirizzoC;
	}

	public void setIdIndirizzoC(int idIndirizzoC) {
		this.idIndirizzoC = idIndirizzoC;
	}

	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Indirizzo getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	
	@Override
	public String toString() {
		return "{\t\n tipo: " + tipo	 
				+ ",\t\n indirizzo: " + indirizzo 
				+ "\n}";
	}
	
	
	
}
