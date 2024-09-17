import java.util.ArrayList;

public class RemoverDuplicados {
    public static void main(String[] args) {
        // Criando uma lista com elementos duplicados
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(4);
        lista.add(5);

        // Exibindo a lista original
        System.out.println("Lista original: " + lista);

        // Removendo os duplicados
        ArrayList<Integer> listaSemDuplicados = new ArrayList<>();
        for (Integer num : lista) {
            if (!listaSemDuplicados.contains(num)) {
                listaSemDuplicados.add(num);
            }
        }

        // Exibindo a lista sem duplicados
        System.out.println("Lista sem duplicados: " + listaSemDuplicados);
    }
}
