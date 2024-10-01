import java.util.*;

// Classe que representa um Grafo usando uma lista de adjacências
public class ex7_uni3 {
    static class Grafo {
        private Map<Integer, List<Integer>> adjacencias; // Mapa para armazenar as listas de adjacências

        // Construtor que inicializa o mapa de adjacências
        public Grafo() {
            adjacencias = new HashMap<>();
        }

        // Método para adicionar um novo vértice ao grafo
        public void adicionarVertice(int vertice) {
            adjacencias.put(vertice, new ArrayList<>());
        }

        // Método para adicionar uma aresta entre dois vértices (grafo não direcionado)
        public void adicionarAresta(int origem, int destino) {
            adjacencias.get(origem).add(destino); // Adiciona destino na lista de adjacências de origem
            adjacencias.get(destino).add(origem); // Adiciona origem na lista de adjacências de destino
        }

        // Método para obter os vizinhos de um vértice
        public List<Integer> obterVizinhos(int vertice) {
            return adjacencias.get(vertice); // Retorna a lista de vizinhos do vértice
        }

        // Método para realizar a busca em profundidade (DFS)
        public void buscaEmProfundidade(int vertice) {
            Set<Integer> visitados = new HashSet<>(); // Conjunto para armazenar os vértices visitados
            dfs(vertice, visitados); // Chama a função recursiva DFS
        }

        // Método recursivo que implementa a lógica da busca em profundidade
        private void dfs(int vertice, Set<Integer> visitados) {
            visitados.add(vertice); // Marca o vértice atual como visitado
            System.out.print(vertice + " "); // Exibe o vértice visitado

            // Para cada vizinho do vértice, realiza a busca recursiva se ele não foi visitado
            for (int vizinho : adjacencias.get(vertice)) {
                if (!visitados.contains(vizinho)) {
                    dfs(vizinho, visitados); // Chamada recursiva para o vizinho
                }
            }
        }
    }

    public static void main(String[] args) {
        // Cria um novo grafo
        Grafo grafo = new Grafo();

        // Adiciona os vértices ao grafo
        for (int i = 1; i <= 7; i++) {
            grafo.adicionarVertice(i);
        }

        // Adiciona arestas entre os vértices
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(2, 4);
        grafo.adicionarAresta(2, 5);
        grafo.adicionarAresta(3, 6);
        grafo.adicionarAresta(3, 7);

        // Exibe os vértices visitados na busca em profundidade
        System.out.println("Vértices visitados em Busca em Profundidade (DFS):");
        grafo.buscaEmProfundidade(1); // Inicia a busca a partir do vértice 1
    }
}
