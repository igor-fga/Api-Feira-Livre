package br.gov.sp.prefeitura.feira.dto;

public class FeiraCreateAndUpdateDTO {

	private Long longitude;

	private Long latitude;

	private Long setCens;

	private Long areaPopulacao;

	private Integer codigoDistrito;
	
	private String nomeDistrito;
	
	private Integer codigoSubPrefeitura;
	
	private String subPrefeitura;
	
	private String regiao05;
	
	private String regiao08;
	
	private String nomeFeira;
	
	private String registro;
	
	private String logradouro;
	
	private String numeroLogradouro;
	
	private String bairro;
	
	private String referencia;

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

	public Integer getCodigoSubPrefeitura() {
		return codigoSubPrefeitura;
	}

	public void setCodigoSubPrefeitura(Integer codigoSubPrefeitura) {
		this.codigoSubPrefeitura = codigoSubPrefeitura;
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

	@Override
	public String toString() {
		return "FeiraCreateAndUpdateDTO [longitude=" + longitude + ", latitude=" + latitude + ", setCens=" + setCens
				+ ", areaPopulacao=" + areaPopulacao + ", codigoDistrito=" + codigoDistrito + ", nomeDistrito="
				+ nomeDistrito + ", codigoSubPrefeitura=" + codigoSubPrefeitura + ", subPrefeitura=" + subPrefeitura
				+ ", regiao05=" + regiao05 + ", regiao08=" + regiao08 + ", nomeFeira=" + nomeFeira + ", registro="
				+ registro + ", logradouro=" + logradouro + ", numeroLogradouro=" + numeroLogradouro + ", bairro="
				+ bairro + ", referencia=" + referencia + "]";
	}
	
	
}
