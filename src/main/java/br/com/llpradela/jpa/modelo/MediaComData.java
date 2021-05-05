package br.com.llpradela.jpa.modelo;

public class MediaComData {

	private Double valor;
	private Integer mes;
	private Integer dia;

	public MediaComData(Integer dia, Integer mes, Double valor) {
		this.valor = valor;
		this.mes = mes;
		this.dia = dia;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}
}