import java.util.Random;
import java.util.Scanner;

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
