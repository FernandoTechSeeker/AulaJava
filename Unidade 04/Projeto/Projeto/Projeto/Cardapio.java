package Projeto.Projeto.Projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//construto
public class Cardapio {
    private Map<String, Double> cardapio;
    // usando a estrura Hashmap pra armazenar
    public Cardapio(){
        this.cardapio = new HashMap<>();
        inicializarCardapio();

    }
    //put inserindo 
    private void inicializarCardapio(){
        cardapio.put("Margarita", 30.00);
        cardapio.put("Pepperoni", 35.00);
        cardapio.put("Quatro queijo", 37.00);
        cardapio.put("Calabrasa", 33.00);
        cardapio.put("Frango com Catupiry", 36.50);
        cardapio.put("Portuguesa", 33.40);
        cardapio.put("Mussarela", 28.00);
        cardapio.put("Atum", 38.70);
        cardapio.put("Vegetariana", 34.30);
        cardapio.put("Especial da Casa", 42.20);
        
 

    }
    // montando uma devolotiva do hasmap Usando o GET
    public Map<String, Double> getCardapio(){ // já pode ir pra pizzaria e buscar o cardapio
        return cardapio;

    }

    // construtor do preço justo
    public double getPrecoJusto(List<String> sabores){ // todas as informaçoes da lista vão estar aqui
        List<String> saboresEncontrados = new ArrayList<>(); // montando variaveis, garantindo que as iinformações vão estar em cima
        double precoTotal = 0.0;
        int totalSabores = 0;

        for (String sabor : sabores) {
            if (cardapio.containsKey(sabor)){ // vendo se contem o sabor
                saboresEncontrados.add(sabor);
                totalSabores++; // somando mais um

            }else{
                System.out.println("Pizza" +sabor+ "não encontrado!");
            }
            
        }

        for (String  sabor : saboresEncontrados) {
            precoTotal += cardapio.get(sabor)/totalSabores; // pegando o valor da pizza e divindo por dois
            
        }// aqui em cima já consegue chamar esse metodo na pizzaria

        return precoTotal;

    }



}
 