import java.util.*;

public class ex9_uni3 {
    // Classe que representa um Grafo ponderado (com pesos nas arestas)
    static class Grafo {
        // Mapa de adjacências: chave -> vértice, valor -> outro mapa com vértice vizinho e o peso da aresta
        private Map<Integer, Map<Integer, Integer>> adjacencias;

        // Construtor que inicializa o mapa de adjacências
        public Grafo() {
            adjacencias = new HashMap<>();
        }

        // Método para adicionar um vértice ao grafo
        public void adicionarVertice(int vertice) {
            adjacencias.put(vertice, new HashMap<>()); // Adiciona o vértice com uma lista de vizinhos vazia
        }

        // Método para adicionar uma aresta ponderada entre dois vértices
        public void adicionarAresta(int origem, int destino, int peso) {
            adjacencias.get(origem).put(destino, peso); // Adiciona destino e o peso à lista de adjacências do vértice origem
            adjacencias.get(destino).put(origem, peso); // Adiciona origem e o peso à lista de adjacências do vértice destino
        }

        // Método para buscar o caminho mais curto entre dois vértices usando Dijkstra
        public List<Integer> buscaCaminhoMaisCurto(int origem, int destino) {
            // Mapa para armazenar a menor distância de cada vértice em relação à origem
            Map<Integer, Integer> distancia = new HashMap<>();
            // Mapa para armazenar o predecessor de cada vértice no caminho mais curto
            Map<Integer, Integer> predecessores = new HashMap<>();
            // Fila de prioridade para processar os vértices com base na menor distância
            PriorityQueue<Integer> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(distancia::get));

            // Inicializa as distâncias como infinito (Integer.MAX_VALUE) e os predecessores como -1
            for (int vertice : adjacencias.keySet()) {
                distancia.put(vertice, Integer.MAX_VALUE);
                predecessores.put(vertice, -1); // -1 significa que não há predecessor
            }

            // A distância da origem até ela mesma é 0
            distancia.put(origem, 0);
            filaPrioridade.add(origem); // Adiciona o vértice de origem à fila

            // Processa os vértices da fila de prioridade
            while (!filaPrioridade.isEmpty()) {
                int atual = filaPrioridade.poll(); // Remove o vértice com a menor distância da fila

                // Para cada vizinho do vértice atual
                for (int vizinho : adjacencias.get(atual).keySet()) {
                    // Calcula a nova distância através do vértice atual
                    int novaDistancia = distancia.get(atual) + adjacencias.get(atual).get(vizinho);
                    // Se a nova distância for menor que a distância armazenada, atualiza
                    if (novaDistancia < distancia.get(vizinho)) {
                        distancia.put(vizinho, novaDistancia);
                        predecessores.put(vizinho, atual); // Atualiza o predecessor do vizinho
                        filaPrioridade.add(vizinho); // Adiciona o vizinho à fila para processar
                    }
                }
            }

            // Se a distância até o destino for infinita, não há caminho
            if (distancia.get(destino) == Integer.MAX_VALUE) {
                return new ArrayList<>(); // Retorna uma lista vazia indicando que não há caminho
            }

            // Constrói o caminho mais curto a partir do destino
            List<Integer> caminho = new ArrayList<>();
            int noAtual = destino;
            while (noAtual != -1) {
                caminho.add(noAtual); // Adiciona o nó ao caminho
                noAtual = predecessores.get(noAtual); // Vai para o predecessor
            }

            // Inverte a lista para que o caminho seja da origem para o destino
            Collections.reverse(caminho);
            return caminho; // Retorna o caminho mais curto
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo(); // Cria um novo grafo

        // Adiciona os vértices ao grafo
        for (int i = 1; i <= 7; i++) {
            grafo.adicionarVertice(i);
        }

        // Adiciona arestas com pesos entre os vértices
        grafo.adicionarAresta(1, 2, 4);  // Aresta entre vértice 1 e 2 com peso 4
        grafo.adicionarAresta(1, 3, 2);  // Aresta entre vértice 1 e 3 com peso 2
        grafo.adicionarAresta(2, 4, 5);  // Aresta entre vértice 2 e 4 com peso 5
        grafo.adicionarAresta(2, 5, 3);  // Aresta entre vértice 2 e 5 com peso 3
        grafo.adicionarAresta(3, 6, 7);  // Aresta entre vértice 3 e 6 com peso 7
        grafo.adicionarAresta(3, 7, 4);  // Aresta entre vértice 3 e 7 com peso 4

        // Define os vértices de origem e destino para a busca do caminho mais curto
        int origem = 1;
        int destino = 6;

        // Busca o caminho mais curto entre os vértices 1 e 6
        List<Integer> caminhoMaisCurto = grafo.buscaCaminhoMaisCurto(origem, destino);

        // Exibe o resultado
        if (caminhoMaisCurto.isEmpty()) {
            System.out.println("Não há caminho entre os vértices " + origem + " e " + destino);
        } else {
            System.out.println("Caminho mais curto entre " + origem + " e " + destino + ": " + caminhoMaisCurto);
        }
    }
}
