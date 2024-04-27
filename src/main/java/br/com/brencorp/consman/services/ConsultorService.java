package br.com.brencorp.consman.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.brencorp.consman.entities.Consultor;
import br.com.brencorp.consman.repositories.ConsultorRepository;
import br.com.brencorp.consman.services.exceptions.DatabaseException;
import br.com.brencorp.consman.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ConsultorService {

	@Autowired
	private ConsultorRepository repository;

	public List<Consultor> findAll() {
		return repository.findAll();
	}

	public Consultor findById(Long id) {
		Optional<Consultor> obj = repository.findById(id);
		return obj.get();
	}

	public Consultor insert(Consultor obj) {
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

	public Consultor update(Long id, Consultor obj) {
		try {
			Consultor entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Consultor entity, Consultor obj) {
		entity.setCpf(obj.getCpf());
		entity.setCnpj(obj.getCnpj());
		entity.setNome(obj.getNome());
		entity.setTelefone(obj.getTelefone());
		entity.setEmail(obj.getEmail());
		entity.setNascimento(obj.getNascimento());
		entity.setCidade(obj.getCidade());
	}
}
