import java.util.*;

// Classe que representa um Grafo usando uma lista de adjacências
public class ex6_uni3 {
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

        // Implementação da Busca em Largura para encontrar o caminho mais curto
        public List<Integer> buscaEmLargura(int origem, int destino) {
            Queue<Integer> fila = new LinkedList<>(); // Fila para armazenar os vértices a serem visitados
            Map<Integer, Integer> predecessores = new HashMap<>(); // Mapa para armazenar o predecessor de cada vértice
            List<Integer> visitados = new ArrayList<>(); // Lista para armazenar os vértices já visitados

            // Inicializa a busca a partir do vértice de origem
            fila.add(origem);
            visitados.add(origem);
            predecessores.put(origem, -1); // O vértice de origem não tem predecessor

            // Enquanto a fila não estiver vazia, continue a busca
            while (!fila.isEmpty()) {
                int atual = fila.poll(); // Remove o próximo vértice da fila

                // Se o vértice atual é o destino, encerra a busca
                if (atual == destino) {
                    break;
                }

                // Explora os vizinhos do vértice atual
                for (int vizinho : adjacencias.get(atual)) {
                    // Se o vizinho ainda não foi visitado, adiciona à fila
                    if (!visitados.contains(vizinho)) {
                        fila.add(vizinho);
                        visitados.add(vizinho);
                        predecessores.put(vizinho, atual); // Registra o predecessor do vizinho
                    }
                }
            }

            // Se o destino não foi visitado, não há caminho
            if (!visitados.contains(destino)) {
                return new ArrayList<>(); // Retorna lista vazia se não houver caminho
            }

            // Constrói o caminho mais curto a partir do destino até a origem
            List<Integer> caminho = new ArrayList<>();
            int noAtual = destino;
            while (noAtual != -1) {
                caminho.add(noAtual);
                noAtual = predecessores.get(noAtual); // Volta pelo caminho dos predecessores
            }

            Collections.reverse(caminho); // Inverte o caminho para ficar da origem ao destino
            return caminho; // Retorna o caminho mais curto
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

        // Define os vértices de origem e destino para a busca em largura
        int origem = 1;
        int destino = 6;

        // Realiza a busca em largura para encontrar o caminho mais curto
        List<Integer> caminhoMaisCurto = grafo.buscaEmLargura(origem, destino);

        // Exibe o resultado
        if (caminhoMaisCurto.isEmpty()) {
            System.out.println("Não há caminho entre os vértices " + origem + " e " + destino);
        } else {
            System.out.println("Caminho mais curto entre " + origem + " e " + destino + ": " + caminhoMaisCurto);
        }
    }
}
