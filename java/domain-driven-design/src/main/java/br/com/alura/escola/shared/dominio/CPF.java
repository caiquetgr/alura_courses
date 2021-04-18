package br.com.alura.escola.shared.dominio;

import java.util.Objects;

public class CPF {

	private String numero;

	public CPF(String numero) {
		if (numero == null ||
				!numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
			throw new IllegalArgumentException("CPF invalido!");
		}
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CPF cpf = (CPF) o;
		return Objects.equals(numero, cpf.numero);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public String toString() {
		return numero;
	}
}
