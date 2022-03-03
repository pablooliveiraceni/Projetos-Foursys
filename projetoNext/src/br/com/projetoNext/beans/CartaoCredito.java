package br.com.projetoNext.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CartaoCredito extends Cartao {
	
	public CartaoCredito(String numero, String bandeira, String senha, boolean ativo, double limite) {
		super(numero, bandeira, senha, ativo);
		this.limite = limite;
		this.compras = new ArrayList<Compra>();
		this.dataVencimento = this.getDateAdd1Month();
		this.valorFatura = 0;
	}

	private double limite;
	
	private List<Compra> compras;
	
	private Date dataVencimento;
	
	private double valorFatura;

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void addCompra(Compra compra) {
		this.compras.add(compra);
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public double getValorFatura() {
		return valorFatura;
	}

	public void setValorFatura(double valorFatura) {
		this.valorFatura = valorFatura;
	}
	
	public Date getDateAdd1Month() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		Date data = cal.getTime();
		
		return data;
	}
	
	
}
