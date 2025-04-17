import java.util.Random;
import java.util.Scanner;



public class JogoDaDescoberta extends Jogo {
    String[] palavras = {
        "rinoceronte", "idade", "instituto", "parana",
        "macarronada", "cadeira", "carro", "celta",
        "computador", "teclado", "informatica",
        "ferro", "vida", "molhado", "alegria",
        "felicidade", "caminhar", "corrida"
    };

   
    public void iniciarJogo() {
        String palavraEscolhida = palavras[random.nextInt(palavras.length)].toUpperCase;
        String palavraEmbaralhada = embaralharPalavra(palavraEscolhida, random);
        char[] dica = Jogo.mostrarDica(palavraEmbaralhada);

        System.out.println("Palavra embaralhada: " + palavraEmbaralhada);
        System.out.println("Digite \".dica\" para ter uma dica e \".sair\" para sair do jogo.");

        
        while (true) {
            System.out.print("Adivinhe: ");
            String input = scanner.next().toUpperCase();

            if (input.equals(".DICA")) {
                System.out.println("Dica: a primeira letra é " + dica[0] + " e a última letra é " + dica[1]);
            }
            if (input.equals(".SAIR")) {
                System.out.println("Jogo finalizado. Tentativas: " + tentativas);
                break;
            }
            tentativas++;
            if (input.equals(palavraEscolhida)) {
                System.out.println("Parabéns, você é f#da, acertou! Tentativas: " + tentativas);
                break;
            } else {
                System.out.println("Maôe, Erouuu! Tentativas: " + tentativas);
            }
        }
    }

    // Método que embaralha as palavras
    private static String embaralharPalavra(String palavra, Random random) {
        char[] letras = palavra.toCharArray();
        for (int i = 0; i < letras.length; i++) {
            int pos = random.nextInt(letras.length);
            char temp = letras[i];
            letras[i] = letras[pos];
            letras[pos] = temp;
        }
        return new String(letras);
    }
}

// Caça-Palavras
class CacaPalavras extends Jogo {
    String[] palavras = {"agua", "camelo", "triste", "cambio", "sapos"};
    
    public void iniciarJogo() {
        int tamanho = 10;
       
        char[][] tabuleiro = gerarMatrizVazia(tamanho);
        preencherMatriz(tabuleiro, random);
        String palavraEscolhida = palavras[random.nextInt(palavras.length)].toUpperCase();
        inserirPalavraVertical(tabuleiro, palavraEscolhida, random);
        
        System.out.println("Caça-Paavras:");
        imprimirMatriz(tabuleiro);

        
        char[] dica = Jogo.mostrarDica(palavraEscolhida);
        System.out.println("Digite \".dica\" para receber uma dica e \".sair\" para sair do jogo.");
        int contDica = 0

        while (true) {
            System.out.print("Tente adivinhar a palavra escondida: ");
            String input = scanner.next().toUpperCase();
            
            if (input.equals(".DICA") && contDica == 0) {
                
                System.out.println("Dica: a primeira letra é " + dica[0] + " e a última letra é " + dica[1]);
                contDica++;
            }

            else if (input.equals(".DICA") && contDica > 0) {
                
                System.out.println("Dica: a próxima dica de letra é " + dica[contDica]);
            }

            else if(input.equals(".DICA") && contDica > palavra.length){
                System.out.println("Você não acha que já pediu dica demais, cara? Toma a palavra inteira então: " palavra);
                

            if (input.equals(".SAIR")) {
                System.out.println("Jogo finalizado. Tentativas: " + tentativas);
                break;
            }
            tentativas++;
            if (input.equals(palavraEscolhida)) {
                System.out.println("Parabéns, você é craque! Acertou! Tentativas: " + tentativas);
                break;
            } else {
                System.out.println("Errouuu! Tentativas: " + tentativas);
            }
        }
    }
    
    private static char[][] gerarMatrizVazia(int tamanho) {
        return new char[tamanho][tamanho];
    }
    
    private static void preencherMatriz(char[][] matriz, Random random) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (char) ('A' + random.nextInt(26));
            }
        }
    }
    
    private static void imprimirMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private static void inserirPalavraVertical(char[][] matriz, String palavra, Random random) {
        int linhas = matriz.length;
        int colunas = matriz[0].length;
        int linhaInicial = random.nextInt(linhas - palavra.length() + 1);
        int coluna = random.nextInt(colunas);
        for (int i = 0; i < palavra.length(); i++) {
            matriz[linhaInicial + i][coluna] = palavra.charAt(i);
        }
    }
}

public class JogosCompartilhados {
    public static void main(String[] args) {
        
        System.out.println("Escolha o jogo:");
        System.out.println("1 - Jogo da Descoberta");
        System.out.println("2 - Caça-Palavras");
        System.out.print("Digite 1 ou 2: ");
        int escolha = scanner.nextInt();

        Jogo jogo;
        if (escolha == 1) {
            jogo = new JogoDaDescoberta();
        } else if (escolha == 2) {
            jogo = new CacaPalavras();
        } else {
            System.out.println("Opção inválida!");
            return;
        }

        jogo.iniciarJogo();
    }
}
