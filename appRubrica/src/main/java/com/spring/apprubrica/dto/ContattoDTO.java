package com.spring.apprubrica.dto;

import java.util.Objects;

public class ContattoDTO {
	
	private String nome;
	
	private String cognome;
	
	private String numero;

	private String gruppo;
	
	
	public ContattoDTO() {}

	public ContattoDTO(String nome, String cognome, String numero, String gruppo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
		this.gruppo = gruppo;
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

	@Override
	public int hashCode() {
		return Objects.hash(cognome, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContattoDTO other = (ContattoDTO) obj;
		return Objects.equals(cognome, other.cognome) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "ContattoDTO [nome=" + nome + ", cognome=" + cognome + "]";
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getGruppo() {
		return gruppo;
	}

	public void setGruppo(String gruppo) {
		this.gruppo = gruppo;
	}
	
	
	
}
