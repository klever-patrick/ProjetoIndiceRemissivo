package arvore;

public class ArvoreBinariaBusca {
    private NoArvore raiz;

    public NoArvore getRaiz() {
        return raiz;
    }

    public ArvoreBinariaBusca() {
        raiz = null;
    }

    public void adicionar(String palavra) {
        if (raiz == null) {
            raiz = new NoArvore(palavra);
        } else {
            adicionar(palavra, raiz);
        }
    }

    public void adicionar(String palavra, NoArvore raiz) {
        if (palavra.compareTo(raiz.palavra) < 0) {
            if (raiz.esquerda == null) {
                raiz.esquerda = new NoArvore(palavra);
            } else {
                adicionar(palavra, raiz.esquerda);
            }
        }
        else if (palavra.compareTo(raiz.palavra) > 0) {
            if (raiz.direita == null) {
                raiz.direita = new NoArvore(palavra);
            } else {
                adicionar(palavra, raiz.direita);
            }
        }
    }

    public void exibirEmOrdem() {
        if (raiz != null) {
            exibirEmOrdem(raiz);
        }
    }

    public void exibirEmOrdem(NoArvore raiz) {
        if (!raiz.linha.vazio()) {
            if (raiz.esquerda != null) {
                exibirEmOrdem(raiz.esquerda);
            }

            System.out.print(raiz.palavra);
            raiz.linha.exibir();

            if (raiz.direita != null) {
                exibirEmOrdem(raiz.direita);
            }
        }
    }

    public void incrementarLinhas(NoArvore raiz, String palavra, int numLinha) {
        if (raiz == null || raiz.palavra.equals(palavra)) {
            assert raiz != null;
            raiz.linha.adicionarFinal(numLinha);
        }
        if (palavra.compareTo(raiz.palavra) > 0) {
            incrementarLinhas(raiz.direita, palavra, numLinha);
        }
        if (palavra.compareTo(raiz.palavra) < 0) {
            incrementarLinhas(raiz.esquerda, palavra, numLinha);
        }
    }
}
