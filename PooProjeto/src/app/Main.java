//============DOCENTE=================
//FILIPE HENRIQUE

//============DISCENTES===============
//GIOVANNA TAVARES DE LIMA - 01830311
//JOAO VICTOR CARLOS DE LIMA - 01802219
//LUCAS ROBERTO PEREIRA BALBINO - 01835544
//LUIS FELIPE ESTEVAM SOUZA DA SILVA - 01289979
//LUMA RODRIGUES N. DA SILVA - 01833902



package app;

import java.util.Scanner;
import categorias.Categoria;
import entidades.*;

public class Main {
	//TERMINAR D ECOMENTAR O CODIGO AMANHA, FAZER AS IMPLEMENTAÇÕES QUE FALTAM, E TRATAMENTO DE ERROS
	public static void main(String[] args) {

		// Recebe dados do ususario
		Scanner sc = new Scanner(System.in);

		// Armazena as contas na lista
		BancoDeContas banco = new BancoDeContas();

		
		//Menu que roda as opções do usuario.
		while (true) {
			System.out.println("\n===== MENU =====");
			System.out.println("1 - Criar nova conta");
			System.out.println("2 - Buscar conta");
			System.out.println("3 - Registrar entrada");
			System.out.println("4 - Registrar saida");
			System.out.println("5 - Resumo da conta");
			System.out.println("0 - Sair");
			System.out.print("Escolha: ");

			int opcao = sc.nextInt();
			sc.nextLine();

			if (opcao == 0) {
				System.out.println("Encerrando...");
				System.exit(0);
			}
			else {
				switch (opcao) {
				
				//criar conta
				case 1:
					System.out.print("Nome do titular: ");
					String nome = sc.nextLine();//recebe o nome do usuario

					Conta nova = banco.criarConta(nome);//adiciona o nome ao banco de contas atraves do metodo criarConta() que além de criar conta atribui um numero a ela;

					System.out.println("Conta criada com sucesso!");
					System.out.println("Número da conta: " + nova.getNumeroConta());//Retorna no console o numero da conta criada;
					break;
					
					//procura a conta indicada pelo numero recebido no hasmap
				case 2:
					int numeroBusca = lerNumeroConta(sc);//função feita para receber o numero da conta e realizar as pesquisas no banco sem precisar fica repetindo o codigo, visto que em todas as funções será necessario realizar a busca para fazer alterações na conta.

					Conta contaBuscada = banco.buscarConta(numeroBusca);//realiza a busca no banco e armazena numa variavel para ficar mais legivel

					if (contaBuscada == null) {//verifica se a conta existe no hashmap
						System.out.println("Conta não encontrada.");
					} else {//retorna as informações da conta no console
						System.out.println("Conta encontrada!");
						System.out.println("Usuário: " + contaBuscada.getNomeConta());
						System.out.println("Saldo: R$ " + contaBuscada.getSaldo());
					}
					break;
					
					//realiza as entradas de saldo na conta
				case 3:
					int numeroContaEntrada = lerNumeroConta(sc);
					
					Conta contaEntrada = banco.buscarConta(numeroContaEntrada);
					
					if (contaEntrada == null) {
						System.out.println("Conta não encontrada.");
					} else {
						System.out.println("Conta encontrada!");
						
						System.out.println("Digite o valor da entrada: ");
						double valorEntrada = sc.nextDouble();//recebe o valor da entrada
						sc.nextLine();
						//menu de categorias de entrada
						System.out.println("Escolha a categoria da Saída:");
				        System.out.println("1 - Salário");
				        System.out.println("2 - Bônus");
				        System.out.println("3 - Presente");
				        System.out.println("4 - Outros");
				        System.out.print("Opção: ");
				        int opcCat = sc.nextInt();//recebe a categoria

				        Categoria.Entrada categoria = null;//inicializa a categoria sema tribuir valor, pois vai ser passado no switch

				        switch (opcCat) {
				            case 1: categoria = Categoria.Entrada.SALARIO; break;//muda o valor de categoria para o valor escolhido
				            case 2: categoria = Categoria.Entrada.BONUS; break;//muda o valor de categoria para o valor escolhido
				            case 3: categoria = Categoria.Entrada.PRESENTE; break;//muda o valor de categoria para o valor escolhido
				            case 4: categoria = Categoria.Entrada.OUTROS; break;//muda o valor de categoria para o valor escolhido
				            default:
				                System.out.println("Categoria inválida!");
				                break;
				        }

				        // chama o método da conta passando o valor e a categoria para salvar
				        contaEntrada.entrarValor(valorEntrada, categoria);
				    }
				    break;
					
					
					//realiza as saidas de saldo da conta
				case 4:
					int numeroContaSaida = lerNumeroConta(sc);

				    Conta contaSaida = banco.buscarConta(numeroContaSaida);

				    if (contaSaida == null) {
				        System.out.println("Conta não encontrada.");
				    } else {
				        System.out.println("Conta encontrada!");

				        System.out.print("Digite o valor da Saída: ");
				        double valorSaida = sc.nextDouble();//recebe o valor da saida
				        sc.nextLine();

				        //categorias de saida
				        System.out.println("Escolha a categoria da Saída:");
				        System.out.println("1 - Alimentação");
				        System.out.println("2 - Transporte");
				        System.out.println("3 - Lazer");
				        System.out.println("4 - Saúde");
				        System.out.println("5 - Moradia");
				        System.out.println("6 - Outros");
				        System.out.print("Opção: ");
				        int opcCat = sc.nextInt();

				        Categoria.Saida categoria = null;  

				        switch (opcCat) {
				            case 1: categoria = Categoria.Saida.ALIMENTACAO; break;
				            case 2: categoria = Categoria.Saida.TRANSPORTE; break;
				            case 3: categoria = Categoria.Saida.LAZER; break;
				            case 4: categoria = Categoria.Saida.SAUDE; break;
				            case 5: categoria = Categoria.Saida.MORADIA; break;
				            case 6: categoria = Categoria.Saida.OUTROS; break;
				            default:
				                System.out.println("Categoria inválida!");
				                break;
				        }

				        // chama o método da conta passando o valor e a categoria
				        contaSaida.saidaValor(valorSaida, categoria);
				    }
				    break;
					
				case 5://mostra um resumo da conta e das transçãoes realizadas e guardadas no Array list
					 System.out.println("=========== RESUMO ===========");
					    int numeroResumoConta = lerNumeroConta(sc);

					    Conta contaResumo = banco.buscarConta(numeroResumoConta);//pesquisa a conta no banco e salva na variavel

					    if (contaResumo == null) {
					        System.out.println("Conta não encontrada!");
					    } else {
					        contaResumo.mostrarResumo();//chama o metodo que mostra o resumo para conta que foi buscada
					    }
					    break;
				};
			};

		}

	};

	//função que recebe o numero da conta para realizar pesquisas e alterações na mesma.
	private static int lerNumeroConta(Scanner sc) {
	    System.out.print("Informe o número da conta: ");

	    try {
	        int numero = sc.nextInt();
	        sc.nextLine();
	        return numero;
	    } catch (Exception e) {
	        System.out.println("Erro: você deve digitar um número inteiro.");
	        sc.nextLine();
	        return -1;
	    }
	}
};
