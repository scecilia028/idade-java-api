package com.cecilia.pm.idadejavaapi.model;

import java.time.LocalDate;

public class Pessoa {
	
	private Long id;
	private LocalDate dataNascimento;
	/* Outros atributos escondidos */
	
	public Pessoa() { }
	 
	public Pessoa(Long id, LocalDate dataNascimento) {
		this.id = id;
		this.dataNascimento = dataNascimento;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
