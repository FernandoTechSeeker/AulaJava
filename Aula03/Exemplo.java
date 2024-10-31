package Aula03;

public class Exemplo {
    
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Nando", 5000, "Financeiro");
        Analista analista = new Analista("João", 3000, "Engenharia");

        System.out.println("Bonus do Gerente "+ gerente.getNome()+ ": "+gerente.calcularBonus());
        System.out.println("Departamento do gerente "+ gerente.getNome()+ " :" + gerente.getDepartamento());

        System.out.println("Bonus do Analista "+ analista.getNome()+ ": "+analista.calcularBonus());
        System.out.println("Projeto do analista "+ analista.getNome()+ ": "+analista.getProjeto());
    }
}
