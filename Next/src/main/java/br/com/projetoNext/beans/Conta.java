package br.com.projetoNext.beans;

import java.util.Date;

public class Conta {
	
	private double saldo;
	private TipoConta tipoConta;
	private Date data;
	
	
	
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}
	
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	} 
	
}
