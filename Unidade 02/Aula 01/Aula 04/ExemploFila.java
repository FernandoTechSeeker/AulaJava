import java.util.LinkedList;
import java.util.Queue;

public class ExemploFila {
    
    public static void main(String[] args) {  

        // FIFO, do  inglês "First In, First Out"
        Queue<String> fila = new LinkedList<>();

        //Adicionar itens a fila
        fila.offer("1 fila");

        System.out.println(fila);
        
    }
}
