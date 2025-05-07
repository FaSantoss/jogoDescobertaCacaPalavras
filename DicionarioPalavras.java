package com.projeto.jogos;

import java.util.Random;

// classe p um mini banco de palavras e escolhe uma palavra random
public class DicionarioPalavras {
    private String[] palavras;    // vetor de palavras
    private Random random;        // gera numrandom

    // construtor q serve p iniciar um banco de palavras
    public DicionarioPalavras() {
        this.palavras = new String[]{
                "JAVA",
                "POO",
                "CLASH",
                "MOUSE",
                "NEYMAR"
        };
        this.random = new Random();
    }

    public String obterPalavraAleatoria() {
        int indice = random.nextInt(palavras.length);
        return palavras[indice];
    }// metodo p escolher e retornar uma palavra aleatoria do banco interno
}

