public class Jogo {
    public Scanner scanner;
    public Random random;
    public int tentativas;

    // Construtor classe base
    public Jogo() {
        scanner = new Scanner(System.in);
        random = new Random();
        tentativas = 0;
    }
    // dica progressiva
    char dicaPorIndice(String palavra, int i) {
        return palavra.charAt(i);
    }
    
    // dica
    public static char[] mostrarDica(String palavra) {
        char[] dica = new char[2];
        dica[0] = palavra.charAt(0);
        dica[1] = palavra.charAt(palavra.length() - 1);
        return dica;
    }

    public void iniciarJogo() {
        
    }
}
