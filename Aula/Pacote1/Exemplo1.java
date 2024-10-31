package Aula.Pacote1;

import Aula.Pacote2.Carro;

public class Exemplo1 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        Produto produto = new Produto();
        Carro carro = new Carro();

        pessoa.setNome("Fernando");
        pessoa.setIdade(35);

        System.out.println(pessoa.nome);
        System.out.println(pessoa.idade);
        //System.out.println(pessoa.peso);
        

        produto.setNome("Macarrão");
        produto.setPreco(5.25);

        System.out.println(produto.nome);
        System.out.println(produto.preco);

        System.out.println(carro.marca);
        //System.out.println(carro.modelo);
        //System.out.println(carro.cor);
    }
    
}
