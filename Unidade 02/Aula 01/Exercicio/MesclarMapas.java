import java.util.HashMap;

public class MesclarMapas {

    public static void main(String[] args) {
        // Criando dois mapas (HashMaps)
        HashMap<String, Integer> mapa1 = new HashMap<>();
        HashMap<String, Integer> mapa2 = new HashMap<>();

        // Adicionando elementos ao mapa1
        mapa1.put("A", 5);  // (colocar)
        mapa1.put("B", 7);
        mapa1.put("C", 3);

        // Adicionando elementos ao mapa2
        mapa2.put("B", 2); // (colocar)
        mapa2.put("C", 4);
        mapa2.put("D", 6);

        // Mesclando os mapas
        HashMap<String, Integer> mapaMesclado = mesclarMapas(mapa1, mapa2);

        // Exibindo o mapa mesclado
        System.out.println(mapaMesclado);
    }

    public static HashMap<String, Integer> mesclarMapas(HashMap<String, Integer> mapa1, HashMap<String, Integer> mapa2) {
        // Criando um novo mapa para armazenar os resultados
        HashMap<String, Integer> mapaResultado = new HashMap<>(mapa1); // Copiando mapa1

        // Iterando sobre o mapa2 para mesclar
        for (String chave : mapa2.keySet()) { // (conjunto de chaves)
            mapaResultado.put(chave, mapaResultado.getOrDefault(chave, 0) + mapa2.get(chave)); // (pegar ou padrão)
        }

        return mapaResultado; // Retorna o mapa mesclado
    }
}
