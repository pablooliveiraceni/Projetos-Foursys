package br.com.projetoNext.bo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import br.com.projetoNext.beans.Cliente;
import br.com.projetoNext.beans.Conta;

import br.com.projetoNext.beans.Endereco;
import br.com.projetoNext.beans.TipoConta;
import br.com.projetoNext.beans.TipoVip;
import br.com.projetoNext.utils.BancoDeDados;
import br.com.projetoNext.utils.Util;

public class ClienteBo {
	

	 Cliente cliente;
	 
     public ClienteBo() {
		 
	 }
	 
	 public ClienteBo(Cliente cliente) {
		 
		 this.cliente = cliente;
	 }
	 
	
	
	public void cadastrarCliente() {
		
	    cliente = new Cliente();
		Endereco endereco = new Endereco();
		
		
		endereco.setLogradouro(Util.lerString("Logradouro:"));
		endereco.setNumero(Util.lerString("Número:"));
		endereco.setCep(Util.lerString("Cep:"));
		endereco.setBairro(Util.lerString("Bairro"));
		endereco.setCidade(Util.lerString("Cidade: "));
		endereco.setEstado(Util.lerString("Estado"));
	    
		cliente.setNome(Util.lerString("Informe seu nome"));
		cliente.setCpf(Util.lerString("Informe seu cpf"));
		cliente.setData(Util.lerString("informe sua data de nascimento dd/MM/yyyy"));
		cliente.setEndereco(endereco);
		cliente.setSenha(Util.lerString("Informe uma senha"));
		cliente.setNumeroConta(UUID.randomUUID().toString());
		
		Conta contaCorrente = new Conta();
		cliente.setContaCorrente(contaCorrente);
		cliente.getContaCorrente().setTipoConta(TipoConta.CONTA_CORRENTE);
		cliente.getContaCorrente().setTipoVip(TipoVip.COMUM);
		cliente.getContaCorrente().setData(getDateAdd1Month());
		
		int tipoConta = -1;
		while(tipoConta != 1 && tipoConta != 2) {
		    tipoConta = Util.lerInt("Deseja criar uma conta Poupança ?\n 1 - Sim\n 2 - Não");
			
			if(tipoConta == 1) {
				Conta contaPoupanca = new Conta();
				cliente.setContaPoupanca(contaPoupanca);
				cliente.getContaPoupanca().setTipoConta(TipoConta.CONTA_POUPANCA);
				cliente.getContaPoupanca().setData(getDateAdd1Month());
			} 
		}	
		BancoDeDados.inserirCliente(cliente);
		System.out.println("Cliente cadastrado com sucesso! O número para acessar suas contas é  " + cliente.getNumeroConta());
	}
	
	public Date getDateAdd1Month() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		Date data = cal.getTime();
		
		return data;
	}
	
	public boolean realizarLogin() {
		
		String senha = Util.lerString("Informe sua senha");
		
		if(this.cliente.getSenha().equals(senha) ) {
			
			return true;
		} else {
			return false;
		}	
	}

}
