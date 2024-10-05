package Projeto;

import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Pizza> pizzas;
    private double valorTotal;

    // Construtor
    public Pedido(int id, Cliente cliente, List<Pizza> pizzas, double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.pizzas = pizzas;
        this.valorTotal = valorTotal;
    }

    // Getters
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    // Setter para alterar a lista de pizzas, se necessário
    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
