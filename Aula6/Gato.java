package Aula6;

class Gato implements Animal{

    @Override
    public void fazerBarulho() {
       System.out.println("Gato fazendo barulho: Miau");
    }

    @Override
    public void comer() {
      System.out.println("Gato comendo peixe: ");
    }
    
}
