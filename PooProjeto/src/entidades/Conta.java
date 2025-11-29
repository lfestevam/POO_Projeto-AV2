package entidades;

import java.util.ArrayList;
import java.util.List;

import categorias.Categoria;

public class Conta {
	
	
	private static int contadorContas = 1;
	private int numeroConta; // número da conta
    private String nome;     // nome do usuário
    private double saldo;    // saldo inicial
    
    private List<Transacao> historico = new ArrayList<>();
    
    
    
    //construtor de conta
    public Conta(String nome) {
    	this.numeroConta = contadorContas++;//numero atribuido a conta
    	this.nome = nome; //nome
    	this.saldo = 0.0;//saldo
    };
    
    
    //função que mostrar o resumo das transaoes da conta escolhida.
    public void mostrarResumo() {
        System.out.println("=== RESUMO DA CONTA ===");
        System.out.println("Nome: " + nome);
        System.out.println("Número da Conta: " + numeroConta);
        System.out.println("Saldo Atual: R$ " + saldo);

        System.out.println("\n--- Histórico de Transações ---");

        if (historico.isEmpty()) {
            System.out.println("Nenhuma transação realizada.");
        } else {
            for (Transacao t : historico) {
                System.out.println(t);
            }
        }
    };
    
    

    
    //função para receber o valor e categoria da entrada e adicionar a conta
    public void entrarValor(double valor, Categoria.Entrada categoria) { 
    	saldo += valor;//adicona o sdaldo reescrevendo o valor de 0 inicial do construtor
    	historico.add(new Transacao("Entrada", valor, categoria));//adicona a categoria a lista de tansacao
    	System.out.println("Entrada registrada: R$ " + valor + " - " + categoria);
    };
    
    //função de saida de valor + categoria da saida, com verificação de erro para previnir saida de saldo negativvo inexistente
    public void  saidaValor(double valor, Categoria.Saida categoria ) { 
        if(valor <= saldo) {
            saldo -= valor;//remove o saldo reescrevendo o valor de 0 inicial do construtor
            historico.add(new Transacao("Saída", valor, categoria));
            System.out.println("Saída registrada: R$ " + valor + " - " + categoria);
        } else {
            System.out.println("Saldo insuficiente, não foi possivel retirar valor da conta!");
            
            return;
        };
    };
    
    
    
    //utilizado para pegar o numero da conta
    public int getNumeroConta() {
    	return numeroConta;
    };
  //utilizado para pegar o nome da conta
    public String getNomeConta() {
    	return nome;
    };
        
  //utilizado para pegar o saldo da conta
    public double getSaldo() {
    	return saldo;
    };
    
};


