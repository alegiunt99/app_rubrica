package com.spring.apprubrica.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Indirizzo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIndirizzo;
	
	private String via;
	private int numCivico;
	private int cap;
	private String citta;
	private String provincia;
	
	public Indirizzo() {
		// TODO Auto-generated constructor stub
	}

	public Indirizzo(String via, int numCivico, int cap, String citta, String provincia) {
		super();
		this.via = via;
		this.numCivico = numCivico;
		this.cap = cap;
		this.citta = citta;
		this.provincia = provincia;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public int getNumCivico() {
		return numCivico;
	}

	public void setNumCivico(int numCivico) {
		this.numCivico = numCivico;
	}

	public int getCAP() {
		return this.cap;
	}

	public void setCAP(int cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cap);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Indirizzo other = (Indirizzo) obj;
		return cap == other.cap;
	}

	@Override
	public String toString() {
		return "\t\n via: " + via 
				+ ",\t\n numCivico: " + numCivico 
				+ ",\t\n citta: " + citta 
				+ ",\t\n cap: " + cap 
				+ ",\t\n provincia: "+ provincia ;
	}
	
	
}
