package Aula7;

class Pato implements Animal, Voador, Nadador{

    @Override
    public void nadar() {
        System.out.println("Pato nadando na lagoa");
    }

    @Override
    public void voar() {
        System.out.println("Pato voando pra longe");
    }

    @Override
    public void fazerBarulho() {
        System.out.println("Pato fazendo barulho: Quenk quenckk");
    }
    
}
