package br.com.brencorp.consman.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.brencorp.consman.dto.FormacaoAcademicaDTO;
import br.com.brencorp.consman.entities.FormacaoAcademica;
import br.com.brencorp.consman.repositories.FormacaoAcademicaRepository;
import br.com.brencorp.consman.services.exceptions.DatabaseException;
import br.com.brencorp.consman.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FormacaoAcademicaService {

	@Autowired
	private FormacaoAcademicaRepository repository;

	@Transactional(readOnly = true)
	public List<FormacaoAcademicaDTO> findAll() {
		List<FormacaoAcademica> formacoes = repository.findAll();
		return formacoes.stream().map(FormacaoAcademicaDTO::new).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public FormacaoAcademicaDTO findById(Long id) {
		FormacaoAcademica formacao = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		return new FormacaoAcademicaDTO(formacao);
	}

	@Transactional
	public FormacaoAcademicaDTO insert(FormacaoAcademicaDTO formacaoDTO) {
		ModelMapper modelMapper = new ModelMapper();
		FormacaoAcademica formacao = modelMapper.map(formacaoDTO, FormacaoAcademica.class);
		return new FormacaoAcademicaDTO(repository.save(formacao));
	}

	@Transactional
	public FormacaoAcademicaDTO update(Long id, FormacaoAcademicaDTO formacaoDTO) {
		try {
			FormacaoAcademica formacao = repository.getReferenceById(id);
			updateFormacao(formacao, formacaoDTO);
			return new FormacaoAcademicaDTO(repository.save(formacao));
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateFormacao(FormacaoAcademica formacao, FormacaoAcademicaDTO formacaoDTO) {
		formacao.setNome(formacaoDTO.getNome());
		formacao.setInstituicao(formacaoDTO.getInstituicao());
		formacao.setTipo(formacaoDTO.getTipo());
		formacao.setAnoConclusao(formacaoDTO.getAnoConclusao());
	}

	@Transactional
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
}
