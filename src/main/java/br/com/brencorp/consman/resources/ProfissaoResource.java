package br.com.brencorp.consman.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brencorp.consman.entities.Profissao;
import br.com.brencorp.consman.services.ProfissaoService;

@RestController
@RequestMapping(value = "/profissoes")
public class ProfissaoResource {

	@Autowired
	private ProfissaoService service;

	@GetMapping
	public ResponseEntity<List<Profissao>> findAll() {
		List<Profissao> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Profissao> findById(@PathVariable Long id) {
		Profissao obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}

}