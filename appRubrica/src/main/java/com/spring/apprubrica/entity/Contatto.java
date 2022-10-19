package com.spring.apprubrica.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contatto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String cognome;
	private String numero;
	
	
	private String gruppo = "default";
	private boolean preferito;
	
	@Temporal(value = TemporalType.DATE)
	private Date dataNascita;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "FK_contatto")
	private List<IndirizzoContatto> indirizzi = new ArrayList<>();
	
	public Contatto() {}
	
	public Contatto(int id, String nome, String cognome, String numero, String gruppo, Date dataNascita) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
		this.gruppo = gruppo;
		this.dataNascita = dataNascita;
		this.preferito = false;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		
		if(numero.length() < 10 || numero.length() > 10) {
			
			throw new ArithmeticException("\nIl numero di telefono deve avere 10 numeri");
			
		}else {
			
			this.numero = numero;
		}
	
	}
	public String getGruppo() {
		return gruppo;
	}
	public void setGruppo(String gruppo) {
		this.gruppo = gruppo;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public boolean isPreferito() {
		return preferito;
	}
	public void setPreferito(boolean preferito) {
		this.preferito = preferito;
	}
	public List<IndirizzoContatto> getIndirizzi() {
		return indirizzi;
	}

	public void setIndirizzi(List<IndirizzoContatto> indirizzi) {
		this.indirizzi = indirizzi;
	}
	// _____________________METHODS_________________________
	
	public boolean aggiungiIndirizzo(IndirizzoContatto indirizzo) {
		
		return this.indirizzi.add(indirizzo);
		
	}
	
	public boolean modificaIndirizzo(IndirizzoContatto indirizzo) {
		
		for(IndirizzoContatto i : this.getIndirizzi()) {
			
			if(i.getIdIndirizzoC() == indirizzo.getIdIndirizzoC()) {
				
				i.setTipo(indirizzo.getTipo());
				i.setIndirizzo(indirizzo.getIndirizzo());
				return true;
			}
			
		}
		
		return false;
		
	}
	
	public boolean eliminaIndirizzo(int id) {
		
		if(this.getIndirizzi().size() > 0) {
			
			for(int i = 0; i < this.getIndirizzi().size(); i++) {
				
				if(i == (id-1)) {
					this.getIndirizzi().remove(i);
					return true;
				}
				
			}
		}
		
		return false;
		
	}
	
	public List<IndirizzoContatto> cercaIndirizziPerTipo(String tipologia) {
		
		List<IndirizzoContatto> listaTipo = new ArrayList<>();
		
		for(IndirizzoContatto ic : this.getIndirizzi()) {
			
			if(ic.getTipo() == tipologia) {
				
				listaTipo.add(ic);
				
			}
			
		}
		
		if(listaTipo.size() > 0) {

			return listaTipo;
		} else {
			return null;
		}
		
	}
	
	public List<IndirizzoContatto> selectAllIndirizzi(){
		
		return this.getIndirizzi();
		
	}
	
	public int countIndirizzi(){
		
		return this.getIndirizzi().size();
		
	}
	
	//_______________________________________________
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contatto other = (Contatto) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Contatto {\t\n id: " + id 
						+ ",\t\n nome: " + nome 
						+ ",\t\n cognome: " + cognome 
						+ ",\t\n numero: " + numero 
						+ ",\t\n gruppo: "+ gruppo 
						+ ",\t\n dataNascita=" + dataNascita 
						+ ",\t\n preferito=" + preferito 
						+ ",\t\n indirizzi=" + indirizzi
						+ "}";
	}
	
	
	
	
}