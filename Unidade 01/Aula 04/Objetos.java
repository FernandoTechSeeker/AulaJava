public class Objetos {
    //Atributos
    private String nome;
    private static int idade;
    private float peso;

    //Construtor
    public Objetos(String nome, int idade, float peso){
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;

    }
     //Metódos
     public void exibirInfos(){
        System.out.println("Nome: "+ nome);
        System.out.println("Idade: "+ idade);
        System.out.println("Nome: "+ peso);
     }

    public static void main(String[] args){
        Objetos pessoa = new Objetos("Leornado", 26, 92.6f);
        Objetos pessoa2 = new Objetos("Fernando", 35, 84.6f);
        

        pessoa.exibirInfos();
        pessoa2.exibirInfos();


    }
}
