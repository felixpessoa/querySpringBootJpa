package br.com.teste.query.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.teste.query.api.model.input.DocChaveInput;
import br.com.teste.query.domain.exception.EntidadeNaoEncontradaException;
import br.com.teste.query.domain.model.DocChave;
import br.com.teste.query.domain.repository.DocChaveRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DocChaveService {

	private DocChaveRepository docChaveRepository;
	

	
	
	
	public DocChave create(DocChave docChave) {
		
		
		if( findByIdDescricao(docChave.getDescricao()) == null) {
			return docChaveRepository.save(new DocChave(null, docChave.getDescricao(), docChave.getStatus()));
		}
		return findByIdDescricao(docChave.getDescricao());
		
	}
	
	
	
	public List<DocChave> findAll() {
		return docChaveRepository.findAll();
	}
	
	public DocChave findById(Long docChaveId) {
	Optional<DocChave> docChave = docChaveRepository.findById(docChaveId);
	return docChave.orElseThrow(() -> new EntidadeNaoEncontradaException("Chave não achada!"));
	}

	
	
	public DocChave update(Long docChaveId, DocChaveInput docChaveInput) {
		DocChave odlDocChave = findById(docChaveId);

		odlDocChave.setDescricao(docChaveInput.getDescricao());
		odlDocChave.setStatus(docChaveInput.getStatus());
		return docChaveRepository.save(odlDocChave);
	}
	
	
	
	
	public void delete(Long docChaveId) {
		DocChave docChave = findById(docChaveId);

		docChaveRepository.delete(docChave);
	}
	
	
public DocChave findByIdDescricao(String descricao) {
			DocChave docChave = docChaveRepository.getByDescricao(descricao);
			if(docChave != null) {
				return docChave;
			}
			return null;
		}

	
	
	
	

}
