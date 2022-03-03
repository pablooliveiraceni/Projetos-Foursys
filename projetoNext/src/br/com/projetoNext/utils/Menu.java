package br.com.projetoNext.utils;

public class Menu {	
	
     public static void exibirBoaVinda() {
    		System.out.println("========================");
    		System.out.println("Bem-vindo ao banco Next!");
    		System.out.println("========================");
     }
     
     public static void menuInicial() {
    	 System.out.println("Escolha a opção que deseja realizar:\n 1 - Cadastrar-se\n 2 - Logar\n 3 - Sair");
     }
     
     public static void tipoConta() {
    	 
    	 System.out.println("Escolha o tipo de conta que você quer: \n 1 - Conta Corrente \n 2 - Conta Poupança \n 3 - Ambas");
     }

          
     public static void menuTransferencia() {
    	 System.out.println("=======");
    	 System.out.println("Opções");
    	 System.out.println("=======");
    	 System.out.println(" 1 - Conta-Corrente para Conta-Corrente -> Taxa 0\n 2 - Conta-Poupança para Conta-Poupança "
    	 		+ "-> Taxa 0\n 3 - Conta-Corrente para Conta-Poupança -> 5.60\n 4 - Conta-Poupança para Conta-Corrente -> Taxa 5.60");
     }
    

}
