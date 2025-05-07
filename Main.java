package com.projeto.jogos;

import java.util.Scanner;

//criaçao e escolha de qual jogo quer jogar
public class Main {
    public static void main(String[] args) {
        DicionarioPalavras dict = new DicionarioPalavras();
        Dica dica = new Dica();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o jogo:");
        System.out.println("1 - Caça-Palavras");
        System.out.println("2 - Jogo da Descoberta");
        System.out.print("Digite o número da opção: ");
        String opcao = scanner.nextLine().trim();

        if ("1".equals(opcao)) {
            rodarCacaPalavras(dict, dica, scanner);
        } else if ("2".equals(opcao)) {
            rodarJogoDescoberta(dict, dica, scanner);
        } else {
            System.out.println("Opção inválida. Encerrando.");
        }

        scanner.close();
        System.out.println("Acabou paizao, valeu");
    }


    // metodo do caça palavras
    private static void rodarCacaPalavras(DicionarioPalavras dict, Dica dica, Scanner scanner) {
        JogoCacaPalavras jogo = new JogoCacaPalavras(dict, dica);
        System.out.println("=== Caça-Palavras ===");
        jogo.iniciar();
        while (true) {
            System.out.print("Palpite (ou 'dica'/'desistir'): ");
            String entrada = scanner.nextLine().trim();
            if (entrada.equalsIgnoreCase("dica")) {
                System.out.println(jogo.obterDica());
            } else if (entrada.equalsIgnoreCase("desistir")) {
                jogo.desistir();
                break;
            } else if (jogo.tentar(entrada)) {
                break;
            }
        }
    }

    // metodo do jogo da descobert
    private static void rodarJogoDescoberta(DicionarioPalavras dict, Dica dica, Scanner scanner) {
        JogoDescoberta jogo = new JogoDescoberta(dict, dica);
        System.out.println("\n=== Jogo da Descoberta ===");
        jogo.iniciar();
        while (true) {
            System.out.print("Palpite (ou 'dica'/'desistir'): ");
            String entrada = scanner.nextLine().trim();
            if (entrada.equalsIgnoreCase("dica")) {
                System.out.println(jogo.obterDica());
            } else if (entrada.equalsIgnoreCase("desistir")) {
                jogo.desistir();
                break;
            } else if (jogo.tentar(entrada)) {
                break;
            }
        }
    }
}
