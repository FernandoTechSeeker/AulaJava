package ProgramaçãoOO;

public class Principal {
    
    public static void main(String[] args) {
        Carro carro = new Carro("BMW", "320I", 2024, "Cinza");
        Carro carro2 = new Carro("Volkwagem", "Jetta", 0, null);

        carro2.setCor("Vermelho");

        System.out.println("Marca:  " + carro.getMarca());
        System.out.println("Modelo: " + carro.getModelo());
        System.out.println("Ano:    " + carro.getAno());
        System.out.println("Cor:    " + carro.getCor());
        
        System.out.println("Marca:  " + carro2.getMarca());
        System.out.println("Modelo: " + carro2.getModelo());
        System.out.println("Ano:    " + carro2.getAno());
        System.out.println("Cor:    " + carro2.getCor());


        System.out.println("cor:   " + carro.cor);
        //formas dea alterar a info pq esta publica
        carro.cor = "Azul";
        carro.setCor("Azul");

        //foram correta
        carro.setModelo("420I");
       

    }
}
