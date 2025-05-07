package com.projeto.jogos;

import java.util.Random;

public class JogoCacaPalavras {
    private DicionarioPalavras dicionario;
    private Dica dica;
    private String palavraSecreta;         // palavra q vai ser encontrada
    private boolean encerrado;             // ve se o jogo ja acabou

    //tamanho fixo
    private static final int TAMANHO_TABULEIRO = 10;

    // construtor: dicas e dicionario
    public JogoCacaPalavras(DicionarioPalavras dict, Dica dicaObj) {
        dicionario = dict;
        dica = dicaObj;
        encerrado = false;
    }

    // inicia o game, escolhe palavra, monta e exibe o tabuleiro
    public void iniciar() {
        palavraSecreta = dicionario.obterPalavraAleatoria();
        Tabuleiro tab = new Tabuleiro(TAMANHO_TABULEIRO, TAMANHO_TABULEIRO);
        Random random = new Random();

        //preenche
        char[][] grid = tab.getGrid();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = (char) ('A' + random.nextInt(26));
            }
        }

        tab.esconderPalavraHorizontal(palavraSecreta, random);

        //mostra
        System.out.println("Tabuleiro de Caça-Palavras:");
        tab.imprimir();
    }

    //recebe tentativa e ve se ta certo ou errado, depende
    public boolean tentar(String palpite) {
        encerrado = JogoUtil.checarPalpite(palpite, palavraSecreta);
        return encerrado;
    }

    // dica
    public String obterDica() {
        return dica.obterDica(palavraSecreta);
    }

    // acaba o jogo com msg de desistencia
    public void desistir() {
        encerrado = true;
        JogoUtil.desistir(palavraSecreta);
    }
}
