package Aula2;

class Retangulo extends FiguraGeometrica{
    private double comprimento;
    private double largura;

    public Retangulo(double comprimento, double largura){
        this.comprimento = comprimento;
        this.largura = largura;
    }

    public double getComprimento() {
        return comprimento;
    }
    public double getLargura() {
        return largura;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }
    public void setLargura(double largura) {
        this.largura = largura;
    }

    @Override // sobre escrita @override
    public double calcularArea() {
        return comprimento * largura;
    }

    @Override
    public double calculaPerimetro() {       
        return 2 * (comprimento + largura);
    }
}