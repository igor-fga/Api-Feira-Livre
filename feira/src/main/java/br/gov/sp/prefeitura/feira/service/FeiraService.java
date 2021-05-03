package br.gov.sp.prefeitura.feira.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.prefeitura.feira.dto.FeiraCreateAndUpdateDTO;
import br.gov.sp.prefeitura.feira.entity.Feira;
import br.gov.sp.prefeitura.feira.repository.FeiraRepository;

@Service
public class FeiraService {

	private final FeiraRepository repository;

	public FeiraService(FeiraRepository repository) {
		this.repository = repository;
	}

	public Long create(Feira feira) throws Exception {

		try {
			return repository.save(feira).getId();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Feira update(FeiraCreateAndUpdateDTO feira, Long id) throws Exception {
		try {
			Feira feiraDb = getById(id);
			feiraDb.setLongitude(feira.getLongitude());
			feiraDb.setLatitude(feira.getLatitude());
			feiraDb.setSetCens(feira.getSetCens());
			feiraDb.setAreaPopulacao(feira.getAreaPopulacao());
			feiraDb.setCodigoDistrito(feira.getCodigoDistrito());
			feiraDb.setNomeDistrito(feira.getNomeDistrito());
			feiraDb.setCodigoSubPrefeitura(feira.getCodigoSubPrefeitura());
			feiraDb.setSubPrefeitura(feira.getSubPrefeitura());
			feiraDb.setRegiao05(feira.getRegiao05());
			feiraDb.setRegiao08(feira.getRegiao08());
			feiraDb.setNomeFeira(feira.getNomeFeira());
			feiraDb.setRegistro(feira.getRegistro());
			feiraDb.setLogradouro(feira.getLogradouro());
			feiraDb.setNumeroLogradouro(feira.getNumeroLogradouro());
			feiraDb.setBairro(feira.getBairro());
			feiraDb.setReferencia(feira.getReferencia());

			return repository.save(feiraDb);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Feira getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
