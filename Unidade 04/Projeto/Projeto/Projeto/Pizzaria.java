package Projeto.Projeto.Projeto;

import Projeto.Cliente;

public class Pizzaria {
    
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Fernando", "José Simões 608", "8399715-5279","fcanto08@gmail.com");
        
        System.out.println(cliente.getNome());
    }
}
