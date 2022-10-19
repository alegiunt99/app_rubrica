package com.spring.apprubrica.dto;

import java.util.Objects;

public class NumberPhoneDTO {
	
	private String numero;

	public NumberPhoneDTO() {
		super();
	}

	public NumberPhoneDTO(String numero) {
		super();
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumberPhoneDTO other = (NumberPhoneDTO) obj;
		return Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return "NumberPhoneDTO [numero=" + numero + "]";
	}
	
	
}
