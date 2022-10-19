package com.spring.apprubrica.dto;

public class ErroreDTO {
	
	private String messaggio;
	private String classe;
	
	public ErroreDTO() {
		
	}
	
	public ErroreDTO(String messaggio) {
		super();
		this.messaggio = messaggio;
	}

	public ErroreDTO(String messaggio, String classe) {
		super();
		this.messaggio = messaggio;
		this.classe = classe;
	}


	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
	
}
