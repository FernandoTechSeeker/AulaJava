import java.util.Scanner;

//Exercício 2: Estruturas Condicionais
//Escreva um programa que leia um número e determine se ele é par ou ímpar. Imprima o resultado na tela.

    public class Exer02 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            System.out.print("Digite um número inteiro: ");
            int numero = scanner.nextInt();
    
            if (numero % 2 == 0) {
                System.out.println(numero + " é um número par.");
            } else {
                System.out.println(numero + " é um número ímpar.");
            }
    
            scanner.close();
        }
    }
    

