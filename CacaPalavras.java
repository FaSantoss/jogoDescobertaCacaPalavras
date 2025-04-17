
// Caça-Palavras
class CacaPalavras Jogo {
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
