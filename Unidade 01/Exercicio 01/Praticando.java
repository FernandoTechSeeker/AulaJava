import java.util.Scanner;

public class Praticando {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);  // Cria o scanner para ler dados do usuário

        // Declarando as variáveis
        String nome;
        int idade;

        // Capturando o nome do usuário
        System.out.print("Qual é o seu nome? ");
        nome = scanner.nextLine();  // Lê o nome digitado

        // Capturando a idade do usuário
        System.out.print("Quantos anos você tem? ");
        idade = Integer.parseInt(scanner.nextLine());  // Lê a idade e converte de String para int

        // Exibindo os valores lidos
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}
