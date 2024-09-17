import java.util.ArrayList;

public class InversaoLista {
    public static void main(String[] args) {
        // Criando uma lista com elementos
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        // Exibindo a lista original
        System.out.println("Lista original: " + lista);

        // Invertendo a lista manualmente
        ArrayList<Integer> listaInvertida = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            listaInvertida.add(lista.get(i));
        }

        // Exibindo a lista invertida
        System.out.println("Lista invertida: " + listaInvertida);
    }
}
