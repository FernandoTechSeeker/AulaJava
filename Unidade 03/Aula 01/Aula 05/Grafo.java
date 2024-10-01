import java.util.LinkedList;

public class Grafo {
    @SuppressWarnings("unused")
    private int numeroDeCidades;
    private LinkedList<Integer> adj[];  // Lista de adjacências para representar as estradas

    @SuppressWarnings({ "unchecked", "rawtypes" })
    Grafo(int v) {
        numeroDeCidades = v;
        adj = new LinkedList[v];  // Inicializa a lista de adjacências
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();  // Cada cidade terá uma lista de conexões
        }
    }

    // Adiciona uma estrada entre duas cidades
    void addEstrada(int cidade1, int cidade2) {
        adj[cidade1].add(cidade2);
        adj[cidade2].add(cidade1);  // Estrada bidirecional
    }

    public static void main(String[] args) {
        Grafo mapa = new Grafo(5);  // Mapa com 5 cidades

        // Adiciona estradas entre as cidades
        mapa.addEstrada(0, 1);  // Estrada entre cidade 0 e cidade 1
        mapa.addEstrada(2, 4);  // Estrada entre cidade 2 e cidade 4
        mapa.addEstrada(0, 3);  // Estrada entre cidade 0 e cidade 3
        mapa.addEstrada(1, 4);  // Estrada entre cidade 1 e cidade 4

        // Exibe as conexões (estradas) de cada cidade
        System.out.println("Estradas conectando a cidade 0: " + mapa.adj[0]);
        System.out.println("Estradas conectando a cidade 1: " + mapa.adj[1]);
        System.out.println("Estradas conectando a cidade 2: " + mapa.adj[2]);
        System.out.println("Estradas conectando a cidade 3: " + mapa.adj[3]);
        System.out.println("Estradas conectando a cidade 4: " + mapa.adj[4]);
    }
}

