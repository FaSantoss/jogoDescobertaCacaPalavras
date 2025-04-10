// Código base para aprendizado

import java.util.Random;
import java.util.Scanner;

public class JogosCompartilhados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Escolher o jogo
        System.out.println("Escolha o jogo:");
        System.out.println("Jogo da Descoberta: 1");
        System.out.println("Caça-palavras: 2");
        System.out.print("E aí?! Qual jogo  você quer jogar?");
        int escolha = scanner.nextInt();
        scanner.nextLine(); 

        // Jogo da Descoberta
        if (escolha == 1) {
            jogarJogoDescoberta(scanner, random);
        }
        // Caça-palavras
        else if (escolha == 2) {
            jogarCacaPalavras(scanner, random);
        } else {
            System.out.println("Escolha inválida.");
        }

        scanner.close();
    }

    // Método para o Jogo da Descoberta
    private static void jogarJogoDescoberta(Scanner scanner, Random random) {
        String[] palavras = obterPalavras();
        String palavraEscolhida = escolherPalavraAleatoria(palavras, random);
        String palavraEmbaralhada = embaralharPalavra(palavraEscolhida, random);
        String dica = criarDica(palavraEscolhida);

        System.out.println("Palavra embaralhada: " + palavraEmbaralhada);
        System.out.println("Digite '!d' para receber uma dica ou '!q' para sair.");
        System.out.println("Tente adivinhar a palavra!");

        int tentativas = 0;

        while (true) {
            System.out.print("Digite sua tentativa: ");
            String tentativaUsuario = scanner.nextLine().toUpperCase();

            if (tentativaUsuario.equals("!D")) {
                System.out.println("Dica: " + dica);
                continue;
            }

            if (tentativaUsuario.equals("!Q")) {
                System.out.println("Você saiu do jogo. Tentativas feitas: " + tentativas);
                break;
            }

            tentativas++;

            if (tentativaUsuario.equals(palavraEscolhida)) {
                System.out.println("Parabéns! Você acertou a palavra em " + tentativas + " tentativas.");
                break;
            } else {
                System.out.println("Essa não é a palavra. Tente novamente!");
            }
        }
    }

    // Método para o jogo Caça-palavras
    private static void jogarCacaPalavras(Scanner scanner, Random random) {
        String[] palavras = obterPalavras();
        String palavraEscolhida = escolherPalavraAleatoria(palavras, random);
        String dica = criarDica(palavraEscolhida);

        // Gerar o tabuleiro
        char[][] tabuleiro = gerarTabuleiro(palavraEscolhida, random);

        System.out.println("Tabuleiro gerado. Tente encontrar a palavra!");
        exibirTabuleiro(tabuleiro);

        int tentativas = 0;

        while (true) {
            System.out.print("Digite sua tentativa: ");
            String tentativaUsuario = scanner.nextLine().toUpperCase();

            if (tentativaUsuario.equals("!D")) {
                System.out.println("Dica: " + dica);
                continue;
            }

            if (tentativaUsuario.equals("!Q")) {
                System.out.println("Você saiu do jogo. Tentativas feitas: " + tentativas);
                break;
            }

            tentativas++;

            if (tentativaUsuario.equals(palavraEscolhida)) {
                System.out.println("Parabéns! Você encontrou a palavra em " + tentativas + " tentativas.");
                break;
            } else {
                System.out.println("Essa não é a palavra. Tente novamente!");
            }
        }
    }

    // Método para gerar o tabuleiro de caça-palavras com letras aleatórias
    private static char[][] gerarTabuleiro(String palavra, Random random) {
        int tamanho = 10; // Tamanho fixo do tabuleiro
        char[][] tabuleiro = new char[tamanho][tamanho];

        // Preenche o tabuleiro com letras aleatórias
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                tabuleiro[i][j] = (char) ('A' + random.nextInt(26));
            }
        }

        // Coloca a palavra no tabuleiro em uma posição aleatória
        int x = random.nextInt(tamanho);
        int y = random.nextInt(tamanho - palavra.length());
        for (int i = 0; i < palavra.length(); i++) {
            tabuleiro[x][y + i] = palavra.charAt(i);
        }

        return tabuleiro;
    }

    // Método para exibir o tabuleiro de caça-palavras
    private static void exibirTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para retornar um array com algumas palavras
    private static String[] obterPalavras() {
        return new String[]{
                "GATO", "CACHORRO", "BOLA", "SOL", "LUA", "COMPUTADOR", "MESA", "CADEIRA", "FLORESTA"
        };
    }

    // Método para escolher uma palavra aleatória do array de palavras
    private static String escolherPalavraAleatoria(String[] palavras, Random random) {
        return palavras[random.nextInt(palavras.length)];
    }

    // Método para embaralhar a palavra
    private static String embaralharPalavra(String palavra, Random random) {
        char[] letras = palavra.toCharArray();

        for (int i = 0; i < letras.length; i++) {
            int j = random.nextInt(letras.length);
            char temp = letras[i];
            letras[i] = letras[j];
            letras[j] = temp;
        }

        return new String(letras);
    }

    // Método para criar a dica com a primeira e última letra
    private static String criarDica(String palavra) {
        return "A palavra começa com " + palavra.charAt(0) + " e termina com " + palavra.charAt(palavra.length() - 1);
    }
}
