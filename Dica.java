package com.projeto.jogos;

public class Dica {

    public String obterDica(String palavra) {
        if (palavra == null || palavra.length() < 2) {
            return palavra;
        }
        char primeira = palavra.charAt(0);
        char ultima = palavra.charAt(palavra.length() - 1);
        return primeira + "..." + ultima;
    }
}//retorna primeir e ultima letra
