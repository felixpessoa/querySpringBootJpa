package br.com.teste.query.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.query.api.assemble.DocChaveAssembler;
import br.com.teste.query.api.model.DocChaveModel;
import br.com.teste.query.api.model.input.DocChaveInput;
import br.com.teste.query.domain.model.DocChave;
import br.com.teste.query.domain.repository.DocChaveRepository;
import br.com.teste.query.domain.service.DocChaveService;
import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/dochave")
public class DocChaveController {
	
	private DocChaveService docChaveService;
	private DocChaveAssembler docChaveAssembler;
	private DocChaveRepository docChaveRepository;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DocChaveModel create(@RequestBody DocChaveInput docChaveInput) {
		DocChave newDocChave = docChaveAssembler.toEntity(docChaveInput);
		DocChave createDocChave = docChaveService.create(newDocChave);
		return docChaveAssembler.toModel(createDocChave);
	}
	
	
	@GetMapping
	public List<DocChaveModel> findAll(){
		return docChaveAssembler.toCollectionDTO(docChaveService.findAll());
	}
	
	
	@GetMapping("/{docChaveId}")
	public ResponseEntity<DocChave> findById(@PathVariable Long docChaveId){
		return  docChaveRepository.findById(docChaveId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PutMapping(value = "/{docChaveId}")
	public ResponseEntity<DocChaveModel> update(@PathVariable("docChaveId") Long docChaveId, @RequestBody DocChaveInput docChaveInput){
		DocChaveModel newDocChaveModel = new DocChaveModel(docChaveService.update(docChaveId, docChaveInput));
		return ResponseEntity.ok().body(newDocChaveModel);
	}
	
	
	
	@DeleteMapping(value = "/{docChaveId}")
	public ResponseEntity<Void> delete(@PathVariable("docChaveId") Long docChaveId){
		docChaveService.delete(docChaveId);
		return ResponseEntity.ok().build();
	}
	
	
	
	
	

	
	
	
	
//	@GetMapping("/filtro")
//	public DocChave findByIdDescricao(@RequestParam("descricao") String descricao) {
//		return docChaveRepository.getByDescricao(descricao);
//	}
	
	
//	@GetMapping("/filtro")
//	public Long findByIdDescricao(@RequestParam("descricao") String descricao) {
//		DocChave docChave = docChaveRepository.getByDescricao(descricao);
//		if (docChave != null) {
//			return docChave.getDocChaveId();
//		}
//		return null;
//		
//	}
	
	
	
	
	

}
