package br.com.brencorp.consman.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brencorp.consman.entities.Profissao;
import br.com.brencorp.consman.repositories.ProfissaoRepository;

@Service
public class ProfissaoService {

	@Autowired
	private ProfissaoRepository repository;

	public List<Profissao> findAll() {
		return repository.findAll();
	}

	public Profissao findById(Long id) {
		Optional<Profissao> obj = repository.findById(id);
		return obj.get();
	}
}
