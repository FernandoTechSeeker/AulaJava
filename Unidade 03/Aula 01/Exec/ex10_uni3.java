import java.util.*;

public class ex10_uni3 {
    // Classe que representa um Grafo direcionado
    static class Grafo {
        // Mapa de adjacências: chave -> vértice, valor -> lista de vértices vizinhos (direcionado)
        private Map<Integer, List<Integer>> adjacencias;

        // Construtor que inicializa o mapa de adjacências
        public Grafo() {
            adjacencias = new HashMap<>();
        }

        // Método para adicionar um vértice ao grafo
        public void adicionarVertice(int vertice) {
            adjacencias.put(vertice, new ArrayList<>());
        }

        // Método para adicionar uma aresta direcionada entre dois vértices
        public void adicionarAresta(int origem, int destino) {
            adjacencias.get(origem).add(destino); // Aresta do vértice origem para o vértice destino
        }

        // Método para realizar a ordenação topológica
        public List<Integer> ordenacaoTopologica() {
            // Mapa que armazena o grau de entrada de cada vértice (quantidade de arestas que chegam a ele)
            Map<Integer, Integer> grauEntrada = new HashMap<>();
            for (int vertice : adjacencias.keySet()) {
                grauEntrada.put(vertice, 0); // Inicializa o grau de entrada como 0
            }

            // Calcula o grau de entrada de cada vértice
            for (List<Integer> vizinhos : adjacencias.values()) {
                for (int vizinho : vizinhos) {
                    grauEntrada.put(vizinho, grauEntrada.get(vizinho) + 1); // Incrementa o grau de entrada dos vizinhos
                }
            }

            // Fila para armazenar os vértices com grau de entrada 0 (sem dependências)
            Queue<Integer> fila = new LinkedList<>();
            for (int vertice : adjacencias.keySet()) {
                if (grauEntrada.get(vertice) == 0) {
                    fila.add(vertice); // Adiciona os vértices que não têm dependências à fila
                }
            }

            // Lista para armazenar o resultado da ordenação topológica
            List<Integer> resultado = new ArrayList<>();
            while (!fila.isEmpty()) {
                int vertice = fila.poll(); // Remove o vértice da fila
                resultado.add(vertice);    // Adiciona o vértice ao resultado

                // Para cada vizinho do vértice, reduz o grau de entrada e, se necessário, o adiciona à fila
                for (int vizinho : adjacencias.get(vertice)) {
                    grauEntrada.put(vizinho, grauEntrada.get(vizinho) - 1); // Decrementa o grau de entrada
                    if (grauEntrada.get(vizinho) == 0) {
                        fila.add(vizinho); // Adiciona à fila se o grau de entrada se tornar 0
                    }
                }
            }

            // Verifica se o grafo contém ciclos (se o resultado não tem o mesmo número de vértices)
            if (resultado.size() != adjacencias.size()) {
                // Se houver ciclos, a ordenação topológica não é possível
                return new ArrayList<>();
            }

            return resultado; // Retorna a lista com a ordenação topológica
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Adiciona os vértices ao grafo
        for (int i = 1; i <= 6; i++) {
            grafo.adicionarVertice(i);
        }

        // Adiciona as arestas direcionadas (dependências) entre os vértices
        grafo.adicionarAresta(1, 2);  // Vértice 1 depende de 2
        grafo.adicionarAresta(1, 3);  // Vértice 1 depende de 3
        grafo.adicionarAresta(2, 4);  // Vértice 2 depende de 4
        grafo.adicionarAresta(2, 5);  // Vértice 2 depende de 5
        grafo.adicionarAresta(3, 5);  // Vértice 3 depende de 5
        grafo.adicionarAresta(4, 6);  // Vértice 4 depende de 6
        grafo.adicionarAresta(5, 6);  // Vértice 5 depende de 6

        // Realiza a ordenação topológica
        List<Integer> ordenacaoTopologica = grafo.ordenacaoTopologica();

        // Verifica se foi possível realizar a ordenação topológica
        if (ordenacaoTopologica.isEmpty()) {
            System.out.println("O grafo possui ciclo. Não é possível realizar a ordenação topológica.");
        } else {
            System.out.println("Ordenação topológica dos vértices: " + ordenacaoTopologica);
        }
    }
}
