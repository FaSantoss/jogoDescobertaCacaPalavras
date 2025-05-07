package com.projeto.jogos;

import java.util.Random;

// classe em comum
public class JogoUtil {
    //aqui eu checo os palpites e dou uma resposta se estiver certo ou errado, depende
    public static boolean checarPalpite(String palpite, String palavraSecreta) {
        if (palpite.equalsIgnoreCase(palavraSecreta)) {
            System.out.println("Parabéns! Você acertou a palavra: " + palavraSecreta);
            return true;
        }
        System.out.println("Errado, tente novamente.");
        return false;
    }

// emaralha as palavras
        public static String embaralharPalavra(String palavra) {
        Random random = new Random();
        char[] caracteres = palavra.toCharArray();
        for (int i = caracteres.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char aux = caracteres[i];
            caracteres[i] = caracteres[j];
            caracteres[j] = aux;
        }
        return new String(caracteres);
    }

    // manda msg de desistencia
    public static void desistir(String palavraSecreta) {
        System.out.println("Você desistiu! A palavra era: " + palavraSecreta);
    }

    //imprime o tabuleiro
    public static void imprimirTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }
}
