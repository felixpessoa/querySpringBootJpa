package br.com.teste.query.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DocChave implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long docChaveId;

	private String descricao;

	private String status;

	public DocChave() {
		super();
	}

	public DocChave(Long docChaveId, String descricao, String status) {
		this.docChaveId = docChaveId;
		this.descricao = descricao;
		this.status = status;
	}

	public Long getDocChaveId() {
		return docChaveId;
	}

	public void setDocChaveId(Long docChaveId) {
		this.docChaveId = docChaveId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((docChaveId == null) ? 0 : docChaveId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocChave other = (DocChave) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (docChaveId == null) {
			if (other.docChaveId != null)
				return false;
		} else if (!docChaveId.equals(other.docChaveId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	
	
	
	

}
