package br.com.projetoNext.utils;

public class Menu {	
	
     public static void exibirBoaVinda() {
    		System.out.println("========================");
    		System.out.println("Bem-vindo ao banco Next!");
    		System.out.println("========================");
     }
     
     public static void menuInicial() {
    	 System.out.println("Escolha a op��o que deseja realizar:\n 1 - Cadastrar-se\n 2 - Logar\n 3 - Sair");
     }
     
     public static void tipoConta() {
    	 
    	 System.out.println("Escolha o tipo de conta que voc� quer: \n 1 - Conta Corrente \n 2 - Conta Poupan�a \n 3 - Ambas");
     }

          
     public static void menuTransferencia() {
    	 System.out.println("=======");
    	 System.out.println("Op��es");
    	 System.out.println("=======");
    	 System.out.println(" 1 - Conta-Corrente para Conta-Corrente -> Taxa 0\n 2 - Conta-Poupan�a para Conta-Poupan�a "
    	 		+ "-> Taxa 0\n 3 - Conta-Corrente para Conta-Poupan�a -> 5.60\n 4 - Conta-Poupan�a para Conta-Corrente -> Taxa 5.60");
     }
    

}
