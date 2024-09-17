import java.util.ArrayList;

public class QuickSortDecrescente {

    public static void main(String[] args) {
        // Criando a lista de números
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(5);  // (adicionar)
        numeros.add(1);
        numeros.add(9);
        numeros.add(3);
        numeros.add(7);
        numeros.add(11);
        numeros.add(-1);

        // Chamando o método Quick Sort
        quickSort(numeros, 0, numeros.size() - 1);  // (tamanho)

        // Exibindo a lista ordenada em ordem decrescente
        System.out.println(numeros);
    }

    // Método Quick Sort
    public static void quickSort(ArrayList<Integer> lista, int low, int high) {
        if (low < high) {
            // Particiona o array e obtém o índice do pivô
            int pivoIndex = partition(lista, low, high); // Particiona

            // Chama recursivamente o método Quick Sort para os dois lados do pivô
            quickSort(lista, low, pivoIndex - 1);  // Ordena a parte da esquerda
            quickSort(lista, pivoIndex + 1, high);  // Ordena a parte da direita
        }
    }

    // Método para particionar o array em duas partes
    public static int partition(ArrayList<Integer> lista, int low, int high) {
        int pivo = lista.get(high);  // Escolhe o último elemento como pivô
        int i = low - 1;  // Índice do menor elemento

        // Itera do índice low até high-1
        for (int j = low; j < high; j++) {
            // Se o elemento atual é maior ou igual ao pivô, faz a troca
            if (lista.get(j) >= pivo) {  // Compara decrescentemente
                i++;

                // Troca lista[i] com lista[j]
                int temp = lista.get(i);  // Armazena temporariamente
                lista.set(i, lista.get(j));  // (definir)
                lista.set(j, temp);  // (definir)
            }
        }

        // Troca o pivô para a posição correta
        int temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(high));
        lista.set(high, temp);

        return i + 1;  // Retorna o índice do pivô
    }
}
