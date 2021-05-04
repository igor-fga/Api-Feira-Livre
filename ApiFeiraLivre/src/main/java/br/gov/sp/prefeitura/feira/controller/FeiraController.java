package br.gov.sp.prefeitura.feira.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.prefeitura.feira.dto.FeiraCreateAndUpdateDTO;
import br.gov.sp.prefeitura.feira.entity.Feira;
import br.gov.sp.prefeitura.feira.service.FeiraService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/feiras-livres")
@Api(value = "Feira Livre")
public class FeiraController {

	private static final Logger LOG = LoggerFactory.getLogger(FeiraController.class);

	private final FeiraService service;

	public FeiraController(FeiraService service) {
		this.service = service;
	}

	@ApiOperation(value = "Lista feiras livres por nome")
	@GetMapping
	public ResponseEntity<List<Feira>> findAll(@RequestParam String nomeFeira) throws Exception {
		try {
			LOG.trace("Entrou no metodo findAll");
			LOG.info("Buscou pela Feira: {}", nomeFeira);

			List<Feira> feiras = service.getByNomeFeira(nomeFeira);

			LOG.info("Busca pela feira {} finalizada com sucesso!", nomeFeira);

			return new ResponseEntity<>(feiras, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error("Erro para executar metodo findAll: {}", e.getMessage());
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}

	@ApiOperation(value = "Cria uma nova feira livre")
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody FeiraCreateAndUpdateDTO feira) {
		Map<String, Long> response = new HashMap<>();
		try {
			LOG.trace("Entrou no metodo create");
			LOG.info("Criando a feira: {}", feira.getNomeFeira());

			final Long feiraId = service.create(feira);
			response.put("id", feiraId);

			LOG.info("Feira {} criada com sucesso!", feira.getNomeFeira());

			return new ResponseEntity<>(response, HttpStatus.CREATED);

		} catch (Exception e) {
			LOG.error("Erro para executar metodo create: {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Deleta uma feira livre")
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		try {
			LOG.trace("Entrou no metodo delete");
			LOG.info("Apagando a feira com Id: {}", id);

			service.delete(id);

			LOG.info("Feira com Id {} apagada com sucesso!", id);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} catch (Exception e) {
			LOG.error("Erro para executar metodo delete: {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Atualiza uma feira livre")
	@PatchMapping("{id}")
	public ResponseEntity<Feira> update(@PathVariable Long id, @RequestBody FeiraCreateAndUpdateDTO feira) {
		try {
			LOG.trace("Entrou no metodo update");
			LOG.info("Atualizando a feira com Id: {}", id);

			Feira feiraDb = service.update(feira, id);
			
			LOG.info("Feira com Id {} atualizada com sucesso!", id);

			return new ResponseEntity<>(feiraDb, HttpStatus.OK);
			
		} catch (Exception e) {
			LOG.error("Erro para executar metodo update: {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
