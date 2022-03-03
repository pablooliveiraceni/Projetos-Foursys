package br.com.projetoNext.beans;

import java.util.Date;

public class Conta {
	
	private double saldo;
	private Pix pix;
	private TipoConta tipoConta;
	private TipoVip tipoVip;
	private Date data;
	private CartaoCredito cartaoCredito; 
	private CartaoDebito cartaoDebito;
	
	
	
	
	public CartaoCredito getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(CartaoCredito cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	public CartaoDebito getCartaoDebito() {
		return cartaoDebito;
	}

	public void setCartaoDebito(CartaoDebito cartaoDebito) {
		this.cartaoDebito = cartaoDebito;
	}

	public TipoVip getTipoVip() {
		return tipoVip;
	}

	public void setTipoVip(TipoVip tipoVip) {
		this.tipoVip = tipoVip;
	}

	public Pix getPix() {
		return pix;
	}

	public void setPix(Pix pix) {
		this.pix = pix;
	}

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
