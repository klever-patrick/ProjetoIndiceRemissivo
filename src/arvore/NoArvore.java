package arvore;

import lista.ListaDinamica;

public class NoArvore {
    String palavra;
    ListaDinamica linha = new ListaDinamica();

    NoArvore esquerda;
    NoArvore direita;

    public NoArvore(String palavra) {
        this.palavra = palavra;
        this.esquerda = null;
        this.direita = null;
    }
}
