package br.com.brencorp.consman.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brencorp.consman.entities.Consultor;
import br.com.brencorp.consman.services.ConsultorService;

@RestController
@RequestMapping(value = "/consultores")
public class ConsultorResource {

	@Autowired
	private ConsultorService service;

	@GetMapping
	public ResponseEntity<List<Consultor>> findAll() {
		List<Consultor> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Consultor> findById(@PathVariable Long id) {
		Consultor obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}

}