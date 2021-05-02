package br.gov.sp.prefeitura.feira;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.gov.sp.prefeitura.feira.entity.Feira;
import br.gov.sp.prefeitura.feira.service.FeiraService;

@SpringBootApplication
public class FeiraApplication implements CommandLineRunner {

	private final FeiraService service;

	public FeiraApplication(FeiraService service) {
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(FeiraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Feira feira = new Feira();
		feira.setLongitude(-46550164L);
		feira.setLatitude(-23558733L);
		feira.setSetCens(355030885000091L);
		feira.setAreaPopulacao(3550308005040L);
		feira.setCodigoDistrito(87);
		feira.setNomeDistrito("VILA FORMOSA");
		feira.setCodigoSubPrefeitura(26);
		feira.setSubPrefeitura("ARICANDUVA-FORMOSA-CARRAO");
		feira.setRegiao05("Leste");
		feira.setRegiao08("Leste 1");
		feira.setNomeFeira("VILA FORMOSA");
		feira.setRegistro("4041-0");
		feira.setLogradouro("RUA MARAGOJIPE");
		feira.setNumeroLogradouro("S/N");
		feira.setBairro("VL FORMOSA");
		feira.setReferencia("TV RUA PRETORIA");

		service.Create(feira);
	}

}
