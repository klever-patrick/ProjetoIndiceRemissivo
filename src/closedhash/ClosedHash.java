package closedhash;

import arvore.ArvoreBinariaBusca;

public class ClosedHash {
    private final ArvoreBinariaBusca[] tabela;

    public ClosedHash(int tamanho) {
        tabela = new ArvoreBinariaBusca[tamanho];
    }

    public ArvoreBinariaBusca[] getTabela() {
        return tabela;
    }

    public int calcularPosicao(String valor) {
        char primeiraLetra = valor.toUpperCase().charAt(0);
        int posicao;
        char[] caractere = new char[26];
        for(int i = 0; i < 26; i++){
            caractere[i] = (char)(65 + i);
            if (primeiraLetra == caractere[i]) {
                posicao = i;
                return posicao;
            }
        }
        return 0;
    }

    public void put(String valor) {
        int posicao = calcularPosicao(valor);
        if (tabela[posicao] == null) {
            tabela[posicao] = new ArvoreBinariaBusca();
        }
        tabela[posicao].adicionar(valor);
    }

    public void exibirHash() {
        for (ArvoreBinariaBusca arvoreBinariaBusca : tabela) {
            if (arvoreBinariaBusca != null) {
                arvoreBinariaBusca.exibirEmOrdem();
            }
        }
    }
}
