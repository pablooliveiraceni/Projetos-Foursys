package br.com.poker.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import poker.Carta;
import poker.Naipe;

public class Main {

	public static void main(String[] args) {
	
		List<Carta> baralho = new ArrayList<Carta>(52);
		int naipes = 1;
		while(naipes != 5) {
			

			for(int i = 2; i <= 14; i++) {
				
				if (naipes == 1) {
					
					if (i != 11 && i != 12 && i != 13 && i != 14) {
						Carta carta = new Carta();
						carta.setNaipe(Naipe.OUROS);
						carta.setNumeroCarta(Integer.toString(i));	
						baralho.add(carta);
						
					}
					else if(i == 11){
						
						Carta carta = new Carta();
						carta.setNaipe(Naipe.OUROS);
						carta.setNumeroCarta("J");	
						baralho.add(carta);
						
						
						
					} else if (i == 12) {
						
						Carta carta = new Carta();
						carta.setNaipe(Naipe.OUROS);
						carta.setNumeroCarta("Q");	
						baralho.add(carta);
						
						
						
					} else if(i == 13) {
						
						Carta carta = new Carta();
						carta.setNaipe(Naipe.OUROS);
						carta.setNumeroCarta("K");	
						baralho.add(carta);
						
					} else {
						
						Carta carta = new Carta();
						carta.setNaipe(Naipe.OUROS);
						carta.setNumeroCarta("A");	
						baralho.add(carta);
						
					}
						
				}
				else if (naipes == 2) {
					
					if (i != 11 && i != 12 && i != 13 && i != 14) {
						Carta carta = new Carta();
						carta.setNaipe(Naipe.COPAS);
						carta.setNumeroCarta(Integer.toString(i));	
						baralho.add(carta);
						
					}
					else if(i == 11){
						
						Carta carta = new Carta();
						carta.setNaipe(Naipe.COPAS);
						carta.setNumeroCarta("J");	
						baralho.add(carta);
						
						
						
					} else if (i == 12) {
						
						Carta carta = new Carta();
						carta.setNaipe(Naipe.COPAS);
						carta.setNumeroCarta("Q");	
						baralho.add(carta);
						
						
						
					} else if(i == 13) {
						
						Carta carta = new Carta();
						carta.setNaipe(Naipe.COPAS);
						carta.setNumeroCarta("K");	
						baralho.add(carta);
						
					} else {
						
						Carta carta = new Carta();
						carta.setNaipe(Naipe.COPAS);
						carta.setNumeroCarta("A");	
						baralho.add(carta);
						
					}
							
				}
				else if (naipes == 3) {
				
					
					if (i != 11 && i != 12 && i != 13 && i != 14) {
						Carta carta = new Carta();
						carta.setNaipe(Naipe.PAUS);
						carta.setNumeroCarta(Integer.toString(i));	
						baralho.add(carta);
						
					}
					else if(i == 11){
						
						Carta carta = new Carta();
						carta.setNaipe(Naipe.PAUS);
						carta.setNumeroCarta("J");	
						baralho.add(carta);
						
						
						
					} else if (i == 12) {
						
						Carta carta = new Carta();
						carta.setNaipe(Naipe.PAUS);
						carta.setNumeroCarta("Q");	
						baralho.add(carta);
						
						
						
					} else if(i == 13) {
						
						Carta carta = new Carta();
						carta.setNaipe(Naipe.PAUS);
						carta.setNumeroCarta("K");	
						baralho.add(carta);
						
					} else {
						
						Carta carta = new Carta();
						carta.setNaipe(Naipe.PAUS);
						carta.setNumeroCarta("A");	
						baralho.add(carta);
						
					}
						
				
				}
				else {
					
					if (i != 11 && i != 12 && i != 13 && i != 14) {
						Carta carta = new Carta();
						carta.setNaipe(Naipe.ESPADAS);
						carta.setNumeroCarta(Integer.toString(i));	
						baralho.add(carta);
						
					}
					else if(i == 11){
						
						Carta carta = new Carta();
						carta.setNaipe(Naipe.ESPADAS);
						carta.setNumeroCarta("J");	
						baralho.add(carta);
						
						
						
					} else if (i == 12) {
						
						Carta carta = new Carta();
						carta.setNaipe(Naipe.ESPADAS);
						carta.setNumeroCarta("Q");	
						baralho.add(carta);
						
						
						
					} else if(i == 13) {
						
						Carta carta = new Carta();
						carta.setNaipe(Naipe.ESPADAS);
						carta.setNumeroCarta("K");	
						baralho.add(carta);
						
					} else {
						
						Carta carta = new Carta();
						carta.setNaipe(Naipe.ESPADAS);
						carta.setNumeroCarta("A");	
						baralho.add(carta);
						
					}
					
				}
			}
			naipes++;
		}
		
		
		 baralho.forEach((carta) -> System.out.println(carta.getNaipe() + " " + carta.getNumeroCarta() + "\n"));
		   
	    Collections.shuffle(baralho);
	    
	    System.out.println("----------------------------------------------------------------------------------");
	   
	   baralho.forEach((carta) -> System.out.println(carta.getNaipe() + " " + carta.getNumeroCarta() + "\n"));
		
		
	}

}
