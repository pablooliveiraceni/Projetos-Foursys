package br.com.imc.util;

import java.util.Scanner;

public class Util {
	
	
	public static int lerInt(String texto) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(texto);
		return  scanner.nextInt();
	}
	
	
	public static String lerString(String texto) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(texto);
		return  scanner.next();
	}
	
	public static double lerDouble(String texto) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(texto);
		return  scanner.nextDouble();
	}


}
