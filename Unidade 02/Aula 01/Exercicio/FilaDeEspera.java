import java.util.LinkedList;
import java.util.Queue;

public class FilaDeEspera {

    public static void main(String[] args) {
        // Criando a fila de espera
        Queue<String> fila = new LinkedList<>();

        // Adicionando elementos à fila
        fila.offer("Cliente 1");
        fila.offer("Cliente 2");
        fila.offer("Cliente 3");

        // Exibindo o primeiro elemento da fila
        System.out.println("Primeiro da fila: " + fila.peek());

        // Removendo o primeiro elemento da fila
        fila.poll();
        System.out.println("Depois de remover, o primeiro da fila é: " + fila.peek());

        // Exibindo todos os elementos restantes
        System.out.println("Fila atual: " + fila);
    }
}
