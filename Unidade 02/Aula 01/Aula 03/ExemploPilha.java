import java.util.ArrayDeque;
import java.util.Deque;

public class ExemploPilha {

    public static void main(String[] args) {

        // LIFO, do inglês "Last In, First Out"
        Deque<Integer> pilha = new ArrayDeque<>();

        //PUSh para add  itens novos na pilha
        pilha.push(10);
        pilha.push(15);
        pilha.push(20);
        pilha.push(30);
        pilha.push(56);

        System.out.println(pilha);

        //Visualizar o primeiro item da pilha sem remover
        System.out.println(pilha.peek());

        // Retorna o primeiro item da pilha e remove ele da pilha
        System.out.println(pilha.pop()); 
        System.out.println(pilha);

        // laço while ele so roda quando é verdadeiro "!"
        //condiconal invertendo a informação  se der verdadeiro ele reponde falso e vice versa
        //desempilhando toda a pilha intem a intem 
        while (!pilha.isEmpty()) {
            System.out.println(pilha.pop());
        }
    }
    
}
