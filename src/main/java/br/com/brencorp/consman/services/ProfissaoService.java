package br.com.brencorp.consman.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.brencorp.consman.entities.Profissao;
import br.com.brencorp.consman.repositories.ProfissaoRepository;
import br.com.brencorp.consman.services.exceptions.DatabaseException;
import br.com.brencorp.consman.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

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

	public Profissao insert(Profissao obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			if (repository.existsById(id)) {
				repository.deleteById(id);
			} else {
				throw new ResourceNotFoundException(id);
			}
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}

	}

	public Profissao update(Long id, Profissao obj) {
		try {
			Profissao entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Profissao entity, Profissao obj) {
		entity.setnome(obj.getnome());
		entity.setArea(obj.getArea());
	}
}
