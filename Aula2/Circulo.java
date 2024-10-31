package Aula2;

 class Circulo extends FiguraGeometrica{
    private double raio; 

    public Circulo(double raio){
        this.raio = raio;

    }
    public double getRaio() {
        return raio;
    }
    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularArea() {    
        return Math.PI * raio * raio;
    }
    @Override
    public double calculaPerimetro() {   
        return 2 * Math.PI * raio;

    }
    
 }
