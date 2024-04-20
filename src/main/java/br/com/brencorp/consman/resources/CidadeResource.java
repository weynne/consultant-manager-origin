package br.com.brencorp.consman.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brencorp.consman.entities.Cidade;
import br.com.brencorp.consman.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {

	@Autowired
	private CidadeService service;

	@GetMapping
	public ResponseEntity<List<Cidade>> findAll() {
		List<Cidade> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cidade> findById(@PathVariable Long id) {
		Cidade obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}

}