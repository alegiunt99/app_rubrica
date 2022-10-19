package com.spring.apprubrica.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.spring.apprubrica.dto.ContattoDTO;



@Entity
public class Rubrica {
	
	@Id
	private int idRubrica;
	
	
	private String proprietario;
	private int annoCreazione;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "FK_Rubrica")
	private List<Contatto> contatti = new ArrayList<>();
	
	public Rubrica() {}

	public Rubrica(int id, String proprietario, int annoCreazione) {
		super();
		this.idRubrica = id;
		this.proprietario = proprietario;
		this.annoCreazione = annoCreazione;
	}


	public int getIdRubrica() {
		return idRubrica;
	}


	public void setIdRubrica(int id) {
		this.idRubrica = id;
	}


	public String getProprietario() {
		return proprietario;
	}


	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}


	public int getAnnoCreazione() {
		return annoCreazione;
	}


	public void setAnnoCreazione(int annoCreazione) {
		this.annoCreazione = annoCreazione;
	}


	public List<Contatto> getContatti() {
		return contatti;
	}


	public void setContatti(List<Contatto> contatti) {
		this.contatti = contatti;
	}
	
//	 METHODS____________________________________________________________
	
	 public boolean inserisciContatto(Contatto contatto){
		for(Contatto c : this.getContatti()) {
			
			if(c.getNome().equals(contatto.getNome()) && c.getCognome().equals(contatto.getCognome()) ) {
				
				return false;
				
			}
			
		}
		
		this.contatti.add(contatto);
		
		return true;
	 }

	public boolean modificaContatto(Contatto contatto) {
		
		for(Contatto c : contatti) {
			if(c.getId() == contatto.getId()) {
				
				c.setNome(contatto.getNome());
				c.setCognome(contatto.getCognome());
				c.setNumero(contatto.getNumero());
				c.setGruppo(contatto.getGruppo());
				c.setDataNascita(contatto.getDataNascita());
				c.setPreferito(contatto.isPreferito());
				return true;
			}
		}
		
		return false;
	}
	

	public boolean cancellaContatto(int id) {
		
		for(Contatto c: this.getContatti()) {

			if(c.getId() == id) {
				
				this.getContatti().remove(c);
				return true;
			}

		}
		
		return false;
		
	}
	

	public List<Contatto> ricercaTuttiContatti() {
		
		return this.getContatti();
	}

	public int calcolaQuantiContatti() {
		
		return this.getContatti().size();
	}

	public Contatto cercaContattoByNomeCongome(String nome, String cognome) {
		
		Contatto contatto = new Contatto();
		
		boolean trovato = false;
		
		for(Contatto c: this.getContatti()) {
			
			if(c.getNome().equals(nome) && c.getCognome().equals(cognome)) {
				contatto = c;
				trovato = true;
			}
			
		}
		
		if(trovato) {
			return contatto; 
		}else {

			return null;
		}
	}
	
	public Contatto cercaContattoByNumero(String numero) {
		
				Contatto contatto = new Contatto();
				
				boolean trovato = false;
				
				for(Contatto c: this.getContatti()) {
					
					if(c.getNumero().equals(numero)) {
						contatto = c;
						trovato = true;
					}
					
				}
		
				if(trovato) {
					return contatto; 
				}else {

					return null;
				}
	}
	
	public List<ContattoDTO> cercaNomeCognomeByGruppo(String gruppo) {
		
		
		List<ContattoDTO> contattiGruppo = new ArrayList<>();
		
		for(Contatto c: this.getContatti()) {
			
			if(c.getGruppo().equals(gruppo)) {
				ContattoDTO contattoDto = new ContattoDTO();
				contattoDto.setNome(c.getNome());
				contattoDto.setCognome(c.getCognome());
				contattiGruppo.add(contattoDto);
			}
			
		}
		
		
		return contattiGruppo;
		
	}
	
	
	public int cercaQuantiContattiByGruppo(String gruppo) {
		
		List<Contatto> contattiGruppo = new ArrayList<>();

		for(Contatto c: this.getContatti()) {

			if(c.getGruppo().equals(gruppo)) {
				
				contattiGruppo.add(c);
			}

		}
		
		return contattiGruppo.size();
		
	}
	
	public boolean  modificaNomeGruppo(String nomeVecchio, String nomeNuovo) {
		
		boolean stato = false;
		
		for(Contatto c: this.getContatti()) {

			if(c.getGruppo().equals(nomeVecchio)) {
				
				System.out.println("Prima " + c.getGruppo());
				
				c.setGruppo(nomeNuovo);
				

				System.out.println("Dopo " + c.getGruppo());
				stato = true;
			}
	}
		
		return stato;
	}
	
	public boolean deleteGruppo(String gruppo) {
		
		boolean eliminato = false;
		
		for(int i = 0; i < this.getContatti().size(); i++) {

			if(this.getContatti().get(i).getGruppo().equals(gruppo)) {
				
				this.getContatti().remove(i);
				
				i--;
				
				eliminato = true;
				
			}

		}
		
		return eliminato;
		
	}
	
	public void setContattoPreferito(int id) {

		for(Contatto c: this.getContatti()) {

			if(c.getId() == id && c.isPreferito() == false) {
				
				c.setPreferito(true);
			}

		}
		
	}
	
	public List<Contatto> findAllPreferiti(){
		
		List<Contatto> contattiPreferiti = new ArrayList<>();
		
		for(Contatto c: this.getContatti()) {

			if(c.isPreferito() == true) {
				contattiPreferiti.add(c);
			}

		}
		
		if(contattiPreferiti.size() > 0) {

			return contattiPreferiti;
		}else {
			
			return null;
		}
	}
	
	
	//_____________________________________________________
	@Override
	public int hashCode() {
		return Objects.hash(this.idRubrica);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rubrica other = (Rubrica) obj;
		return idRubrica == other.idRubrica;
	}


	@Override
	public String toString() {
		return "Rubrica [id=" + idRubrica + ", proprietario=" + proprietario + ", annoCreazione=" + annoCreazione
				+ ", contatti=" + contatti + "]";
	}
	
	
	
	

}
