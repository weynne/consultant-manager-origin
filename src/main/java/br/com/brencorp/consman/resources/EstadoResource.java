package br.com.brencorp.consman.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brencorp.consman.entities.Estado;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

	@GetMapping
	public ResponseEntity<Estado> findAll() {
		Estado e = new Estado(1L, "PE");
		return ResponseEntity.ok().body(e);
	}
}