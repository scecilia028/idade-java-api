package com.cecilia.pm.idadejavaapi.mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cecilia.pm.idadejavaapi.model.Pessoa;

public class PessoaMock {

	/** lista de pessoas mockadas */
	public final List<Pessoa> banco = new ArrayList<>();

	public PessoaMock() {
		Pessoa pessoaMock = new Pessoa(Long.valueOf("0"), LocalDate.of(2000, 1, 1));
		banco.add(pessoaMock);
	}

	public Pessoa getPessoaById(String paramId) {
		try{
			Long id = Long.parseLong(paramId);
			for (Pessoa pessoa : banco) {
				if (pessoa.getId() != null && id != null && pessoa.getId().equals(id)) {
					return pessoa;
				}
			}
		
		}catch(NumberFormatException e) {
			return null;
		}
		return null;
	}

	public Pessoa criarPessoa(LocalDate dataNascimento) {
		Pessoa pessoa = new Pessoa(Long.valueOf(banco.size()), dataNascimento);
		banco.add(pessoa);
		return pessoa;
	}

	public List<Pessoa> getPessoas() {
		return banco;
	}
	
}
