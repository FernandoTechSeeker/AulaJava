public class ex4_uni3 {
    public static void main(String[] args) {
        // Definição de um array ordenado de números inteiros
        int[] arrayOrdenado = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

        // Definimos o número que estamos procurando no array
        int numeroProcurado = 12;

        // Chamada do método de busca binária para encontrar a posição do numeroProcurado
        int posicao = buscaBinaria(arrayOrdenado, numeroProcurado);

        // Verifica se o número foi encontrado (se a posição for diferente de -1)
        if (posicao != -1) {
            // Exibe a posição do número encontrado
            System.out.println("O número " + numeroProcurado + " foi encontrado na posição: " + posicao);
        } else {
            // Se o número não for encontrado, exibe uma mensagem correspondente
            System.out.println("O número " + numeroProcurado + " não foi encontrado no array.");
        }
    }

    // Método que realiza a busca binária em um array ordenado
    public static int buscaBinaria(int[] array, int numeroProcurado) {
        // Definimos as variáveis que representam o início e o fim da área de busca
        int inicio = 0;
        int fim = array.length - 1;

        // Continuamos a busca enquanto a área de busca não for completamente eliminada
        while (inicio <= fim) {
            // Calculamos o meio do array, onde faremos a comparação
            int meio = (inicio + fim) / 2;

            // Se o valor no meio do array for o número procurado, retornamos a posição
            if (array[meio] == numeroProcurado) {
                return meio; // Número encontrado na posição "meio"
            } 
            // Se o valor no meio for menor que o número procurado, ajustamos o início da busca
            else if (array[meio] < numeroProcurado) {
                inicio = meio + 1;
            } 
            // Se o valor no meio for maior, ajustamos o fim da busca
            else {
                fim = meio - 1;
            }
        }

        // Retornamos -1 se o número não for encontrado no array
        return -1;
    }
}
