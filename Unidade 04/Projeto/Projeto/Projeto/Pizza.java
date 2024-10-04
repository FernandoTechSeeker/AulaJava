package Projeto.Projeto.Projeto;

import java.util.List;

// montando a pizza
public class Pizza {
    private List<String> sabores;
    private double preco;
    private TamanhoPizza tamanho; // so lembrando que tudo que é privado so ve dentro da classe 

    // enum fazer a tipação dos dados
    public enum TamanhoPizza{ // o enum é tudo maisculo // vai deixar publico pra vizualar podendo colocar no private

        BROTO,
        GRANDE, 
        GIGA;
        // foi criando uma lista pro enum pra achar pelo indice 
        public static TamanhoPizza getByIndex(int index) throws IllegalAccessException{ // corrigiu
            TamanhoPizza[] tamanhos = TamanhoPizza.values();
            if (index >= 0 && index < tamanhos.length){
                return tamanhos[index];
            }else{
                throw new IllegalAccessException("Posição incorreta do index"); // correção do programa diferente da aula
                
                
            }
        }

    }

    public Pizza(List<String> sabores, double preco, TamanhoPizza tamanho){
        this.sabores = sabores;
        this.preco = preco;
        this.tamanho = tamanho;
    }

    public List<String> getSabores(){
        return sabores;
    }
    public Double getPreco(){
        return preco;
    }
    public TamanhoPizza getTamanho(){
        return tamanho;
    }

    public void setSabores(List<String> sabores){
        this.sabores = sabores;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public void setTamanho(TamanhoPizza tamanho){
        this.tamanho = tamanho;
    }


}
