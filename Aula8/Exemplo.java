package Aula8;

public class Exemplo {
    public static void main(String[] args) {
        Passaro passaro = new Passaro("Tucano");
        Cachorro cachorro = new Cachorro("Lupito");

        passaro.fazerBarulho();
        passaro.voar();

        cachorro.fazerBarulho();
        
    }
}
