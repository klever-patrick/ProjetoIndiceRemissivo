package lista;

public class ListaDinamica {
    NoLista primeiro;
    NoLista ultimo;
    int tamanho;

    public ListaDinamica() {
        primeiro = null;
        ultimo = null;
    }

    public void adicionarFinal(int valor) {
        if (!obterElemento(valor)) {
            NoLista novo = new NoLista(valor);

            if (primeiro == null) {
                primeiro = novo;
            } else {
                ultimo.proximo = novo;
            }
            ultimo = novo;
            tamanho++;
        }
    }

    public boolean vazio() {
        return tamanho == 0;
    }

    public void exibir() {
        for (NoLista atual = primeiro; atual != null; atual = atual.proximo) {
            System.out.print(" " + atual.valor + " ");
        }
        System.out.println();
    }

    public boolean obterElemento(int valor) {
        for (NoLista atual = primeiro; atual != null; atual = atual.proximo) {
            if (valor == atual.valor) {
                return true;
            }
        }
        return false;
    }

}
