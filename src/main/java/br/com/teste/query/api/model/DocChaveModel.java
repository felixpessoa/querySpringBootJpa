package br.com.teste.query.api.model;

import java.io.Serializable;

import br.com.teste.query.domain.model.DocChave;

public class DocChaveModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long docChaveId;
	
	private String descricao;
	
	private String status;

	public DocChaveModel() {
		super();
	}

	public DocChaveModel(DocChave docChave) {
		super();
		this.docChaveId = docChave.getDocChaveId();
		this.descricao = docChave.getDescricao();
		this.status = docChave.getStatus();
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
	
	
	

}
