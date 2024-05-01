package br.com.brencorp.consman.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.brencorp.consman.entities.Projeto;
import br.com.brencorp.consman.repositories.ProjetoRepository;
import br.com.brencorp.consman.services.exceptions.DatabaseException;
import br.com.brencorp.consman.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository repository;

	public List<Projeto> findAll() {
		return repository.findAll();
	}

	public Projeto findById(Long id) {
		Optional<Projeto> obj = repository.findById(id);
		return obj.get();
	}

	public Projeto insert(Projeto obj) {
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

	public Projeto update(Long id, Projeto obj) {
		try {
			Projeto entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Projeto entity, Projeto obj) {
		entity.setDescricaoProjeto(obj.getDescricao());
	}
}
