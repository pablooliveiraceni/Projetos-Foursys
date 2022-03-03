package br.com.projetoNext.beans;

public enum TipoCliente {
	
	COMUM(1), SUPER(2), PREMIUM(3);
	
	private int valor; 
	
	TipoCliente(int valor){
		
		this.valor = valor;
	}

}
