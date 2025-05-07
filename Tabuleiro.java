package com.projeto.jogos;

import java.util.Random;

public class Tabuleiro {
    private char[][] grid;
    private int linhas;
    private int colunas;

    // construtor com this
    public Tabuleiro(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        grid = new char[linhas][colunas];
    }

    public void imprimir() {
        JogoUtil.imprimirTabuleiro(grid);
    }

    //tentei usar o get, parece que deu certo mas nao sei se esta bem implementado
    public char[][] getGrid() {
        return grid;
    }

    public void esconderPalavraHorizontal(String palavra, Random random) {
        int tamanho = palavra.length();
        int linha = random.nextInt(linhas);
        int maxInicio = colunas - tamanho;
        int inicio = random.nextInt(maxInicio + 1);
        for (int j = 0; j < tamanho; j++) {
            grid[linha][inicio + j] = palavra.charAt(j);
        }
    }
}
