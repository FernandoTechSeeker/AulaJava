public class ExemplosDadosNPrimitivo {
    public static void main(String [] args){
        // tipo caracteres Não PRIMITIVO
        String nome = "Fernando";
        nome = "Fernando Canto";


        // tipo Enum
        enum DiaDaSemana{
            DOMINGO, SEGUNDA, TERÇA, QUARTA, QUINTA, SEXTA, SÁBADO
        }


        // tipo array
        int [] numeros = {1,2,3,4,5}; // começa sempre em 0,1,2,3,4


        DiaDaSemana dia = DiaDaSemana.SÁBADO;
        System.out.println(nome);
        System.out.println(dia);
        System.out.println(numeros [0]);
    }


}

