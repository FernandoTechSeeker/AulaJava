package Projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Projeto.Pizza.TamanhoPizza;

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
            System.out.println("5 - Gerar lista de clientes");
            System.out.println("9 - Sair");

            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcao) {
                case 1:
                    fazerPedido(scanner, listaPedidos, listaClientes);
                    break;
                case 2:
                    alterarPedido(scanner, listaPedidos, listaClientes);
                    break;
                case 3:
                    listaClientes.add(adicionarCliente(scanner)); 
                    System.out.println("Cliente adicionado com sucesso!");
                    break;
                case 4:
                    gerarRelatorio(listaPedidos);
                    System.out.println("Relatório do dia: ");
                    break;
                case 5:
                    gerarListaClientes(listaClientes);
                    System.out.println("Clientes cadrastrados: ");
                    break;
                case 9:
                    System.out.println("Até amanhã...");
                    continuar = false;
                    scanner.close();
                    break;
                default:
                    break;
            }
        }
    }

    // Método para fazer um novo pedido
    private static void fazerPedido(Scanner scanner, List<Pedido> listaPedidos, List<Cliente> listaClientes) {
        List<Pizza> pizzas = new ArrayList<>();
        System.out.println("FAZER PEDIDO");

        int x = 1;
        System.out.println("Selecione um cliente: ");
        for (Cliente cliente : listaClientes) {
            System.out.println(x + " - " + cliente.getNome());
            x++;
        }
        System.out.print("Opção: ");
        int clienteIndex = scanner.nextInt();
        scanner.nextLine();

        boolean continuar = true;
        while (continuar) {
            x = 1;
            System.out.println("Qual o tamanho da pizza? ");
            System.out.println("Selecione um tamanho: ");
            for (TamanhoPizza tamanhos : Pizza.TamanhoPizza.values()) {
                System.out.println(x + " - " + tamanhos);
                x++;
            }
            System.out.print("Opção: ");
            int tamanho = scanner.nextInt();
            scanner.nextLine();

            int quantiSabores = 0;
            while (quantiSabores < 1 || quantiSabores > 4) {
                System.out.println("Digite a quantidade de sabores: 1 - 4 ");
                System.out.print("Opção: ");
                quantiSabores = scanner.nextInt();
                scanner.nextLine();
            }

            Cardapio cardapio = new Cardapio();
            List<String> saboresList = new ArrayList<>();
            List<String> saboresSelect = new ArrayList<>();

            for (int i = 0; i < quantiSabores; i++) {
                System.out.println("Selecione um sabor: ");
                x = 1;
                for (String sabor : cardapio.getCardapio().keySet()) {
                    saboresList.add(sabor);
                    System.out.println(x + " - " + sabor);
                    x++;
                }
                System.out.print("Opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();
                saboresSelect.add(saboresList.get(opcao - 1));
            }

            Pizza pizza = new Pizza(saboresSelect, cardapio.getPrecoJusto(saboresSelect), TamanhoPizza.getByIndex(tamanho - 1));
            pizzas.add(pizza);

            System.out.println("Pizza cadastrada com sucesso!");
            System.out.println();
            System.out.println("Deseja cadastrar mais uma pizza no pedido?");
            System.out.print("1 - Sim, 2 - Não: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao != 1) {
                continuar = false;
            }
        }

        double valorTotal = somarPizzas(pizzas) + calcularFrete(listaClientes.get(clienteIndex - 1));
        Pedido pedido = new Pedido(listaPedidos.size() + 1, listaClientes.get(clienteIndex - 1), pizzas, valorTotal);
        listaPedidos.add(pedido);
        System.out.println("Pedido realizado com sucesso! Valor total com frete: R$ " + valorTotal);
    }

    // Método para somar o preço total das pizzas
    private static double somarPizzas(List<Pizza> pizzas) {
        double valorTotal = 0;
        for (Pizza pizza : pizzas) {
            valorTotal += pizza.getPreco();
        }
        return valorTotal;
    }

    // Método para calcular o frete com base na localização (simulação simples)
    private static double calcularFrete(Cliente cliente) {
        String endereco = cliente.getEndereco();
        if (endereco.toLowerCase().contains("bairro 1")) {
            return 5.00;  // Exemplo de frete para uma área específica
        } else {
            return 8.50;  // Frete padrão para outras áreas
        }
    }

    // Método para alterar um pedido
    private static void alterarPedido(Scanner scanner, List<Pedido> listaPedidos, List<Cliente> listaClientes) {
        System.out.println("ALTERAR PEDIDO");

        System.out.print("Digite o ID do pedido ou nome do cliente: ");
        String input = scanner.nextLine();
        Pedido pedidoEncontrado = null;

        try {
            int id = Integer.parseInt(input);
            for (Pedido pedido : listaPedidos) {
                if (pedido.getId() == id) {
                    pedidoEncontrado = pedido;
                    break;
                }
            }
        } catch (NumberFormatException e) {
            for (Cliente cliente : listaClientes) {
                if (cliente.getNome().equalsIgnoreCase(input)) {
                    for (Pedido pedido : listaPedidos) {
                        if (pedido.getCliente().equals(cliente)) {
                            pedidoEncontrado = pedido;
                            break;
                        }
                    }
                }
            }
        }

        if (pedidoEncontrado == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        // Menu para alterar pizzas no pedido
        boolean continuar = true;
        while (continuar) {
            System.out.println("1 - Adicionar Pizza");
            System.out.println("2 - Remover Pizza");
            System.out.println("3 - Alterar Sabor de Pizza");
            System.out.println("4 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    fazerPedido(scanner, listaPedidos, listaClientes);
                    break;
                case 2:
                    removerPizzaDoPedido(scanner, pedidoEncontrado);
                    break;
                case 3:
                    alterarSaborDaPizza(scanner, pedidoEncontrado);
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // Método para remover pizza de um pedido
    private static void removerPizzaDoPedido(Scanner scanner, Pedido pedido) {
        System.out.println("Escolha a pizza para remover:");
        List<Pizza> pizzas = pedido.getPizzas();
        for (int i = 0; i < pizzas.size(); i++) {
            System.out.println((i + 1) + " - " + pizzas.get(i).getSabores());
        }
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao > 0 && opcao <= pizzas.size()) {
            pizzas.remove(opcao - 1);
            System.out.println("Pizza removida.");
        } else {
            System.out.println("Opção inválida.");
        }
    }

    // Método para alterar o sabor de uma pizza
    private static void alterarSaborDaPizza(Scanner scanner, Pedido pedido) {
        System.out.println("Escolha a pizza para alterar:");
        List<Pizza> pizzas = pedido.getPizzas();
        for (int i = 0; i < pizzas.size(); i++) {
            System.out.println((i + 1) + " - " + pizzas.get(i).getSabores());
        }
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao > 0 && opcao <= pizzas.size()) {
            Pizza pizza = pizzas.get(opcao - 1);
            List<String> novosSabores = new ArrayList<>();

            System.out.println("Quantos sabores quer adicionar?");
            int quantidadeSabores = scanner.nextInt();
            scanner.nextLine();
            Cardapio cardapio = new Cardapio();

            for (int i = 0; i < quantidadeSabores; i++) {
                System.out.println("Selecione o sabor:");
                int x = 1;
                for (String sabor : cardapio.getCardapio().keySet()) {
                    System.out.println(x + " - " + sabor);
                    x++;
                }
                int saborEscolhido = scanner.nextInt();
                scanner.nextLine();
                novosSabores.add(cardapio.getCardapio().keySet().toArray(new String[0])[saborEscolhido - 1]);
            }
            pizza.setSabores(novosSabores);
            System.out.println("Sabor alterado com sucesso.");
        } else {
            System.out.println("Opção inválida.");
        }
    }

    // Método para gerar relatório de vendas
    private static void gerarRelatorio(List<Pedido> listaPedidos) {
        System.out.println("RELATÓRIO DE VENDAS:");
        for (Pedido pedido : listaPedidos) {
            System.out.println("Pedido ID: " + pedido.getId() + " - Cliente: " + pedido.getCliente().getNome() + " - Total: R$ " + pedido.getValorTotal());
        }
    }

    // Método para gerar lista de clientes
    private static void gerarListaClientes(List<Cliente> listaClientes) {
        System.out.println("LISTA DE CLIENTES:");
        for (Cliente cliente : listaClientes) {
            System.out.println("Cliente: " + cliente.getNome() + " - Endereço: " + cliente.getEndereco());
        }
    }

    // Método para adicionar cliente
    private static Cliente adicionarCliente(Scanner scanner) {
        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();
        System.out.println("Digite seu número de telefone");
        String telefone = scanner.nextLine();
        return new Cliente(nome, endereco, telefone);
    }
}
