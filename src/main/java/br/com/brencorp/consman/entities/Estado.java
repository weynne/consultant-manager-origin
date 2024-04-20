package br.com.brencorp.consman.entities;

import java.io.Serializable;
import java.util.Objects;

public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String uf;

	public Estado() {
	}

	public Estado(Long i, String uf) {
		super();
		this.id = i;
		this.uf = uf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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
		Estado other = (Estado) obj;
		return Objects.equals(id, other.id);
	}
}