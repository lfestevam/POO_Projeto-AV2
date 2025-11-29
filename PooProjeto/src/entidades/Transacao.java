package entidades;


public class Transacao {

    private String tipo; // Entrada ou Saída
    private double valor;
    private Object categoria; // pode ser Categoria.Entrada ou Categoria.Saida

    
    //construtor de transação
    public Transacao(String tipo, double valor, Object categoria) {
        this.tipo = tipo;
        this.valor = valor;
        this.categoria = categoria;
    }
    
    //sobreescrevemos o metodo toString() para formatar a saida.
    @Override
    public String toString() {
        return tipo + " - R$" + valor + " - " + categoria;
    }
}
