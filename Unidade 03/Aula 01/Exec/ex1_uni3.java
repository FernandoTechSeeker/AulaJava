// Classe que representa um nó de uma árvore binária
class No {
    int valor;       // Valor armazenado no nó
    No esquerda;     // Referência para o nó à esquerda
    No direita;      // Referência para o nó à direita

    // Construtor para criar um novo nó com o valor fornecido
    public No(int valor) {
        this.valor = valor;
        esquerda = null;  // Inicializa a esquerda como null
        direita = null;   // Inicializa a direita como null
    }
}

// Classe principal que contém a árvore binária e os métodos de percursos
public class ex1_uni3 {
    private No raiz;  // Nó raiz da árvore (inicialmente nulo)

    // Construtor que inicializa a árvore binária com a raiz nula
    public ex1_uni3() {
        raiz = null;  // Inicializa a raiz como null (árvore vazia)
    }

    // Método para inserir um valor na árvore binária
    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);  // Chama o método recursivo para inserir o valor
    }

    // Método recursivo que insere um novo valor na árvore binária de busca
    private No inserirRecursivo(No no, int valor) {
        // Se o nó atual é null, cria um novo nó com o valor fornecido
        if (no == null) {
            return new No(valor);
        }

        // Se o valor for menor que o valor do nó atual, insere à esquerda
        if (valor < no.valor) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } 
        // Se o valor for maior, insere à direita
        else if (valor > no.valor) {
            no.direita = inserirRecursivo(no.direita, valor);
        }

        // Retorna o nó atual após a inserção
        return no;
    }

    // Método para percorrer a árvore em Pré-Ordem (raiz, esquerda, direita)
    public void percorrerPreOrdem() {
        percorrerPreOrdemRecursivo(raiz);  // Chama o método recursivo para percorrer a árvore
        System.out.println();  // Pula uma linha após o percurso
    }

    // Método recursivo para percorrer em Pré-Ordem
    private void percorrerPreOrdemRecursivo(No no) {
        // Se o nó atual não for null, processa o nó e percorre seus filhos
        if (no != null) {
            System.out.print(no.valor + " ");  // Imprime o valor do nó atual
            percorrerPreOrdemRecursivo(no.esquerda);  // Percorre o filho à esquerda
            percorrerPreOrdemRecursivo(no.direita);   // Percorre o filho à direita
        }
    }

    // Método para percorrer a árvore em Pós-Ordem (esquerda, direita, raiz)
    public void percorrerPosOrdem() {
        percorrerPosOrdemRecursivo(raiz);  // Chama o método recursivo para percorrer a árvore
        System.out.println();  // Pula uma linha após o percurso
    }

    // Método recursivo para percorrer em Pós-Ordem
    private void percorrerPosOrdemRecursivo(No no) {
        // Se o nó atual não for null, processa os filhos e depois o nó
        if (no != null) {
            percorrerPosOrdemRecursivo(no.esquerda);  // Percorre o filho à esquerda
            percorrerPosOrdemRecursivo(no.direita);   // Percorre o filho à direita
            System.out.print(no.valor + " ");         // Imprime o valor do nó atual
        }
    }

    // Método para percorrer a árvore em Em-Ordem (esquerda, raiz, direita)
    public void percorrerEmOrdem() {
        percorrerEmOrdemRecursivo(raiz);  // Chama o método recursivo para percorrer a árvore
        System.out.println();  // Pula uma linha após o percurso
    }

    // Método recursivo para percorrer em Em-Ordem
    private void percorrerEmOrdemRecursivo(No no) {
        // Se o nó atual não for null, processa o filho à esquerda, o nó, e o filho à direita
        if (no != null) {
            percorrerEmOrdemRecursivo(no.esquerda);  // Percorre o filho à esquerda
            System.out.print(no.valor + " ");        // Imprime o valor do nó atual
            percorrerEmOrdemRecursivo(no.direita);   // Percorre o filho à direita
        }
    }

    // Método principal para executar o código e testar os percursos da árvore
    public static void main(String[] args) {
        ex1_uni3 arvore = new ex1_uni3();  // Cria uma nova árvore binária

        // Insere valores na árvore
        arvore.inserir(10);  // Inserindo o valor 10
        arvore.inserir(5);   // Inserindo o valor 5
        arvore.inserir(20);  // Inserindo o valor 20
        arvore.inserir(3);   // Inserindo o valor 3
        arvore.inserir(8);   // Inserindo o valor 8
        arvore.inserir(15);  // Inserindo o valor 15
        arvore.inserir(30);  // Inserindo o valor 30

        // Exibe o percurso em Pré-Ordem
        System.out.println("Percorrendo em Pré-Ordem:");
        arvore.percorrerPreOrdem();  // Chama o método para percorrer em Pré-Ordem

        // Exibe o percurso em Pós-Ordem
        System.out.println("Percorrendo em Pós-Ordem:");
        arvore.percorrerPosOrdem();  // Chama o método para percorrer em Pós-Ordem

        // Exibe o percurso em Em-Ordem
        System.out.println("Percorrendo em Em-Ordem:");
        arvore.percorrerEmOrdem();  // Chama o método para percorrer em Em-Ordem
    }
}
