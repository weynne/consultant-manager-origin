package br.com.brencorp.consman.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brencorp.consman.entities.Cat;
import br.com.brencorp.consman.services.CatService;

@RestController
@RequestMapping(value = "/cat")
public class CatResource {

	@Autowired
	private CatService service;

	@GetMapping
	public ResponseEntity<List<Cat>> findAll() {
		List<Cat> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cat> findById(@PathVariable Long id) {
		Cat obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}

}