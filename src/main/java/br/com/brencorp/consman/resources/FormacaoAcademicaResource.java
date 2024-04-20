package br.com.brencorp.consman.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brencorp.consman.entities.FormacaoAcademica;
import br.com.brencorp.consman.services.FormacaoAcademicaService;

@RestController
@RequestMapping(value = "/formacoes")
public class FormacaoAcademicaResource {

	@Autowired
	private FormacaoAcademicaService service;

	@GetMapping
	public ResponseEntity<List<FormacaoAcademica>> findAll() {
		List<FormacaoAcademica> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<FormacaoAcademica> findById(@PathVariable Long id) {
		FormacaoAcademica obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}

}