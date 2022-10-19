package com.spring.apprubrica.dto;

import java.util.Objects;

public class RubricaDTO {
	
	private String nome;
	private int annoCreazione;
	private int quantiContatti;
	public RubricaDTO() {
		super();
	}
	public RubricaDTO(String nome, int annoCreazione, int quantiContatti) {
		super();
		this.nome = nome;
		this.annoCreazione = annoCreazione;
		this.quantiContatti = quantiContatti;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAnnoCreazione() {
		return annoCreazione;
	}
	public void setAnnoCreazione(int annoCreazione) {
		this.annoCreazione = annoCreazione;
	}
	public int getQuantiContatti() {
		return quantiContatti;
	}
	public void setQuantiContatti(int quantiContatti) {
		this.quantiContatti = quantiContatti;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RubricaDTO other = (RubricaDTO) obj;
		return Objects.equals(nome, other.nome);
	}
	
}
