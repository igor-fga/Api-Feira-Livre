package br.gov.sp.prefeitura.feira.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

	private final FeiraService service;

	public FeiraController(FeiraService service) {
		this.service = service;
	}

	@ApiOperation(value = "Lista feiras livres por nome")
	@GetMapping
	public List<Feira> findAll(@RequestParam String nomeFeira) throws Exception {
		return service.getByNomeFeira(nomeFeira);
	}

	@ApiOperation(value = "Cria uma nova feira livre")
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody FeiraCreateAndUpdateDTO feira) {
		Map<String, Long> response = new HashMap<>();
		try {
			final Long feiraId = service.create(feira);
			response.put("id", feiraId);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Deleta uma feira livre")
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		try {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
