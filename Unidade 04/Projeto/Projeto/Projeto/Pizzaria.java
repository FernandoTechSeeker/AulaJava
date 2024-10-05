package Projeto.Projeto.Projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Projeto.Cliente;
import Projeto.Projeto.Projeto.Pizza.TamanhoPizza;

public class Pizzaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> listaClientes = new ArrayList<>();
        List<Pedido> listaPedidos = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {
            System.out.println();
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Fazer um novo pedido");
            System.out.println("2 - Alterar um pedido");
            System.out.println("3 - Adicionar um cliente");
            System.out.println("4 - Gerar relatório de vendas");
            System.out.println("5 - Gerar Lista de clientes");
            System.out.println("9 - Sair");

            // dando a opção pro usuario 
            System.out.println("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            // ele espera uma resposta 
            switch (opcao) {
                case 1:
                    fazerPedido(scanner, listaPedidos, listaClientes);
                    System.out.println();
                    break;
                case 2:
                    alterarPedido();
                    break;
                case 3:
                listaClientes.add(adicionarCliente(scanner)); 
                System.out.println("Cliente adicionado com sucesso: "); 
                System.out.println();                 
                    break;
                case 4:
                    gerarRelatorio();
                    break;
                case 5:
                    gerarListaClientes(listaClientes);
                    break;
                case 9:
                    System.out.println("Até mais...");
                    continuar = false;
                    scanner.close();
                    
                    break;
                default:
                    break;
            }


        }


    }

   private static void fazerPedido(Scanner scanner, List<Pedido> listaPedidos, List<Cliente> listaClientes) {
        List<Pizza> pizzas = new ArrayList<>();
        System.out.println("FAZER PEDIDO: ");

        int x = 1;
        System.out.println("Selecione um cliente: ");
        for (Cliente cliente : listaClientes) {
            System.out.println(x+"  "+cliente.getNome());
            x++;
        }
        System.out.println("Opção: ");
        int cliente = scanner.nextInt();
        scanner.nextLine();

        
        x = 1;
        System.out.println("Qual o tamanho da pizzas? ");
        System.out.println("Selecione um tamanho: ");
        for (TamanhoPizza  tamanhos : Pizza.TamanhoPizza.values()) {
        
            System.out.println(x+" - "+tamanhos);
            x++;
            
        }
        System.out.println("Opção: ");
        int tamanho = scanner.nextInt();
        scanner.nextLine();

        int quantidadeSabores = 0;
        while (quantidadeSabores < 1 || quantidadeSabores > 4){
            System.out.println("Digite a quantidade de sabores: 1 - 4 ");
            quantidadeSabores = scanner.nextInt();
            scanner.nextLine();

        }
        // chamando o cardapio
        Cardapio cardapio = new Cardapio();
        List<String> saboresList = new ArrayList();
        List<String> saboresSelect = new ArrayList();

        for (int i = 0; i < quantidadeSabores; i++) {
            System.out.println("Selecione um sabor");
           
            x = 1;
            for (String  sabor: cardapio.getCardapio().keySet()) {
                saboresList.add(sabor);
                System.out.println(x+" - "+sabor);
                x++;
            }
            System.out.println("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            saboresSelect.add(saboresList.get(opcao-1));

            
        }

        try { // monstagem de uma pizza, vamos fazer mais um loop caso o cliente queira mais.
            Pizza pizza = new Pizza(saboresSelect, cardapio.getPrecoJusto(saboresSelect), TamanhoPizza.getByIndex(tamanho-1));
            pizzas.add(pizza);
            
            Pedido pedido = new Pedido(listaPedidos.size()+1, listaClientes.get(cliente-1), pizzas, somarPizza(pizzas));
            listaPedidos.add(pedido);

        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private static double somarPizza(List<Pizza> pizzas) {
        double valorTotal = 0;
        for (Pizza pizza : pizzas) {
            valorTotal += pizza.getPreco();
            
        }
    return valorTotal;
}

    private static void alterarPedido() {
        System.out.println("Alterar pedido: ");
    }

    private static Cliente adicionarCliente(Scanner scanner) {
        System.out.println("ADICIONAR CLIENTE: ");
        System.out.println();
        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println();
        System.out.println("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();
        System.out.println();
        System.out.println("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.println();
        System.out.println("Digite o email do cliente: ");
        String email = scanner.nextLine();
        System.out.println();

        Cliente cliente = new Cliente(nome, endereco, telefone, email);
        return cliente;
    }
    
    private static void gerarRelatorio() {
        System.out.println("Gerar relatório: ");
     }
     private static void gerarListaClientes(List<Cliente> listaClientes) {
        int x = 1;
        if (listaClientes.isEmpty()){
            System.out.println("Lista de clientes esta vazia: ");
            System.out.println();

        }else{
            for (Cliente cliente : listaClientes) {
            System.out.println("Cliente "+x);
            System.out.println(cliente.getNome());
            System.out.println(cliente.getEndereco());
            System.out.println(cliente.getTelefone());
            System.out.println(cliente.getEmail());
            System.out.println();
            x++;
            }
        
        }

    
    }
}