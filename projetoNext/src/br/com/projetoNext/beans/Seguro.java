package br.com.projetoNext.beans;

public enum Seguro {
	
	MORTE("i. Indeniza��o por despesas m�dico-hospitalares, ou por perda parcial ou\r\n"
			+ "total do funcionamento dos membros ou �rg�os;\r\n"
			+ "ii. Reembolso de custos em diagn�stico de doen�as graves, como infarto,\r\n"
			+ "acidente vascular cerebral e c�ncer;\r\n"
			+ "iii. Assist�ncia funeral, para voc� e a sua fam�lia. ", 36), 
	
	INVALIDEZ("i. Invalidez parcial: ocorre quando h� uma perda parcial das fun��es. Por\r\n"
					+ "exemplo, uma pessoa que sofre um acidente e perda a vis�o em um s�\r\n"
					+ "dos olhos.\r\n"
					+ "ii. Invalidez total: ocorre quando h� uma perda total das fun��es.\r\n"
					+ "Intuitivamente, um bom exemplo seria o caso onde a pessoa sofre um\r\n"
					+ "acidente e perde a vis�o em ambos os olhos.", 26),
	
	DESEMPREGO("i. Necess�rio trabalhar com registro CLT, com o tempo m�nimo de\r\n"
			+ "estabilidade de 12 meses.\r\n"
			+ "ii. V�lido apenas para desligamento involunt�rios e sem justa causa.\r\n"
			+ "iii. N�o � valido em caso de demiss�o em massa (10% ou mais de\r\n"
			+ "demiss�es simult�neas) ou fal�ncia/encerramento das atividades.", 16);
	
	private String texto;
	private double valorSeguro;
	
	
	Seguro(String texto, double valorSeguro) 
	{
		this.texto = texto;
		this.valorSeguro = valorSeguro;
	}


	public String getTexto() {
		return texto;
	}


	public double getValorSeguro() {
		return valorSeguro;
	}


	

}
