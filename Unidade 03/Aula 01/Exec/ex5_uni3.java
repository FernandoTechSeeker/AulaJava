import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Classe que representa um Grafo utilizando um Map para armazenar as adjacências
class Grafo {
    // Mapa que armazena a lista de adjacências de cada vértice
    private Map<Integer, List<Integer>> adjacencias;

    // Construtor que inicializa o mapa de adjacências
    public Grafo() {
        adjacencias = new HashMap<>();
    }

    // Método para adicionar um novo vértice ao grafo
    public void adicionarVertice(int vertice) {
        adjacencias.put(vertice, new ArrayList<>()); // Cria uma lista vazia de vizinhos
    }

    // Método para adicionar uma aresta entre dois vértices (grafo não direcionado)
    public void adicionarAresta(int origem, int destino) {
        adjacencias.get(origem).add(destino); // Adiciona destino na lista de adjacências de origem
        adjacencias.get(destino).add(origem); // Adiciona origem na lista de adjacências de destino (grafo não direcionado)
    }

    // Método para obter a lista de vizinhos de um vértice específico
    public List<Integer> obterVizinhos(int vertice) {
        return adjacencias.get(vertice); // Retorna a lista de adjacências do vértice fornecido
    }
}

// Classe principal para testar o grafo
public class ex5_uni3 {
    public static void main(String[] args) {
        // Criação de um novo grafo
        Grafo grafo = new Grafo();

        // Adição de vértices ao grafo
        grafo.adicionarVertice(1);
        grafo.adicionarVertice(2);
        grafo.adicionarVertice(3);
        grafo.adicionarVertice(4);

        // Adição de arestas entre os vértices
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 4);

        // Exibição dos vizinhos de cada vértice
        System.out.println("Vizinhos do vértice 1: " + grafo.obterVizinhos(1));
        System.out.println("Vizinhos do vértice 2: " + grafo.obterVizinhos(2));
        System.out.println("Vizinhos do vértice 3: " + grafo.obterVizinhos(3));
        System.out.println("Vizinhos do vértice 4: " + grafo.obterVizinhos(4));
    }
}
