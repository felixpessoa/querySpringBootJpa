package br.com.teste.query.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.teste.query.domain.model.DocChave;

@Repository
public interface DocChaveRepository extends JpaRepository<DocChave, Long>{

	
	@Query("SELECT e FROM DocChave e WHERE e.descricao =:id ")
	DocChave getByDescricao(@Param("id") String descricao);
	
//	List<DocChave> findByDescricaoContains(String descricao);

//	public List<DocChave> findByIdDescricao(String descricao);
}
