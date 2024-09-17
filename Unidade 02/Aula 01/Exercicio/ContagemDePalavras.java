import java.util.HashMap;

public class ContagemDePalavras {

    public static void main(String[] args) {
        String frase = "programar é divertido porque programar me faz pensar";
        
        // Contagem das palavras
        HashMap<String, Integer> contagemPalavras = contarPalavras(frase);

        // Exibindo o resultado
        System.out.println(contagemPalavras);
    }

    public static HashMap<String, Integer> contarPalavras(String frase) {
        HashMap<String, Integer> mapa = new HashMap<>();
        String[] palavras = frase.split(" "); // Divide a frase em palavras

        // Contando a frequência de cada palavra
        for (String palavra : palavras) {
            mapa.put(palavra, mapa.getOrDefault(palavra, 0) + 1); // Incrementa a contagem
        }

        return mapa;
    }
}
