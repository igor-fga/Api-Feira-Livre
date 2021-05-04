package br.gov.sp.prefeitura.feira.tests.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.HttpClientErrorException;

import br.gov.sp.prefeitura.feira.controller.FeiraController;
import br.gov.sp.prefeitura.feira.dto.FeiraCreateAndUpdateDTO;

@SpringBootTest
public class FeiraControllerTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(FeiraControllerTest.class);
	final int CREATED = 201;
	final int BAD_REQUEST = 400;
	private MockMvc mockMvc;

	@Autowired
	private FeiraController controller;

	@Mock
	FeiraCreateAndUpdateDTO feiraDto;
	
	@SuppressWarnings("deprecation")
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

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void testCreateOK() {
		LOG.info("Start Test, testCreateOK");
		ResponseEntity<Object> response = controller.create(feiraDto);
		assertThat(response.getStatusCodeValue()).isEqualTo(CREATED);
		LOG.info("Test Ok, testCreateOK");
	}
	
	@Test
	public void testCreateException() {
		LOG.info("Start Test, testCreateException");
		Mockito.when(controller.create(feiraDto)).thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
		ResponseEntity<Object> response = controller.create(feiraDto);
		assertThat(response.getStatusCodeValue()).isEqualTo(BAD_REQUEST);
		LOG.info("Test Ok, testCreateException");
	}

}
