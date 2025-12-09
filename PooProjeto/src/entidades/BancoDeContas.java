package entidades;
import java.util.HashMap;

public class BancoDeContas {
	//Armazena as contas: eescolhemos hashmap para facilitar a busca, já que da para pegar o valor pela key, sem precisar rodar a lista toda.
	
    private HashMap<Integer, Conta> contas = new HashMap<>();
     
    
    // Criar uma nova conta e adicionar ao banco
    public Conta criarConta(String nome) {
        Conta novaConta = new Conta(nome);
        contas.put(novaConta.getNumeroConta(), novaConta);
        return novaConta;
    };

    // Buscar conta pelo número
    public Conta buscarConta(int numeroConta) {
        return contas.get(numeroConta); // retorna null se não existir
    };

    // Entrada financeira
    public void entradaFinanceira(int numeroConta, double valor) {
        Conta c = contas.get(numeroConta);
        if (c != null) c.entrarValor(valor, null);;
    };

    // Saída financeira
    public void saidaFinanceira(int numeroConta, double valor) {
        Conta c = contas.get(numeroConta);
        if (c != null) c.saidaValor(valor,null);
    };

    // Mostrar resumo da conta
    public void mostrarResumo(int numeroConta) {
        Conta c = contas.get(numeroConta);
        if (c != null) c.mostrarResumo();
    };
}
