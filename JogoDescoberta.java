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
