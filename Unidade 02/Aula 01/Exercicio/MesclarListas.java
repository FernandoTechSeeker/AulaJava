import java.util.ArrayList;

public class MesclarListas {
    public static void main(String[] args) {
        // Criando duas listas para mesclar
        ArrayList<Integer> lista1 = new ArrayList<>();
        lista1.add(1);
        lista1.add(3);
        lista1.add(5);

        ArrayList<Integer> lista2 = new ArrayList<>();
        lista2.add(2);
        lista2.add(4);
        lista2.add(6);

        // Mesclando as listas
        ArrayList<Integer> listaMesclada = new ArrayList<>();
        int maxSize = Math.max(lista1.size(), lista2.size());

        for (int i = 0; i < maxSize; i++) {
            if (i < lista1.size()) {
                listaMesclada.add(lista1.get(i));
            }
            if (i < lista2.size()) {
                listaMesclada.add(lista2.get(i));
            }
        }

        // Exibindo a lista mesclada
        System.out.println("Lista mesclada: " + listaMesclada);
    }
}

