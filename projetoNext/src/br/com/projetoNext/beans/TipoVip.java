package br.com.projetoNext.beans;

public enum TipoVip {
	
	COMUM(1), SUPER(2), PREMIUM(3);
	
	private int valor; 
	
	TipoVip(int valor){
		
		this.valor = valor;
	}

}
