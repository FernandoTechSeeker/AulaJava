public class ex2_uni3 {
//Escreva um método para verificar se uma árvore binária é uma árvore binária de busca (BST).
    // Classe interna para representar os nós da árvore
    static class No {
        int valor; // Valor armazenado no nó
        No esquerda; // Referência para o filho à esquerda
        No direita; // Referência para o filho à direita

        // Construtor para inicializar o nó com um valor
        public No(int valor) {
            this.valor = valor;
            esquerda = null; // Inicialmente, nenhum filho à esquerda
            direita = null;  // Inicialmente, nenhum filho à direita
        }
    }

    private No raiz; // Raiz da árvore

    // Método para verificar se a árvore é uma Árvore Binária de Busca (BST)
    public boolean verificaBST() {
        // Chama o método recursivo, passando os limites mínimos e máximos de valor
        return verificaBSTRecursivo(raiz, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Método recursivo para verificar se a árvore é uma BST
    private boolean verificaBSTRecursivo(No no, int valorMin, int valorMax) {
        // Caso base: se o nó for nulo, é uma BST válida (árvore vazia)
        if (no == null) {
            return true;
        }

        // Verifica se o valor do nó está dentro dos limites permitidos
        if (no.valor < valorMin || no.valor > valorMax) {
            return false; // Se estiver fora dos limites, não é uma BST
        }

        // Recursivamente verifica a subárvore esquerda e direita,
        // ajustando os limites de valor
        return (verificaBSTRecursivo(no.esquerda, valorMin, no.valor - 1) &&
                verificaBSTRecursivo(no.direita, no.valor + 1, valorMax));
    }

    public static void main(String[] args) {
        ex2_uni3 arvore = new ex2_uni3(); // Cria uma nova árvore

        // Código para inserir elementos na árvore (omitido)

        // Verifica se a árvore é uma Árvore Binária de Busca (BST)
        boolean ehBST = arvore.verificaBST();
        
        // Exibe o resultado da verificação
        if (ehBST) {
            System.out.println("A árvore é uma Árvore Binária de Busca (BST).");
        } else {
            System.out.println("A árvore não é uma Árvore Binária de Busca (BST).");
        }
    }
}
