package com.projeto.jogos;

public class JogoDescoberta {
    private DicionarioPalavras dicionario;
    private Dica dica;
    private String palavraSecreta;
    private String palavraEmbaralhada;     // letras misturadas
    private boolean encerrado;             // ve se ainda tem jogo

    // construtor: dicas e dicionario
    public JogoDescoberta(DicionarioPalavras dict, Dica dicaObj) {
        dicionario = dict;
        dica = dicaObj;
        encerrado = false;
    }

    // inicia o jogo: escolhe a palavra, embaralha e exibe
    public void iniciar() {
        palavraSecreta = dicionario.obterPalavraAleatoria();
        palavraEmbaralhada = JogoUtil.embaralharPalavra(palavraSecreta);
        System.out.println("Palavra embaralhada: " + palavraEmbaralhada);
    }

    // recebe uma tentativa e ve se está correta
    public boolean tentar(String palpite) {
        encerrado = JogoUtil.checarPalpite(palpite, palavraSecreta);
        return encerrado;
    }

    // retona dica
    public String obterDica() {
        return dica.obterDica(palavraSecreta);
    }

    // acaba o jogo e exibe msg de desistencia
    public void desistir() {
        encerrado = true;
        JogoUtil.desistir(palavraSecreta);
    }
}
