package br.gov.sp.prefeitura.feira.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
