package com.cecilia.pm.idadejavaapi.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.cecilia.pm.idadejavaapi.mock.PessoaMock;
import com.cecilia.pm.idadejavaapi.model.Pessoa;

@Service
public class PesssoaService {

	public static final PessoaMock mock = new PessoaMock();

	public LocalDate converterStringToLocalDate(String data) {
		Pattern pattern = Pattern.compile("(\\d{2}\\-\\d{2}\\-\\d{4})");
		Matcher matcher = pattern.matcher(data);

		if (matcher.find() == false) {
			return null;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
		return LocalDate.parse(data, formatter);
	}

	/**
	 * @param pessoa - a pessoa que terá a idade calculada
	 * @return retorna a idade do tipo integer
	 */
	public Integer retornarIdade(String pessoaData) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataNascimento = converterStringToLocalDate(pessoaData);

		if (dataNascimento == null) {
			return -1;
		}

		return Period.between(dataNascimento, dataAtual).getYears();
	}

	public Pessoa criar(String dataNascimento) {
		LocalDate dtNascimentoFormatada = converterStringToLocalDate(dataNascimento);
		if (dtNascimentoFormatada != null) {
			return mock.criarPessoa(dtNascimentoFormatada);
		}
		return null;
	}

	public Pessoa buscarPessoa(String id) {
		return mock.getPessoaById(id);
	}

	public List<Pessoa> buscarPessoas() {
		return mock.getPessoas();
	}
}
