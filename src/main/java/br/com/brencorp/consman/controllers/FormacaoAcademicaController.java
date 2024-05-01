package br.com.brencorp.consman.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.brencorp.consman.dto.FormacaoAcademicaDTO;
import br.com.brencorp.consman.services.FormacaoAcademicaService;

@RestController
@RequestMapping(value = "/formacoes")
public class FormacaoAcademicaController {

	@Autowired
	private FormacaoAcademicaService service;

	@GetMapping
	public ResponseEntity<List<FormacaoAcademicaDTO>> findAll() {
		List<FormacaoAcademicaDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<FormacaoAcademicaDTO> findById(@PathVariable Long id) {
		FormacaoAcademicaDTO formacaoDTO = service.findById(id);
		return ResponseEntity.ok(formacaoDTO);
	}

	@PostMapping
	public ResponseEntity<FormacaoAcademicaDTO> insert(@RequestBody FormacaoAcademicaDTO formacaoDTO) {
		formacaoDTO = service.insert(formacaoDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(formacaoDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(formacaoDTO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<FormacaoAcademicaDTO> update(@PathVariable Long id, @RequestBody FormacaoAcademicaDTO formacaoDTO) {
		formacaoDTO = service.update(id, formacaoDTO);
		return ResponseEntity.ok().body(formacaoDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}