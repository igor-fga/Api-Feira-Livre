package br.gov.sp.prefeitura.feira.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.prefeitura.feira.entity.Feira;

@Repository
public interface FeiraRepository extends CrudRepository<Feira, Long> {

}
