package com.projeto.jogos;

public abstract class Jogo {

        public abstract void iniciar(); // pode exibir tato o tabuleiro quanto a palavra embaralhda
        public abstract boolean tentar(String palpite);
        public abstract String dica();
        public abstract void desistir();

}
// usei abstract para deixar "incompleto" e permitir que outras subclasses possam completar
