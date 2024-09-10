import java.util.ArrayList;

public class Lista {

    public static void main(String[] args) {
        String [] ListaCompras = new String[3];

        ListaCompras[0] = "Banana";
        ListaCompras[1] = "Tomate";
        ListaCompras[2] = "Feijão";

        ArrayList<String>ListaComprasUpgrade = new ArrayList<>();

        // adicionar itens novos a lista
        ListaComprasUpgrade.add("Queijo");
        ListaComprasUpgrade.add("Presunto");
        ListaComprasUpgrade.add("Pão");
        ListaComprasUpgrade.add("Tomate");

        // visualiza um item das listas 
        System.out.println(ListaCompras[2]);
        System.out.println(ListaComprasUpgrade.get(3));

        // conta quantos itens tem na lista
        System.out.println(ListaCompras.length);
        System.out.println(ListaComprasUpgrade.size());

        // busca na lista pelo item passado true/false
        System.out.println(ListaComprasUpgrade.contains("Presunto"));

        // remover um item da lista 
        ListaComprasUpgrade.remove("Tomate");
        ListaComprasUpgrade.remove(3);

        // limpa a lista inteira, deixa ela completamente vazia
        ListaComprasUpgrade.clear();
    }
}