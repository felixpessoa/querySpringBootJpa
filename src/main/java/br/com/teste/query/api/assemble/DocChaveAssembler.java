package br.com.teste.query.api.assemble;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.teste.query.api.model.DocChaveModel;
import br.com.teste.query.api.model.input.DocChaveInput;
import br.com.teste.query.domain.model.DocChave;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DocChaveAssembler {

	private ModelMapper modelMapper;
	
	public DocChaveModel toModel(DocChave docChave) {
		return modelMapper.map(docChave, DocChaveModel.class);
	}
	
	public List<DocChaveModel> toCollectionDTO(List<DocChave> docChaves) {
		return docChaves.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	
	public DocChave toEntity(DocChaveInput docChaveInput) {
		return modelMapper.map(docChaveInput, DocChave.class);
	}
	
}
