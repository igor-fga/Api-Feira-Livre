package br.gov.sp.prefeitura.feira.tests.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import br.gov.sp.prefeitura.feira.dto.FeiraCreateAndUpdateDTO;
import br.gov.sp.prefeitura.feira.entity.Feira;
import br.gov.sp.prefeitura.feira.repository.FeiraRepository;
import br.gov.sp.prefeitura.feira.service.FeiraService;

@SpringBootTest
public class FeiraServiceTest {

	private static final Logger LOG = LoggerFactory.getLogger(FeiraServiceTest.class);

	@InjectMocks
	FeiraService service;

	@Mock
	FeiraRepository repository;

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
		Feira feiraRes = new Feira();
		feiraRes.setId(1L);
		Mockito.when(repository.save(Mockito.any())).thenReturn(feiraRes);
		Long id = service.create(feiraDto);
		assertThat(id).isEqualTo(1L);
		LOG.info("Test Ok, testCreateOK");
	}

	@Test
	public void testCreateException() throws Exception {
		LOG.info("Start Test, testCreateOK");

		Exception exception = Assertions.assertThrows(Exception.class, () -> {
			service.create(feiraDto);
		});

		assertTrue(exception.getMessage().contains("Error:"));
		LOG.info("Test Ok, testCreateException");
	}

	@Test
	public void testUpdateOK() throws Exception {
		LOG.info("Start Test, testUpdateOK");
		Feira feira = new Feira();
		feira.setId(1L);
		Mockito.when(repository.findById(1L)).thenReturn(Optional.of(feira));
		Mockito.when(repository.save(Mockito.any())).thenReturn(feira);
		Feira feiraResp = service.update(feiraDto, 1L);
		assertThat(feiraResp.getId()).isEqualTo(1L);
		LOG.info("Test Ok, testUpdateOK");
	}

	@Test
	public void testUpdateException() throws Exception {
		LOG.info("Start Test, testUpdateException");

		Exception exception = Assertions.assertThrows(Exception.class, () -> {
			service.update(feiraDto, 1L);
		});

		assertTrue(exception.getMessage().contains("Error:"));
		LOG.info("Test Ok, testUpdateException");
	}

	@Test
	public void testGetByNomeFeiraOK() throws Exception {
		LOG.info("Start Test, testGetByNomeFeiraOK");
		String nomeFeira = "Feira01";
		List<Feira> feiras = new ArrayList<>();
		Feira feira = new Feira();
		feira.setNomeFeira("Feira01");
		feiras.add(feira);
		List<Feira> feirasResp = new ArrayList<>();
		Mockito.when(repository.findByNomeFeira(nomeFeira)).thenReturn(feiras);
		feirasResp = service.getByNomeFeira(nomeFeira);
		assertThat(feirasResp.size()).isEqualTo(1);
		LOG.info("Test Ok, testGetByNomeFeiraOK");
	}

	@Test
	public void testGetByNomeFeiraException() throws Exception {
		LOG.info("Start Test, testGetByNomeFeiraException");
		String nomeFeira = "Feira01";

		Exception exception = Assertions.assertThrows(Exception.class, () -> {
			service.getByNomeFeira(nomeFeira);
		});

		assertTrue(exception.getMessage().contains("Error:"));
		LOG.info("Test Ok, testGetByNomeFeiraException");
	}

	@Test
	public void testDeleteOK() throws Exception {
		LOG.info("Start Test, testDeleteOK");
		Feira feira = new Feira();
		feira.setId(1L);
		Mockito.when(repository.findById(1L)).thenReturn(Optional.of(feira));
		service.delete(1L);
		assertTrue(true);
		LOG.info("Test Ok, testDeleteOK");
	}

	@Test
	public void testDeleteException() throws Exception {
		LOG.info("Start Test, testDeleteException");
		
		Exception exception = Assertions.assertThrows(Exception.class, () -> {
			service.delete(null);
		});

		assertTrue(exception.getMessage().contains("Error:"));

		LOG.info("Test Ok, testDeleteException");
	}

}
