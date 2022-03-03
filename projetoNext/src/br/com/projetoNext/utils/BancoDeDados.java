package br.com.projetoNext.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.projetoNext.beans.Cliente;
import br.com.projetoNext.beans.Conta;
import br.com.projetoNext.beans.Pix;

public class BancoDeDados {
	
	private static Map<String, Cliente> BANCO_DE_DADOS = new HashMap<String, Cliente>();
	
	public static void inserirCliente(Cliente cliente) {
		
		BANCO_DE_DADOS.put(cliente.getNumeroConta(), cliente);
	}
	
	public static Cliente buscarCliente(String numeroConta) {
			
		return BANCO_DE_DADOS.get(numeroConta);
		
	}
	
     public static Cliente getContaPorPix(String chave) {
		
		for(Map.Entry<String, Cliente> mapaCliente : BancoDeDados.BANCO_DE_DADOS.entrySet()) {
			Cliente cliente = mapaCliente.getValue();
			Pix pix = cliente.getContaCorrente().getPix();
			if(pix != null) {
				if(pix.getChave().equals(chave)){
					return cliente;
				}
			}
		}
		
		return null;
		
	}

	
	
}
