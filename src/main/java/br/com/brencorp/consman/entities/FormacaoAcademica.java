package br.com.brencorp.consman.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "formacaoAcademica")
public class FormacaoAcademica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String instituicao;
	private String tipo;
	private Integer anoConclusao;

	@ManyToMany(mappedBy = "formacoes")
	private Set<Consultor> consultores = new HashSet<>();

	public FormacaoAcademica() {
	}

	public FormacaoAcademica(Long id, String nome, String instituicao, String tipo, Integer anoConclusao) {
		super();
		this.id = id;
		this.nome = nome;
		this.instituicao = instituicao;
		this.tipo = tipo;
		this.anoConclusao = anoConclusao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getAnoConclusao() {
		return anoConclusao;
	}

	public void setAnoConclusao(Integer anoConclusao) {
		this.anoConclusao = anoConclusao;
	}

	public Set<Consultor> getConsultores() {
		return consultores;
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
		FormacaoAcademica other = (FormacaoAcademica) obj;
		return Objects.equals(id, other.id);
	}

}
