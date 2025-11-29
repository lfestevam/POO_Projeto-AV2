package categorias;

public class Categoria {
	//Caso o ususario escolha realizar uma entrada, ele terá essas opções como categoria.
    public enum Entrada {
        SALARIO,
        BONUS,
        PRESENTE,
        OUTROS;
    };
  //Caso o ususario escolha realizar uma saida, ele terá essas opções como categoria.
    public enum Saida {
        ALIMENTACAO,
        TRANSPORTE,
        LAZER,
        SAUDE,
        OUTROS,
        MORADIA;
    };
};