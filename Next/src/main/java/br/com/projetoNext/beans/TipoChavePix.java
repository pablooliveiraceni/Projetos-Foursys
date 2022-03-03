package br.com.projetoNext.beans;

public enum TipoChavePix {
	
	CPF(1), EMAIL(2), TELEFONE(3), ALEATORIO(4);
	
	private int valor; 
	
	TipoChavePix(int valor){
		
		this.valor = valor;
		
	}

}
