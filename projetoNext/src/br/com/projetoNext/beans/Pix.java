package br.com.projetoNext.beans;

import java.sql.Date;

public class Pix {
	
	private TipoChavePix tipoChave;
	private String chave;
	private boolean ativo;
	
	public TipoChavePix getTipoChave() {
		return tipoChave;
	}
	public void setTipoChave(TipoChavePix tipoChave) {
		this.tipoChave = tipoChave;
	}
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	

}
