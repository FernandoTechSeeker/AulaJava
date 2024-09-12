import java.util.HashMap;
import java.util.Map;

public class ExemplosMapa {

    public static void main(String[] args) {
        
        Map<String,Integer> mapa = new HashMap<>();
        // adiciona no mapa a chave e  o valor (K,V)
        mapa.put("Fernando", 55);
        mapa.put("Alice", 30);
        mapa.put("João", 56);
        mapa.put("Leo", 30);

        System.out.println(mapa);
         
        // retorna o valor da chave passada
        System.out.println(mapa.get("Fernando"));

        // substituo o valor da chave passada, senão encontrar nada acontece 
        mapa.replace("João", 105);
        System.out.println(mapa);

        //Adiconar se a Key não exitir 
        mapa.putIfAbsent("Joana", 65);
        System.out.println(mapa);

        mapa.remove("Alice");
        System.out.println(mapa);
        // busca no mapa pelo a KEY
        if (mapa.containsKey("Fernando")){
            System.out.println("Existe a chave passasda: ");
        }else{
            System.out.println("Não existe chave passada: ");
        }
        // busca o mapa pelo valor
        if (mapa.containsValue(105)){
            System.out.println("Existe a chave passasda: ");
        }else{
            System.out.println("Não existe chave passada: ");
        }
       // retorna true ou false em relação aomapa
        if(mapa.isEmpty());{
            System.out.println(" O mapa esta vazio");

        }
        // laço para verificar todo o mapa
        for (String nome : mapa.keySet()){
            System.out.println(nome);
        }
        // exibe o tamanho do mapa
        int tamanho = mapa.size();
        System.out.println("O tamanho do mapa é: "+ tamanho);




    }


}

