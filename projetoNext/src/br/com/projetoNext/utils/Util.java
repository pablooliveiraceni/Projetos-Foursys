package br.com.projetoNext.utils;

import java.util.Scanner;

public class Util {
	
	public static int lerInt(String texto) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(texto);
		return entrada.nextInt();
	}
	
	public static String lerString(String texto) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println(texto);
		return entrada.nextLine();
	}
	
	public static double lerDouble(String texto) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(texto);
		return entrada.nextDouble();
	}

}
