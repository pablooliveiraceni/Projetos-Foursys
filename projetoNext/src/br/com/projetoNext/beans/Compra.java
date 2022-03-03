package br.com.projetoNext.beans;

import java.util.Date;

public class Compra {

	public Compra(Date data, double valor) {
		this.data = data;
		this.valor = valor;
	}

	private Date data;
	
	private double valor;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
