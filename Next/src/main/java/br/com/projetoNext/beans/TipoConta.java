package br.com.projetoNext.beans;

public enum TipoConta {
	
	CONTA_CORRENTE(1), CONTA_POUPANCA(2);
	
	private int valor; 
	
	TipoConta(int valor){
		
		this.valor = valor;
	}
	
	public int getValor() {
		
		return valor;
	}

}
