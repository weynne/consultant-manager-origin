package br.com.brencorp.consman.dto;

import br.com.brencorp.consman.entities.Cidade;
import br.com.brencorp.consman.entities.Consultor;

public class ConsultorDTO {

	private Long id;
	private String cpf;
	private String cnpj;
	private String nome;
	private String telefone;
	private String email;
	private String nascimento;
	private Cidade cidade;
	private Integer idadeAtual;
	
	public ConsultorDTO() {
	}

	public ConsultorDTO(Long id, String cpf, String cnpj, String nome, String telefone, String email, String nascimento, Cidade cidade) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.nascimento = nascimento;
		this.cidade = cidade;
	}
	
	public ConsultorDTO(Consultor consultor) {
		id = consultor.getId();
		cpf = consultor.getCpf();
		cnpj = consultor.getCnpj();
		nome = consultor.getNome();
		telefone = consultor.getTelefone();
		email = consultor.getEmail();
		nascimento = consultor.getNascimento();
		cidade = consultor.getCidade();
		idadeAtual = consultor.getIdadeAtual();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Integer getIdadeAtual() {
		return idadeAtual;
	}
}
