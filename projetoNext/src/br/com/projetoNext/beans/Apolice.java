package br.com.projetoNext.beans;

import java.util.Date;
import java.util.Calendar;

public class Apolice {
	
	private Seguro seguro;
	private Date dataAssinatura;
	private Date dataCarencia;
	

	public Seguro getSeguro() {
		return seguro;
	}
	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
	public Date getDataAssinatura() {
		return dataAssinatura;
	}
	public void setDataAssinatura(Date dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}
	public Date getDataCarencia() {
		return dataCarencia;
	}
	public void setDataCarencia(Date dataCarencia) {
		this.dataCarencia = dataCarencia;
	}
	
}
