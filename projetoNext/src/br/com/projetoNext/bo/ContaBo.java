package br.com.projetoNext.bo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.projetoNext.beans.CartaoCredito;
import br.com.projetoNext.beans.CartaoDebito;
import br.com.projetoNext.beans.Compra;
import br.com.projetoNext.beans.Conta;
import br.com.projetoNext.beans.Pix;
import br.com.projetoNext.beans.TipoChavePix;
import br.com.projetoNext.beans.TipoConta;
import br.com.projetoNext.beans.TipoVip;
import br.com.projetoNext.utils.Util;

public class ContaBo {
	
	Conta conta;
	
	public ContaBo(Conta conta) {
		
		this.conta = conta;
	}
	
	
	public void saque()
	{	
	
			double valor = Util.lerDouble("Infome o valor que deseja sacar");
			
			if(this.conta.getSaldo() >= valor)
			{
				double saldo = this.conta.getSaldo() - valor;
				this.conta.setSaldo(saldo);
				this.conferirTipoVip();
				
				System.out.println("Saque realizado com sucesso! ");
			}
			
			else
			{
				System.out.println("Saldo insuficiente");
				
			}
			
	}

	public void deposito() {
		
		double valor = Util.lerDouble("Infome o valor que deseja deposito");
		
		double saldo = this.conta.getSaldo() + valor;
		
		this.conta.setSaldo(saldo);
		
		this.conferirTipoVip();
		
	}


	public void traferir(Conta contaDestino) {
		
		double valor = Util.lerDouble("Qual o valor que deseja tranferir ? ");
			
		if(this.conta.getTipoConta() == contaDestino.getTipoConta()) {
			if(this.conta.getSaldo() >= valor) {
				double saldo = this.conta.getSaldo() - valor;
				this.conta.setSaldo(saldo);
				contaDestino.setSaldo(contaDestino.getSaldo() + valor);
				this.conferirTipoVip();
				
				System.out.println("Funcionou! O saldo da sua conta agora é " + this.conta.getSaldo());
			} 
			else
			{
				System.out.println("Saldo insuficiente");
			}
			
			
		} else {
			
			if(this.conta.getSaldo() - 5.6 >= valor)
			{
				
				double saldo = this.conta.getSaldo() - (valor + 5.6);
				
				this.conta.setSaldo(saldo);
				
				contaDestino.setSaldo(contaDestino.getSaldo() + valor);
				this.conferirTipoVip();
				
				System.out.println("Funcionou! O saldo da sua conta agora é " + this.conta.getSaldo());
			}
			else 
			{
				System.out.println("Sldo insuficiente");
			}
		}
		
	}


     public Conta debitoCredito() 
     {
		
		if (this.conta.getData().before(new Date(0)))
		{
			
			if (this.conta.getTipoConta() == TipoConta.CONTA_CORRENTE) 
			{
				System.out.println("Saldo inicial" +  this.conta.getSaldo());
				double valor = this.conta.getSaldo();
			    valor -= valor * 0.0045;
				this.conta.setSaldo(valor);
				System.out.println("Saldo com desconto de 0,45%" + conta.getSaldo());
				this.conferirTipoVip();
				
			}
			else 
			{
				System.out.println("Saldo inicial " + conta.getSaldo());
				double valor = this.conta.getSaldo();
				valor +=  valor * 0.003;
				
				conta.setSaldo(valor);
				
				System.out.println(" Saldo com acrecimo de 0,3% " + conta.getSaldo());
				this.conferirTipoVip();
							
			}
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 1);
			Date data = (Date) cal.getTime();
			this.conta.setData(data);
			
			return this.conta;
		}
		return conta;
		
	}


	public void cadastrarPix(TipoChavePix tipoChavePix, String chavePix) 
	{
		
		
		if (this.conta.getPix() != null) 
		{
			System.out.println("Chave pix ativa");
		}
		else {
			Pix pix = new Pix();
			pix.setAtivo(true);
			pix.setTipoChave(tipoChavePix);
			pix.setChave(chavePix);
			this.conta.setPix(pix);
		}
		
	}
	
	public void conferirTipoVip()
	{
		if (this.conta.getSaldo() <= 5000) {
			this.conta.setTipoVip(TipoVip.COMUM);
			System.out.println("COMUM");
		}
		else if (this.conta.getSaldo() > 5000 && this.conta.getSaldo() <= 10000)
		{
			this.conta.setTipoVip(TipoVip.PREMIUM);
			System.out.println("PREMIUM");
		}
		else
		{
			this.conta.setTipoVip(TipoVip.SUPER);
			System.out.println("SUPER");
		}
	}


	public void adiconarCartao(CartaoCredito cartaoCredito)
	{
		this.conta.setCartaoCredito(cartaoCredito);
		
		System.out.println("Cartão gerado número: " + cartaoCredito.getNumero());
		
	}
	           
	public void  adiconarCartao(CartaoDebito cartaoDebito)
	{
		this.conta.setCartaoDebito(cartaoDebito);
		
		System.out.println("Cartão gerado número: " + cartaoDebito.getNumero());
	}


	public void comprarComCartaoDeDebito(CartaoDebito cartaoDebito, double valor) {
		
     if(cartaoDebito.getLimitePorTransacao() >= valor) {
			
			double saldoConta = this.conta.getSaldo();
			
			if(saldoConta >= valor) {
				
				saldoConta -= valor;
				this.conta.setSaldo(saldoConta);
				
				
				System.out.println("Compra OK");
				
			}else {
				System.out.println("Sem saldo na conta");
			}
			
			
		}else {
			System.out.println("Limite por transação não pode ser maior que o valor");
		}
		
	}


	public void comprarComCartaoDeCredito(CartaoDebito cartaoDebito, double valor) {
		
		if (this.conta.getCartaoCredito().getLimite() >= valor)
		{

			Compra compra = new Compra(new Date(0), valor);
			this.conta.getCartaoCredito().addCompra(compra);
			double limite = this.conta.getCartaoCredito().getLimite();
			limite -= valor;
			this.conta.getCartaoCredito().setLimite(limite);

			double valorFatura = this.conta.getCartaoCredito().getValorFatura();
			valorFatura += valor;
			this.conta.getCartaoCredito().setValorFatura(valorFatura);


			System.out.println("Compra OK");
		} 
		else 
		{
			System.out.println("Recusado");
		}
	
	}


	public void exibirFatura() {

        List<Compra> lCompra = this.conta.getCartaoCredito().getCompras();
        

		System.out.println("Seu limite é: " + this.conta.getCartaoCredito().getLimite());
		System.out.println("Valor da Fatura é: "+ this.conta.getCartaoCredito().getValorFatura());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String data = sdf.format(this.conta.getCartaoCredito().getDataVencimento());
		
		System.out.println("Seu cartão vence em: "+data);
		
		System.out.println("---------- COMPRAS ---------");
		
		SimpleDateFormat sdfComHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		for(Compra compra : lCompra) {
			
			String dataCompra = sdfComHora.format(compra.getData());
			double valor = compra.getValor();
			
			System.out.println("Compra no dia " + dataCompra + " no valor de " + valor);
			
		}
		System.out.println("------------ FIM -----------");
        
        
		
	}

}
