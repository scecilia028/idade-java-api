package com.cecilia.pm.idadejavaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cecilia.pm.idadejavaapi.model.Pessoa;
import com.cecilia.pm.idadejavaapi.service.PesssoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PesssoaService pessoaService;
	
	/**
	 * @param dataNascimento - data de nascimento 
	 */
	@PostMapping
    public ResponseEntity<Pessoa> post(@RequestParam String dataNascimento)
    {
		Pessoa pessoa = pessoaService.criar(dataNascimento);
		if (pessoa != null) {
			return ResponseEntity.ok(pessoa);
		}
		return ResponseEntity.badRequest().build();
    }

	@GetMapping(value="/{id}")
	public ResponseEntity<Pessoa> getPessoa(@PathVariable(value = "id") String id) {
	    if (pessoaService.buscarPessoa(id) != null) {
			return ResponseEntity.ok(pessoaService.buscarPessoa(id));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public List<Pessoa> Get() {
	    return pessoaService.buscarPessoas();
	}
	
	@GetMapping(value="/idade/{data}")
	public ResponseEntity<String> getIdade(@PathVariable(value = "data") String data) {
		Integer idade = pessoaService.retornarIdade(data);
		if (idade > 0) {
			return ResponseEntity.ok("Possui ".concat(String.valueOf(idade)).concat(" anos"));
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
}
