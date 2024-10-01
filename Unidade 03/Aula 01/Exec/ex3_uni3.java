public class ex3_uni3 {
    //Escreva um método que realize uma busca linear em um array de inteiros para encontrar um número
//específico e retorne a posição do número ou -1 se não for encontrado.
    public static void main(String[] args) {
        // Definição do array com valores inteiros
        int[] array = {4, 8, 42, 16, 23, 15};
         // Definição do número que queremos procurar no array
        int numeroProcurado = 15;

        // Chamada da função buscaLinear para encontrar a posição do númeroProcurado no array
        int posicao = buscaLinear(array, numeroProcurado);

        // Verifica se o número foi encontrado (posição diferente de -1) ou não
        if (posicao != -1) {
             // Exibe a mensagem com a posição do número encontrado
            System.out.println("O número " + numeroProcurado + " foi encontrado na posição: " + posicao);
        } else {
            // Exibe a mensagem indicando que o número não foi encontrado no array
            System.out.println("O número " + numeroProcurado + " não foi encontrado no array.");
        }
    }

    public static int buscaLinear(int[] array, int numeroProcurado) {
        for (int i = 0; i < array.length; i++) {
             // Percorre o array desde o primeiro até o último elemento
            if (array[i] == numeroProcurado) {
                return i; // Retorna a posição se o número for encontrado
            }
        }
        return -1; // Retorna -1 se o número não for encontrado
    }
}