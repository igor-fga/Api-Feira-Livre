package br.gov.sp.prefeitura.feira.service;

import org.springframework.stereotype.Service;

import br.gov.sp.prefeitura.feira.entity.Feira;
import br.gov.sp.prefeitura.feira.repository.FeiraRepository;

@Service
public class FeiraService {

	private final FeiraRepository repository;

	public FeiraService(FeiraRepository repository) {
		this.repository = repository;
	}

	public Long Create(Feira feira) throws Exception {

		try {
			return repository.save(feira).getId();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
