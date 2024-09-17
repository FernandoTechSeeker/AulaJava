import java.util.LinkedList;
import java.util.Queue;

public class OrdemDeChegada {

    public static void main(String[] args) {
        // Criando a fila de chegada
        Queue<String> fila = new LinkedList<>();

        // Adicionando elementos à fila (ordem de chegada)
        fila.offer("Pessoa 1"); // Adiciona à fila
        fila.offer("Pessoa 2");
        fila.offer("Pessoa 3");

        // Exibindo a ordem de saída
        System.out.println("Ordem de saída:");
        while (!fila.isEmpty()) {
            System.out.println(fila.poll()); // Remove e exibe o primeiro da fila
        }
    }
}

