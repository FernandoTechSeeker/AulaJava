

public class ExemploSelectionSort {
    

        // Função para executar o Selection Sort
        public static void selectionSort(int[] arr) {
            int tamanho = arr.length;
    
            // Loop através de cada elemento do array
            for (int i = 0; i < tamanho - 1; i++) {
                // Acha o índice do menor elemento
                int minIndex = i;
                for (int j = i + 1; j < tamanho; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;  // Atualiza o menor índice
                    }
                }
    
                // Troca o menor valor encontrado com o valor atual
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    
        // Função para exibir o array
        public static void printArray(int[] arr) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    
        public static void main(String[] args) {
            int[] arr = {64, 25, 12, 22, 11};
            System.out.println("Array original:");
            printArray(arr);
    
            selectionSort(arr);
            System.out.println("Array ordenado:");
            printArray(arr);
        }
    }
    


