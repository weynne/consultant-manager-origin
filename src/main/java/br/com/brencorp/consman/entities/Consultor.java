package br.com.brencorp.consman.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultor")
public class Consultor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String cnpj;
	private String nome;
	private String telefone;
	private String email;
	private String nascimento;

	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;

	@ManyToMany
	@JoinTable(name = "consultor_formacao", joinColumns = @JoinColumn(name = "consultor_id"), inverseJoinColumns = @JoinColumn(name = "formacao_id"))
	private List<FormacaoAcademica> formacoes = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "consultor_profissao", joinColumns = @JoinColumn(name = "consultor_id"), inverseJoinColumns = @JoinColumn(name = "profissao_id"))
	private List<Profissao> profissoes = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "consultor_projetos", joinColumns = @JoinColumn(name = "consultor_id"), inverseJoinColumns = @JoinColumn(name = "projeto_id"))
	private List<Projeto> projetos = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "consultor_cat", joinColumns = @JoinColumn(name = "consultor_id"), inverseJoinColumns = @JoinColumn(name = "cat_id"))
	private List<Cat> cat = new ArrayList<>();

	public Consultor() {
	}

	public Consultor(Long id, String cpf, String cnpj, String nome, String telefone, String email, String nascimento,
			Cidade cidade) {
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

	public List<FormacaoAcademica> getFormacao() {
		return formacoes;
	}

	public List<Profissao> getProfissao() {
		return profissoes;
	}

	public List<Projeto> getProjeto() {
		return projetos;
	}

	public List<Cat> getCat() {
		return cat;
	}

	public int getIdadeAtual() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Period periodo = Period.between(LocalDate.parse(nascimento, formatter), LocalDate.now());
		return periodo.getYears();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consultor other = (Consultor) obj;
		return Objects.equals(id, other.id);
	}

}
