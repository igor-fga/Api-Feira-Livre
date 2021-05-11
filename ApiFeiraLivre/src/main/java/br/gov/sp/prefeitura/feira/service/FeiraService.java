package br.gov.sp.prefeitura.feira.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.prefeitura.feira.dto.FeiraCreateAndUpdateDTO;
import br.gov.sp.prefeitura.feira.entity.Feira;
import br.gov.sp.prefeitura.feira.repository.FeiraRepository;

@Service
public class FeiraService {

	private static final Logger LOG = LoggerFactory.getLogger(FeiraService.class);

	private final FeiraRepository repository;

	public FeiraService(FeiraRepository repository) {
		this.repository = repository;
	}

	public Long create(FeiraCreateAndUpdateDTO feiraDto) throws Exception {
		try {
			LOG.trace("Entrou no metodo create");

			Feira feira = new Feira(feiraDto);
			Feira feiraRes = repository.save(feira);

			LOG.trace("Finalizou o metodo create");
			return feiraRes.getId();

		} catch (Exception e) {
			throw new Exception("Error:" + e.getMessage());
		}
	}

	public Feira update(FeiraCreateAndUpdateDTO feira, Long id) throws Exception {
		try {
			LOG.trace("Entrou no metodo update");

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

			Feira feiraResp = repository.save(feiraDb);

			LOG.trace("Finalizou o metodo update");

			return feiraResp;

		} catch (Exception e) {
			throw new Exception("Error:" + e.getMessage());
		}
	}

	public List<Feira> getByNomeFeira(String nomeFeira) throws Exception {
		LOG.trace("Entrou no metodo getByNomeFeira");
		try {
			List<Feira> feira = repository.findByNomeFeira(nomeFeira);
			if (!feira.isEmpty()) {
				LOG.trace("Finalizou o metodo getByNomeFeira");
				return feira;
			} else {
				throw new Exception("Feira livre não encontrada!");
			}
		} catch (Exception e) {
			throw new Exception("Error:" + e.getMessage());
		}
	}

	public void delete(Long id) throws Exception {
		try {
			LOG.trace("Entrou no metodo delete");
			repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
			repository.deleteById(id);
			LOG.trace("Finalizou o metodo delete");
		} catch (Exception e) {
			throw new Exception("Error:" + e.getMessage());
		}
	}

	public Feira getById(Long id) {
		LOG.trace("Entrou no metodo getById");
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
