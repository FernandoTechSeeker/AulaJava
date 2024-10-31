package Aula1;

public class Exemplo{

    public static void main(String[] args) {
        
        Carro carro = new Carro("Toyota", "Corolla", 4);  
        Moto moto = new Moto("Honda", "CBR", 600);

        carro.setModelo("null");
        carro.setPortas(2);

        moto.setModelo("");
        moto.setCilindradas(150);

        System.out.println("Carro: ");
        System.out.println("Marca:"+carro.getMarca());
        System.out.println("Modelo: "+carro.getModelo());
        System.out.println("Num Portas: "+carro.getPortas());

        System.out.println("Moto: ");
        System.out.println("Marca:"+moto.getMarca());
        System.out.println("Modelo: "+moto.getModelo());
        System.out.println("Cilindradas: "+moto.getCilindradas());


    }
}
