package br.com.brencorp.consman.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brencorp.consman.entities.FormacaoAcademica;
import br.com.brencorp.consman.repositories.FormacaoAcademicaRepository;

@Service
public class FormacaoAcademicaService {

	@Autowired
	private FormacaoAcademicaRepository repository;

	public List<FormacaoAcademica> findAll() {
		return repository.findAll();
	}

	public FormacaoAcademica findById(Long id) {
		Optional<FormacaoAcademica> obj = repository.findById(id);
		return obj.get();
	}
}
