import java.util.ArrayDeque;
import java.util.Deque;

public class Documentos {
    //Atributos dos documentos
    private String titulo;
    private int nPaginas;

    //construtor
    public Documentos(String titulo, int nPaginas) {
        this.titulo = titulo;
        this.nPaginas = nPaginas;
    }

    public static void main(String[] args) {
        // ter certeza do que esta fazendo
        Deque<Documentos> pilha = new ArrayDeque<>();

        Documentos doc = new Documentos("Processo 123", 100);
        Documentos doc2 = new Documentos("Processso 456" , 240);
        Documentos doc3 = new Documentos("Processso 789" , 675);
        Documentos doc4 = new Documentos("Processso 321" , 45);
        Documentos doc5 = new Documentos("Processso 654" , 72);

        pilha.push(doc);
        pilha.push(doc2);
        pilha.push(doc3);
        pilha.push(doc4);
        pilha.push(doc5);

        while(!pilha.isEmpty()){     //ei não precisa do cast, tendo certeza do que colocou do DEQUE
            Documentos tempDocumentos = (Documentos)pilha.pop();
            System.out.println("Titulo:   " + tempDocumentos.titulo);
            System.out.println("Páginas:  " + tempDocumentos.nPaginas);
            System.out.println("");

        }

        

    }
}
