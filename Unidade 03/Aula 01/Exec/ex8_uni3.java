public class ex8_uni3 {
    // Classe interna que representa um nó da árvore
    static class No {
        int valor; // Valor armazenado no nó
        No esquerda; // Referência para o filho à esquerda
        No direita;  // Referência para o filho à direita

        // Construtor para inicializar o nó com um valor
        public No(int valor) {
            this.valor = valor;
            esquerda = null; // Inicializa o filho à esquerda como null
            direita = null;  // Inicializa o filho à direita como null
        }
    }

    private No raiz; // Referência para a raiz da árvore

    // Construtor da árvore que inicializa a raiz como null
    public ex8_uni3() {
        raiz = null;
    }

    // Método público para inserir um valor na árvore
    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor); // Chama o método recursivo para inserir o valor
    }

    // Método recursivo que insere um valor na árvore
    private No inserirRecursivo(No no, int valor) {
        // Se o nó atual é null, cria um novo nó com o valor
        if (no == null) {
            return new No(valor);
        }

        // Se o valor a ser inserido é menor que o valor do nó atual, insere à esquerda
        if (valor < no.valor) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } 
        // Se o valor a ser inserido é maior que o valor do nó atual, insere à direita
        else if (valor > no.valor) {
            no.direita = inserirRecursivo(no.direita, valor);
        }

        // Retorna o nó atual (usado nas chamadas recursivas)
        return no;
    }

    // Método para encontrar o menor valor na árvore
    public int encontrarMenorValor() {
        return encontrarMenorValorRecursivo(raiz); // Chama o método recursivo passando a raiz
    }

    // Método recursivo para encontrar o menor valor
    private int encontrarMenorValorRecursivo(No no) {
        // O menor valor estará no nó mais à esquerda
        if (no.esquerda == null) {
            return no.valor; // Se não houver filho à esquerda, o valor do nó atual é o menor
        }

        // Continua procurando à esquerda
        return encontrarMenorValorRecursivo(no.esquerda);
    }

    // Método principal para testar a árvore
    public static void main(String[] args) {
        ex8_uni3 arvore = new ex8_uni3();

        // Inserção de valores na árvore
        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(15);
        arvore.inserir(3);
        arvore.inserir(8);

        // Busca do menor valor na árvore
        int menorValor = arvore.encontrarMenorValor();
        System.out.println("O menor valor na árvore é: " + menorValor);
    }
}
