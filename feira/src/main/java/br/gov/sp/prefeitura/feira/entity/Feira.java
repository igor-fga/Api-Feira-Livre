package br.gov.sp.prefeitura.feira.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_feira")
public class Feira {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "longitude")
	private Long longitude;

	@Column(name = "latitude")
	private Long latitude;

	@Column(name = "set_cens")
	private Long setCens;

	@Column(name = "area_pop")
	private Long areaPopulacao;

	@Column(name = "cod_distrito")
	private Integer codigoDistrito;
	
	@Column(name = "distrito")
	private String nomeDistrito;
	
	@Column(name = "sub_prefeitura")
	private String subPrefeitura;
	
	@Column(name = "regiao_5")
	private String regiao05;
	
	@Column(name = "regiao_8")
	private String regiao08;
	
	@Column(name = "feira")
	private String nomeFeira;
	
	@Column(name = "registro")
	private String registro;
	
	@Column(name = "logradouro")
	private String logradouro;
	
	@Column(name = "num_logra")
	private String numeroLogradouro;
	
	@Column(name = "bairro")
	private String bairro;
	
	@Column(name = "referencia")
	private String referencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getSetCens() {
		return setCens;
	}

	public void setSetCens(Long setCens) {
		this.setCens = setCens;
	}

	public Long getAreaPopulacao() {
		return areaPopulacao;
	}

	public void setAreaPopulacao(Long areaPopulacao) {
		this.areaPopulacao = areaPopulacao;
	}

	public Integer getCodigoDistrito() {
		return codigoDistrito;
	}

	public void setCodigoDistrito(Integer codigoDistrito) {
		this.codigoDistrito = codigoDistrito;
	}

	public String getNomeDistrito() {
		return nomeDistrito;
	}

	public void setNomeDistrito(String nomeDistrito) {
		this.nomeDistrito = nomeDistrito;
	}

	public String getSubPrefeitura() {
		return subPrefeitura;
	}

	public void setSubPrefeitura(String subPrefeitura) {
		this.subPrefeitura = subPrefeitura;
	}

	public String getRegiao05() {
		return regiao05;
	}

	public void setRegiao05(String regiao05) {
		this.regiao05 = regiao05;
	}

	public String getRegiao08() {
		return regiao08;
	}

	public void setRegiao08(String regiao08) {
		this.regiao08 = regiao08;
	}

	public String getNomeFeira() {
		return nomeFeira;
	}

	public void setNomeFeira(String nomeFeira) {
		this.nomeFeira = nomeFeira;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public void setNumeroLogradouro(String numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}	
}
