package br.gov.sp.prefeitura.feira.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.prefeitura.feira.entity.Feira;

@Repository
public interface FeiraRepository extends CrudRepository<Feira, Long> {

	@Query("from Feira a where a.nomeFeira like %:nomeFeira%")
	List<Feira> findByNomeFeira(String nomeFeira);

}
