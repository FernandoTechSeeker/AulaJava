package Aula3;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroAlunos {
    
    private ArrayList<Aluno> alunos;

    public CadastroAlunos(){
        alunos = new ArrayList<>();
    }

    public void cadastrarAluno(Aluno aluno){
        alunos.add(aluno);
    }

    public void mostrarAlunos(){
        for (Aluno aluno : alunos) {
            System.out.println("Nome:  "+ aluno.getNome());
            System.out.println("Idade: "+ aluno.getIdade());
            System.out.println("Curso: "+ aluno.getCurso());
            System.out.println(" ");
            
        }
    }
    
    public static void main(String[] args) {
        CadastroAlunos cadastro = new CadastroAlunos();

        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;
        while (continuar){
            System.out.println("Escolha uma opção abaixo: ");
            System.out.println("1 - Cadastrare Aluno ");
            System.out.println("2 - Mostrar alunos cadastrados ");
            System.out.println("3 - Sair ");

            int opção = scanner.nextInt();
            scanner.nextLine();

            switch (opção) {
                case 1:
                    System.out.println("Infome o nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.println("Infome a idade do aluno: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Infome o curso do aluno: ");
                    String Curso = scanner.nextLine();
                    cadastro.cadastrarAluno(new Aluno(nome, idade, Curso));
                    System.out.println("Aluno cadastrado com sucesso! ");

                    
                    break;
                case 2:
                    System.out.println("Alunos Cadastrados: ");
                    cadastro.mostrarAlunos();
                    
                    break;
                case 3:
                    continuar = false;
                    break;
            
                default:
                    System.out.println("Opção invalida, tente novamente!");
                    break;
            }
        }
        
        scanner.close();
        System.out.println("Programa Encerrado!");
    }

}
