package Projeto.Projeto.Projeto;

import java.util.List;

import Projeto.Cliente;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Pizza> pizzas;
    private double valorTotal;


    public Pedido( int id, Cliente cliente, List<Pizza> pizzas, double valorTotal){
        this.id = id;
        this.cliente = cliente;
        this.pizzas = pizzas;
        this.valorTotal = valorTotal;
    }
}