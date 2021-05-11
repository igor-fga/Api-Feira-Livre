package br.gov.sp.prefeitura.feira.tests.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import br.gov.sp.prefeitura.feira.controller.FeiraController;
import br.gov.sp.prefeitura.feira.dto.FeiraCreateAndUpdateDTO;
import br.gov.sp.prefeitura.feira.entity.Feira;
import br.gov.sp.prefeitura.feira.service.FeiraService;

@SpringBootTest
public class FeiraControllerTest {

	private static final Logger LOG = LoggerFactory.getLogger(FeiraControllerTest.class);
	final int CREATED = 201;
	final int BAD_REQUEST = 400;
	final int UNPROCESSABLE_ENTITY = 422;
	private int NO_CONTENT = 204;

	@InjectMocks
	private FeiraController controller;

	@Mock
	FeiraService service;

	@Mock
	FeiraCreateAndUpdateDTO feiraDto;

	@Before
	public void setup() {
		feiraDto.setLongitude(-46550164L);
		feiraDto.setLatitude(-23558733L);
		feiraDto.setSetCens(355030885000091L);
		feiraDto.setAreaPopulacao(3550308005040L);
		feiraDto.setCodigoDistrito(87);
		feiraDto.setNomeDistrito("VILA CARRÃO");
		feiraDto.setCodigoSubPrefeitura(26);
		feiraDto.setSubPrefeitura("ARICANDUVA-FORMOSA-CARRAO");
		feiraDto.setRegiao05("Leste");
		feiraDto.setRegiao08("Leste 1");
		feiraDto.setNomeFeira("VILA TOP");
		feiraDto.setRegistro("4041-0");
		feiraDto.setLogradouro("RUA MARAGOJIPE");
		feiraDto.setNumeroLogradouro("S/N");
		feiraDto.setBairro("VL FORMOSA");
		feiraDto.setReferencia("TV RUA PRETORIA");

	}

	@Test
	public void testCreateOK() throws Exception {
		LOG.info("Start Test, testCreateOK");
		Mockito.when(service.create(feiraDto)).thenReturn(1L);
		ResponseEntity<Object> response = controller.create(feiraDto);
		assertThat(response.getStatusCodeValue()).isEqualTo(CREATED);
		LOG.info("Test Ok, testCreateOK");
	}

	@Test
	public void testCreateException() {
		LOG.info("Start Test, testCreateException");
		Mockito.when(controller.create(feiraDto))
				.thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));
		ResponseEntity<Object> response = controller.create(feiraDto);
		assertThat(response.getStatusCodeValue()).isEqualTo(BAD_REQUEST);
		LOG.info("Test Ok, testCreateException");
	}

	@Test
	public void testFindOK() throws Exception {
		LOG.info("Start Test, testFindOK");
		String nomeFeira = "Feira01";
		List<Feira> feiras = new ArrayList<>();
		Feira feira = new Feira();
		feira.setNomeFeira("Feira01");
		feiras.add(feira);
		Mockito.when(service.getByNomeFeira(nomeFeira)).thenReturn(feiras);
		ResponseEntity<List<Feira>> response = controller.findAll(nomeFeira);
		assertThat(response.getBody().size()).isEqualTo(1);
		LOG.info("Test Ok, testFindOK");
	}

	@Test
	public void testFindException() throws Exception {
		LOG.info("Start Test, testFindException");
		String nomeFeira = "Feira01";
		Mockito.when(service.getByNomeFeira(nomeFeira))
				.thenThrow(new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY));
		ResponseEntity<List<Feira>> response = controller.findAll(nomeFeira);
		assertThat(response.getStatusCodeValue()).isEqualTo(UNPROCESSABLE_ENTITY);
		LOG.info("Test Ok, testFindException");
	}

	@Test
	public void testDeleteOK() throws Exception {
		LOG.info("Start Test, testDeleteOK");
		ResponseEntity<Object> response = controller.delete(1L);
		assertThat(response.getStatusCodeValue()).isEqualTo(NO_CONTENT);
		LOG.info("Test Ok, testDeleteOK");
	}

	@Test
	public void testDeleteException() throws Exception {
		LOG.info("Start Test, testDeleteException");
		Mockito.when(controller.delete(1L)).thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));
		ResponseEntity<Object> response = controller.delete(1L);
		assertThat(response.getStatusCodeValue()).isEqualTo(BAD_REQUEST);
		LOG.info("Test Ok, testDeleteException");
	}
	
	@Test
	public void testUpdateOK() throws Exception {
		LOG.info("Start Test, testUpdateOK");
		Feira feira = new Feira();
		feira.setId(1L);
		feira.setNomeFeira("Feira01");
		Mockito.when(service.update(feiraDto, 1L)).thenReturn(feira);
		ResponseEntity<Feira> response = controller.update(1L, feiraDto);
		assertThat(response.getBody().getId()).isEqualTo(1L);
		LOG.info("Test Ok, testUpdateOK");
	}
	
	@Test
	public void testUpdateException() throws Exception {
		LOG.info("Start Test, testUpdateException");
		Mockito.when(service.update(feiraDto, 1L)).thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));
		ResponseEntity<Feira> response = controller.update(1L, feiraDto);
		assertThat(response.getStatusCode().value()).isEqualTo(BAD_REQUEST);
		LOG.info("Test Ok, testUpdateException");
	}

}
