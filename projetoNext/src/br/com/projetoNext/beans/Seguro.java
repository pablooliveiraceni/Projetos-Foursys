package br.com.projetoNext.beans;

public enum Seguro {
	
	MORTE("i. Indenização por despesas médico-hospitalares, ou por perda parcial ou\r\n"
			+ "total do funcionamento dos membros ou órgãos;\r\n"
			+ "ii. Reembolso de custos em diagnóstico de doenças graves, como infarto,\r\n"
			+ "acidente vascular cerebral e câncer;\r\n"
			+ "iii. Assistência funeral, para você e a sua família. ", 36), 
	
	INVALIDEZ("i. Invalidez parcial: ocorre quando há uma perda parcial das funções. Por\r\n"
					+ "exemplo, uma pessoa que sofre um acidente e perda a visão em um só\r\n"
					+ "dos olhos.\r\n"
					+ "ii. Invalidez total: ocorre quando há uma perda total das funções.\r\n"
					+ "Intuitivamente, um bom exemplo seria o caso onde a pessoa sofre um\r\n"
					+ "acidente e perde a visão em ambos os olhos.", 26),
	
	DESEMPREGO("i. Necessário trabalhar com registro CLT, com o tempo mínimo de\r\n"
			+ "estabilidade de 12 meses.\r\n"
			+ "ii. Válido apenas para desligamento involuntários e sem justa causa.\r\n"
			+ "iii. Não é valido em caso de demissão em massa (10% ou mais de\r\n"
			+ "demissões simultâneas) ou falência/encerramento das atividades.", 16);
	
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
