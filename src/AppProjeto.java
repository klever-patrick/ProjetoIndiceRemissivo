import closedhash.ClosedHash;

import java.io.*;

public class AppProjeto {
    public static void main(String[] args) throws IOException {
        ClosedHash hash = new ClosedHash(26);
        String fileName = "./src/entradas/palavras-chave/palavras-chave2.txt";
        BufferedReader entrada = new BufferedReader(new FileReader(fileName));

        String indice;
        String[] vetorIndice;

        int contador = 0;
        while (entrada.readLine() != null) {
            contador++;
        }

        entrada = new BufferedReader(new FileReader(fileName));

        vetorIndice = new String[contador];

        int i = 0;
        while ((indice = entrada.readLine()) != null) {
            vetorIndice[i] = indice;
            i++;
        }

        for (String s : vetorIndice) {
            hash.put(s);
        }

        entrada = new BufferedReader(new FileReader("./src/entradas/textos/texto2.txt"));
        String texto;
        String[] linhaTexto;
        int posicaoHash;
        int numLinha = 0;
        while ((texto = entrada.readLine()) != null) {
            numLinha++;
            linhaTexto = texto.replaceAll("[,.;:?!\\[\\]]","").split(" ");
            for (String s : linhaTexto) {
                for (String index : vetorIndice) {
                    if (s.equals(index)) {
                        posicaoHash = hash.calcularPosicao(index);
                        hash.getTabela()[posicaoHash].incrementarLinhas(hash.getTabela()[posicaoHash].getRaiz(), index, numLinha);
                    }
                }
            }
        }

        entrada.close();

        PrintStream ps = new PrintStream("./src/saida/indiceRemissivo.txt");
        System.setOut(ps);
        hash.exibirHash();

    }
}