package br.com.projetoNext.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cliente {
	
	private String cpf;
	private String nome;
	private String data;
	private Endereco endereco;
	private String senha;
	private String numeroConta;
	private Conta contaCorrente;
	private Conta contaPoupanca;
	private Map<Seguro, Apolice> apoliceSeguro = new HashMap<Seguro, Apolice>();
	
	
	
	
	public Map<Seguro, Apolice> getApoliceSeguro() {
		return apoliceSeguro;
	}

	public void setApoliceSeguro(Map<Seguro, Apolice> apoliceSeguro) {
		this.apoliceSeguro = apoliceSeguro;
	}

	public Conta getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(Conta contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public Conta getContaPoupanca() {
		return contaPoupanca;
	}

	public void setContaPoupanca(Conta contaPoupanca) {
		this.contaPoupanca = contaPoupanca;
	}

	public String getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
