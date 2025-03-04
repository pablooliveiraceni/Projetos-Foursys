package br.com.imc.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import br.com.imc.beans.Pessoa;
import br.com.imc.bo.PessoaBO;

public class Main {

	public static void main(String[] args) throws IOException {
		 
		  // Escrita 
	    OutputStream fos = new FileOutputStream("lorem.txt");
        Writer osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        
           
           // Leitura 
        FileInputStream fis = new FileInputStream("lorem.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		
		
			 int opcao = -1;
		
		while(opcao != 3) {
			
			 opcao = Util.lerInt("Informe a op��o que deseja realizar \n 1 - Cadastrar pessoa e calcular imc \n 2 - exibir registro de todas as Pessoas e Imc \n 3 - Sair ");
			
			if (opcao == 1) {
				
				PessoaBO pessoaBO = new PessoaBO();
				
				String nome = Util.lerString("Informe o nome");
				double altura = Util.lerDouble("Informe a altura");
				int idade = Util.lerInt("Informe a idade");
				double peso = Util.lerDouble("Informe o peso");
				
				Pessoa p = pessoaBO.cadastrarPessoa(nome, altura, idade, peso);
				pessoaBO.calcularIMC();
				
				String classificacao;
				if(p.getImc() < 18.5) {
					
					classificacao = "Magreza";
					
				} else if (p.getImc() >= 18.5 && p.getImc() <= 24.9) {
					
					classificacao = "Normal";
					
				} else if (p.getImc() >= 25 && p.getImc() <= 29.9) {
					
					classificacao = "SOBREPESO";
				} else if (p.getImc() >= 30 && p.getImc() <= 39.9) {
					
					classificacao = "OBESIDADE";
				} else {
					
					classificacao = "OBESIDADE GRAVE";
				}
				
		           
		           bw.newLine();
		           bw.write(p.getNome() + " | Imc: " + p.getImc() + " Classifica��o: " + classificacao);
		          
		         

			} else if(opcao == 2) {
				
				 bw.flush();
				 
				 String linha = br.readLine();
				 
				 while(linha != null) {
					 
					 System.out.println(linha);
					 linha = br.readLine();
				 }
				
				
			} else if(opcao == 3) {
				
				System.out.println("Obrigado por utilizar o sistema");
				
				br.close();
				bw.close();
				
				
				
			} else {
				System.out.println("Op��o invalida, tente novamente");
			}
				

			
		}
		
	
	}

}
