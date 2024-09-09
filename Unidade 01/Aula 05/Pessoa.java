import java.util.Scanner;

public class Pessoa {
    //Atributos
    private String nome;
    private int idade; 
    private float peso;
    
    //Construtor
    public Pessoa(String nome, int idade, float peso){
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;

    }
     //Metódos pode construir quantos quiser
     public void exibirInfos(){
        System.out.println("Nome: "+ nome);
        System.out.println("Idade: "+ idade);
        System.out.println("Nome: "+ peso);
     }

     //Gets sets
     public String getNome(){
        return this.nome;

     }
     public void setNome(String nome){
        this.nome = nome;

     }

     public int getIdade(){
        return this.idade;

     }
     public void setIdade(int idade){
        this.idade = idade;

     }

     public float getPeso(){
        return this.peso;

     }
     public void setPeso(float peso){
        this.peso = peso;

     }

     public void aniversario(){
        this.idade = this.idade +1;
        // this.idade += 1;
     }
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
      
        Pessoa pessoa = new Pessoa("Nando", 35, 84.4f);

        pessoa.exibirInfos();
        pessoa.aniversario();
        pessoa.exibirInfos();
        
        pessoa.setNome("Fernando");
        pessoa.setPeso(94.4f);
        pessoa.exibirInfos();

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite sua idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("Digite seu peso: ");
        float peso = Float.parseFloat(scanner.nextLine());

        Pessoa pessoa2 = new Pessoa(nome, idade, peso);
        
        pessoa2.exibirInfos();
    }
    
}
