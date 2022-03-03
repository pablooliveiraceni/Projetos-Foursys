package br.com.projetoNext.main;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

import br.com.projetoNext.beans.Apolice;
import br.com.projetoNext.beans.CartaoCredito;
import br.com.projetoNext.beans.CartaoDebito;
import br.com.projetoNext.beans.Cliente;
import br.com.projetoNext.beans.Conta;
import br.com.projetoNext.beans.Seguro;
import br.com.projetoNext.beans.TipoChavePix;
import br.com.projetoNext.beans.TipoVip;
import br.com.projetoNext.bo.ClienteBo;
import br.com.projetoNext.bo.ContaBo;
import br.com.projetoNext.utils.BancoDeDados;
import br.com.projetoNext.utils.Menu;
import br.com.projetoNext.utils.Util;

public class Main {

	public static void main(String[] args) {
		
		int opcao = -1;
		Scanner scanner = new Scanner(System.in);
	
		
		while(opcao != 3) {
			
			Menu.menuInicial();
			
			opcao = scanner.nextInt();
			
			if (opcao == 1) 
			{
				ClienteBo clienteBo = new ClienteBo();
				clienteBo.cadastrarCliente();
				
			}
			else if (opcao == 2) 
			{
				System.out.println("Informe o n�mero da conta que deseja logar: ");
				String numeroConta = scanner.next();
				
				Cliente cliente = BancoDeDados.buscarCliente(numeroConta);
				
				if (cliente != null)
				{
					
					ClienteBo clienteBo = new ClienteBo(cliente);
					
					boolean retorno = clienteBo.realizarLogin();
					
					if (retorno) 
					{
						System.out.println("Login feito com sucesso!");
						
						if(cliente.getContaCorrente() != null)
						{
							ContaBo contaBo = new ContaBo(cliente.getContaCorrente());
							
							cliente.setContaCorrente(contaBo.debitoCredito());
							
						}
						
						if(cliente.getContaPoupanca() != null)
						{
							ContaBo contaBo = new ContaBo(cliente.getContaPoupanca());
							
							cliente.setContaPoupanca(contaBo.debitoCredito());
						}
						
						BancoDeDados.inserirCliente(cliente);
						
						int menuInterno = -1;
						
						while(menuInterno != 11)
						{
						    menuInterno  = Util.lerInt("Escolha uma das op��es:\n 1 - Saque\n 2 - Dep�sito\n 3 - "
						    		+ "Transfer�ncia \n 4 - consulta\n 5 - Cadastrar pix\n 6 - Fazer pix\n 7 - Adicionar Cart�o de"
						    		+ " Cr�dito\n 8 - Adicionar Cart�o de D�bito\n 9 - Compra com d�bito\n 10 - Compra com cr�dito"
						    		+ "\n 11 - Fatura \n 12 - Contratar seguro\n 13 - Exibir seguros\n 14 - Voltar ao menu anterior");
							
							if (menuInterno == 1)
							{
								
								int contaSacar = Util.lerInt("De qual conta deseja sacar:\n 1 - Corrente 2 - Poupan�a ");
								
						        if (contaSacar == 1)
						        {
						        	if(cliente.getContaCorrente() != null) 
						        	{
						        		ContaBo contaBo = new ContaBo(cliente.getContaCorrente());
							        	contaBo.saque();
						        	}
						        	else
						        	{
						        		System.out.println("Conta inexistente");
						        	}
						        	
						        	
						        } 
						        else if (contaSacar == 2) 
						        {
						        	
						        	if(cliente.getContaPoupanca() != null)
						        	{

							        	ContaBo contaBo = new ContaBo(cliente.getContaPoupanca());
							        	
							        	contaBo.saque();
						        	}
						        	else 
						        	{
						        		System.out.println("Conta inexistente");
						        	}
						        	
						        } 
						        else 
						        {
						        	
						        	System.out.println("Op��o invalida!");
						        }
								 
							}
							else if (menuInterno == 2) 
							{
                                int contaDepositar = Util.lerInt("Em qual conta deseja depositar:\n 1 - Corrente 2 - Poupan�a ");
								
						        if(contaDepositar == 1) {
						        	
						        	if(cliente.getContaCorrente() != null)
						        	{
						        		ContaBo contaBo = new ContaBo(cliente.getContaCorrente());
							        	contaBo.deposito();
						        	}
						        	else 
						        	{
						        		System.out.println("Conta Inexistente");
						        	}
						        	
						        	
						        } else if (contaDepositar == 2) {
						        	
						        	if(cliente.getContaPoupanca() != null) {
						        		ContaBo contaBo = new ContaBo(cliente.getContaPoupanca());
							        	
							        	contaBo.deposito();
						        	} 
						        	else 
						        	{
						        		System.out.println("Conta-Poupan�a inexistente");
						        	}
						 
						        } else {
						        	
						        	System.out.println("Op��o invalida!");
						        }
								System.out.println("Op��o de Deposito em desenvolvimento");
							} 
							else if (menuInterno == 3 ) 
							{
								numeroConta = Util.lerString("Informe o n�mero da conta para quem deseja fazer  transfer�ncia");
								Cliente clienteDestino = BancoDeDados.buscarCliente(numeroConta);
								
								Menu.menuTransferencia();
								
								int opcaoTransferencia = Util.lerInt("Entre com uma das op��es acima: ");
								
								if (opcaoTransferencia == 1) 
								{
									if(cliente.getContaCorrente() != null && clienteDestino.getContaCorrente() != null) 
									{
										
										ContaBo contaBo = new ContaBo(cliente.getContaCorrente());
										
										contaBo.traferir(clienteDestino.getContaCorrente());
									} else 
									{
										System.out.println("Impossivel concluir essa opera��o, uma das contas � inexistenta");
									}
									
									
								}
								else if (opcaoTransferencia == 2)
								{
									if(cliente.getContaPoupanca() != null && clienteDestino.getContaPoupanca() != null) 
									{
										
										ContaBo contaBo = new ContaBo(cliente.getContaPoupanca());
										
										contaBo.traferir(clienteDestino.getContaPoupanca());
									} else 
									{
										System.out.println("Impossivel concluir essa opera��o, uma das contas � inexistenta");
									}
								}
								else if (opcaoTransferencia == 3)
								{
									
									if(cliente.getContaCorrente() != null && clienteDestino.getContaPoupanca() != null) 
									{
										
										   ContaBo contaBo = new ContaBo(cliente.getContaCorrente());
											
											contaBo.traferir(clienteDestino.getContaPoupanca());
									} else 
									{
										System.out.println("Impossivel concluir essa opera��o, uma das contas � inexistenta");
									}
                                 
								}
								else if (opcaoTransferencia == 4)
								{
									
									if(cliente.getContaPoupanca() != null && clienteDestino.getContaCorrente() != null) 
									{
										
										ContaBo contaBo = new ContaBo(cliente.getContaPoupanca());
										
										contaBo.traferir(clienteDestino.getContaCorrente());
									} else 
									{
										System.out.println("Impossivel concluir essa opera��o, uma das contas � inexistenta");
									}
                                    
								}
								else 
								{
									System.out.println("Op��o invalida!");
								}
							
								System.out.println("Op��o de tranferencia em desenvolvimento");
							} 
							else if (menuInterno == 4) 
							{ 
							
								int opcaoConsultar = Util.lerInt("Qual Conta voc� deseja consultar:\n 1 - Corrente\n 2 - Poupan�a 3 - Ambas");
								
								if (opcaoConsultar == 1)
								{
									if (cliente.getContaCorrente() != null) 
									{
										System.out.println("Nome: " + cliente.getNome() + " com o cpf de n�mero " + cliente.getCpf() + "com saldo de " + cliente.getContaCorrente().getSaldo());
									}
									else 
									{
										System.out.println("Conta-Corrente inexistente");
									}
									
								}
								else if (opcaoConsultar == 2)
								{
									if (cliente.getContaPoupanca() != null) 
									{
										
										System.out.println("Nome: " + cliente.getNome() + " com o cpf de n�mero " + cliente.getCpf() + "com saldo de " + cliente.getContaPoupanca().getSaldo());
									}
									else
									{
										System.out.println("Conta-Poupan�a inexistente");
									}
			
								} 
								else if (opcaoConsultar == 3) 
								{
									System.out.println("Nome: " + cliente.getNome() + " com o cpf de n�mero " + cliente.getCpf());
									
									if(cliente.getContaCorrente() != null) 
									{
										System.out.println("Saldo Conta-Corrente " + cliente.getContaCorrente().getSaldo());
									} 
									else 
									{
										System.out.println("Conta-Corrente inexistente ");
									}
									
									if (cliente.getContaPoupanca() != null) 
									{
										System.out.println("Saldo Conta-Poupan�a " + cliente.getContaPoupanca().getSaldo());
									}
									else
									{
										System.out.println("Conta-Poupan�a ineistente");
									}
									
								}
								else
								{
									System.out.println("Op��o escolhida inexistente");
								}
							}
							else if (menuInterno == 5)
							{
								
								int tipoChavePix = Util.lerInt("Entre com tipo de chave pix:\n 1 - CPF\n 2 - E-MAIL\n 3 - TELEFONE\n - 4 - ALEATORIO");
								if (tipoChavePix == 1) 
								{
									ContaBo contaBo = new ContaBo(cliente.getContaCorrente());
									String chavePix = Util.lerString("Informe o Cpf");
									
									contaBo.cadastrarPix(TipoChavePix.CPF, chavePix);
											
									
								}
								else if (tipoChavePix == 2)
								{
									ContaBo contaBo = new ContaBo(cliente.getContaCorrente());
									String chavePix = Util.lerString("Informe o E-mail");
									
									contaBo.cadastrarPix(TipoChavePix.EMAIL, chavePix);
								}
								else if (tipoChavePix == 3)
								{
									ContaBo contaBo = new ContaBo(cliente.getContaCorrente());
									String chavePix = Util.lerString("Informe o telefone");
									
									contaBo.cadastrarPix(TipoChavePix.TELEFONE, chavePix);
								} 
								else if (tipoChavePix == 4)
								{
                                    ContaBo contaBo = new ContaBo(cliente.getContaCorrente());
                                    
									
									contaBo.cadastrarPix(TipoChavePix.ALEATORIO, UUID.randomUUID().toString());
										
								}
								else 
								{
									System.out.println("Op��e invalida");
								}
								
								System.out.println("Nova chave pix:" + cliente.getContaCorrente().getPix().getChave());
								
							}
							else if (menuInterno == 6)
							{	
								String pixContaRecebe = Util.lerString("Informe o pix da conta para quem deseja tranferir o dinheiro");
								
								Cliente clienteRecebe = BancoDeDados.getContaPorPix(pixContaRecebe);
								
								ContaBo contaBo = new ContaBo(cliente.getContaCorrente());
								
								contaBo.traferir(clienteRecebe.getContaCorrente());
							}
							else if (menuInterno == 7) 
							{
								
								if(cliente.getContaCorrente().getCartaoCredito() == null)
								{
									
									TipoVip tipoVip = cliente.getContaCorrente().getTipoVip();
									
									double limite = 0;
									
									if(tipoVip == TipoVip.COMUM) {
										
										limite = 1000;
										
									}else if (tipoVip == TipoVip.PREMIUM) {
										
										limite = 3000;
										
									}else {
										limite = 12000;
									}
									
									System.out.println("Limite do cart�o �: " + limite);
									
									
									
									String numero = gerarNumero();
									String bandeira = "VISA";
									String senha = Util.lerString("Informe a senha do cart�o: ");
									
									CartaoCredito cartaoCredito = new CartaoCredito(numero, bandeira, senha, true, limite);
									ContaBo contaBo = new ContaBo(cliente.getContaCorrente());
									contaBo.adiconarCartao(cartaoCredito);
								}
								else 
								{
									System.out.println("Cart�o de cr�dito j� existente");
								}
					
							
								
							}
							else if(menuInterno == 8)
							{
								
								if (cliente.getContaCorrente().getCartaoDebito() == null) 
								{
									System.out.print("Informe o limite de transa��o: ");
									double limite = scanner.nextDouble();
									
									String numero = gerarNumero();
									String bandeira = "VISA";
									
									
									String senha = Util.lerString("Informe a senha");
									
									CartaoDebito cartaoDebito = new CartaoDebito(numero, bandeira, senha, true, limite);
									
									ContaBo contaBo = new ContaBo(cliente.getContaCorrente());
									contaBo.adiconarCartao(cartaoDebito);
								}
								else 
								{
									System.out.println("Cart�o de d�bito j� existente ");
								}
								
							
							} 
							else if (menuInterno == 9)
							{
											
								if (cliente.getContaCorrente().getCartaoDebito() != null)
								{
																
									if(cliente.getContaCorrente().getCartaoDebito().isAtivo())
									{
		
										double valor = Util.lerDouble("Qual � o valor da compra: ");
										
										
										String senha = Util.lerString("Informe a senha do cart�o: ");
										
										ContaBo contaBo = new ContaBo(cliente.getContaCorrente());
										if(senha.equals(cliente.getContaCorrente().getCartaoDebito().getSenha()))
										{
											contaBo.comprarComCartaoDeDebito(cliente.getContaCorrente().getCartaoDebito(), valor);
										}
										else 
										{
											System.out.println("Senha incorreta.");
										}
									}
									else 
									{
										System.out.println("Cart�o n�o esta ativo");
									}
		
								}
								else
								{
									System.out.println("Cart�o inexistente");
								}
													
							}
							else if (menuInterno == 10) 
							{
								
								
								
								if(cliente.getContaCorrente().getCartaoCredito() != null)
								{
									if (cliente.getContaCorrente().getCartaoCredito().isAtivo())
									{

										double valor = Util.lerDouble("Qual � o valor da compra: ");

										String senha = Util.lerString("Informe a senha do cart�o: ");

										ContaBo contaBo = new ContaBo(cliente.getContaCorrente());
										if (senha.equals(cliente.getContaCorrente().getCartaoCredito().getSenha())) {
											contaBo.comprarComCartaoDeCredito(cliente.getContaCorrente().getCartaoDebito(),
													valor);
										} else {
											System.out.println("Senha incorreta.");
										}
									} else {
										System.out.println("Cart�o n�o esta ativo");
									}
									
								}	
								else 
								{
									System.out.println("Cart�o de cr�dito inexistente");
								}
							}
							else if (menuInterno == 11)
							{
								
								if(cliente.getContaCorrente().getCartaoCredito() != null)
								{
									ContaBo contaBo = new ContaBo(cliente.getContaCorrente());
									
									contaBo.exibirFatura();
								} 
								else 
								{
									System.out.println("N�o existem faturas");
								}
								
							} 
							else if (menuInterno == 12)
							{
								boolean continuar = false;
								
								if(cliente.getContaCorrente().getCartaoCredito() != null) {
									
									while(continuar == false) {
										int opcaoApolice = Util.lerInt("Escolha o tipo de seguro que quer\n 1 - Morte\n 2 - Invalidez\n 3 - Desemprego " );
										
										if(opcaoApolice == 1)
										{
											
											if(cliente.getApoliceSeguro().get(Seguro.MORTE) != null)
											{
												System.out.println("Voc� j� possui um seguro de morte");
											}
											else 
											{
												
												System.out.println(" Condi��es da apolice: " + Seguro.MORTE.getTexto() + "\n" + "Valor: " + Seguro.MORTE.getValorSeguro());
												int opcaoContinuar = Util.lerInt("Estou ciente das condi��es e do valor da apolice e desejo prosseguir ?\n 1 - Sim\n 2 - N�o");
												if(opcaoContinuar == 1)
												{
													Apolice apoliceMorte = new Apolice();
													Calendar c = Calendar.getInstance();
													apoliceMorte.setDataAssinatura(c.getTime());
													c.set(Calendar.DAY_OF_MONTH, 15);
													apoliceMorte.setDataCarencia(c.getTime());
													apoliceMorte.setSeguro(Seguro.MORTE);
													cliente.getApoliceSeguro().put(Seguro.MORTE, apoliceMorte);
													
													
													if (cliente.getContaCorrente().getCartaoCredito().isAtivo())
													{

														double valor = Seguro.MORTE.getValorSeguro();

														String senha = Util.lerString("Informe a senha do cart�o: ");

														ContaBo contaBo = new ContaBo(cliente.getContaCorrente());
														if (senha.equals(cliente.getContaCorrente().getCartaoCredito().getSenha())) {
															contaBo.comprarComCartaoDeCredito(cliente.getContaCorrente().getCartaoDebito(),
																	valor);
														} else {
															System.out.println("Senha incorreta.");
														}
													} else {
														System.out.println("Cart�o n�o esta ativo");
													}
												}
												
											}
										
										} 
										else if (opcaoApolice == 2)
										{ 
											
											if(cliente.getApoliceSeguro().get(Seguro.INVALIDEZ) != null)
											{
												System.out.println("Voc� j� possui um seguro invalidez");
											}
											else 
											{
												
												System.out.println(" Condi��es da apolice: " + Seguro.MORTE.getTexto() + "Valor: " + Seguro.MORTE.getValorSeguro());
												int opcaoContinuar = Util.lerInt("Estou ciente das condi��es e do valor da apolice e desejo prosseguir ?\n 1 - Sim\n 2 - N�o");
												if(opcaoContinuar == 1)
												{
													Apolice apoliceMorte = new Apolice();
													Calendar c = Calendar.getInstance();
													apoliceMorte.setDataAssinatura(c.getTime());
													c.set(Calendar.DAY_OF_MONTH, 15);
													apoliceMorte.setDataCarencia(c.getTime());
													apoliceMorte.setSeguro(Seguro.INVALIDEZ);
													cliente.getApoliceSeguro().put(Seguro.INVALIDEZ, apoliceMorte);
													
													if (cliente.getContaCorrente().getCartaoCredito().isAtivo())
													{

														double valor = Seguro.INVALIDEZ.getValorSeguro();

														String senha = Util.lerString("Informe a senha do cart�o: ");

														ContaBo contaBo = new ContaBo(cliente.getContaCorrente());
														if (senha.equals(cliente.getContaCorrente().getCartaoCredito().getSenha())) {
															contaBo.comprarComCartaoDeCredito(cliente.getContaCorrente().getCartaoDebito(),
																	valor);
														} else {
															System.out.println("Senha incorreta.");
														}
													} else {
														System.out.println("Cart�o n�o esta ativo");
													}
												}
											}
										}
										else if (opcaoApolice == 3)
										{
											if(cliente.getApoliceSeguro().get(Seguro.DESEMPREGO) != null)
											{
												System.out.println("Voc� j� possui um seguro desemprego");
											}
											else 
											{
												
												System.out.println(" Condi��es da apolice: " + Seguro.DESEMPREGO.getTexto() + "Valor: " +  Seguro.DESEMPREGO.getValorSeguro());
												int opcaoContinuar = Util.lerInt("Estou ciente das condi��es e do valor da apolice e desejo prosseguir ?\n 1 - Sim\n 2 - N�o");
												if(opcaoContinuar == 1)
												{
													Apolice apoliceMorte = new Apolice();
													Calendar c = Calendar.getInstance();
													apoliceMorte.setDataAssinatura(c.getTime());
													c.set(Calendar.DAY_OF_MONTH, 15);
													apoliceMorte.setDataCarencia(c.getTime());
													apoliceMorte.setSeguro(Seguro.DESEMPREGO);
													cliente.getApoliceSeguro().put(Seguro.DESEMPREGO, apoliceMorte);
													
													if (cliente.getContaCorrente().getCartaoCredito().isAtivo())
													{

														double valor = Seguro.DESEMPREGO.getValorSeguro();

														String senha = Util.lerString("Informe a senha do cart�o: ");

														ContaBo contaBo = new ContaBo(cliente.getContaCorrente());
														if (senha.equals(cliente.getContaCorrente().getCartaoCredito().getSenha())) {
															contaBo.comprarComCartaoDeCredito(cliente.getContaCorrente().getCartaoDebito(),
																	valor);
														} else {
															System.out.println("Senha incorreta.");
														}
													} else {
														System.out.println("Cart�o n�o esta ativo");
													}
												}
											}
												
										}
										
										int opcaoContinuar = Util.lerInt("Deseja cadastrar mais um seguro :\n 1 - Sim\n 2 - N�o");
										
										if(opcaoContinuar == 2) 
										{
									          continuar = true;
										}
										
									}
								}
								else 
								{
									System.out.println("Impossivel assinar seguro sem cart�o de cr�dito, por favor, crie um cart�o de cr�dito e tente novamente");
								}
							}
							else if (menuInterno == 13)
							{
								int valorTotal = 0;
								
								if(cliente.getApoliceSeguro().get(Seguro.MORTE) != null)
								{
									System.out.println("Voc� tem a assinado o seguro de morte: \n " + Seguro.MORTE.getTexto() + " \n Valor :" + Seguro.MORTE.getValorSeguro() );
									valorTotal = 1;
								}
								else if (cliente.getApoliceSeguro().get(Seguro.INVALIDEZ) != null)
								{
									System.out.println("Voc� tem a assinado o seguro de invalidez: \n " + Seguro.INVALIDEZ.getTexto() + " \n Valor :" + Seguro.INVALIDEZ.getValorSeguro() );
									valorTotal =+ 1;
								}
								
								
								else if (cliente.getApoliceSeguro().get(Seguro.DESEMPREGO) != null)
								{
									
									System.out.println("Voc� tem a assinado o seguro de desemprego: \n " + Seguro.DESEMPREGO.getTexto() + " \n Valor :" + Seguro.DESEMPREGO.getValorSeguro() );
									valorTotal =+ 1;
									
								}
								
								if(valorTotal == 0)
								{
									System.out.println("Voc� n�o possui nenhum seguro");
								}
								
							}
							else if (menuInterno == 14)
							{
								System.out.println("Obrigado por utilizar nosso sistema");	
							}
							else 
							{
								System.out.println("Op��es invalidas, tente novamente!");
							}
									
						}
					
					}		
				}	
			}
			
			else if (opcao == 3)
			{
			     
				System.out.println("O Banco next agradece pela utiliza��o do nosso sistema!");
			}
			else {
				System.out.println("Op��o invalida! por favor, escolha uma das op��es a seguir: ");
			}
						
		}		
		
	}
	
	public static String gerarNumero() {
		Random random = new Random();
		String novoNumero = "";
		
		int numeroDaVez = 0;
		
		for(int i = 0; i < 4; i++)
		{
			numeroDaVez = random.nextInt(100000);
			if (numeroDaVez < 10) 
			{
				novoNumero += "000";
			}
			else if (numeroDaVez < 100)
			{
				novoNumero += "00";
			}
			else if(numeroDaVez < 1000)
			{
				novoNumero += "0";		
			}
			
			novoNumero += String.valueOf(numeroDaVez);
			novoNumero += " ";
		}
		
		return novoNumero.strip();	
	}

}
