package Aula9;

public class ContaCorrente extends ContaBancaria {
    private static final double TAXA_MANUTENCAO = 15.0;
    private static final double LIMITE_TOTAL = 1000.0;
    private double limite;

    public ContaCorrente(String nagencia, String nconta, double saldo){
        super(nagencia, nconta, saldo);
    }

    @Override
    public void sacar(double valor) {
       double saldoAtual = saldo;
       if (valor <= saldoAtual + limite) {
            if(valor <= saldoAtual){
                saldo -= valor;
                System.out.println("Valor sacado: R$"+valor);

            }else{
                limite -=(valor - saldoAtual);
                saldo -= saldoAtual;
                System.out.println("Valor sacado: R$"+valor);
            }
        
       }else{
        System.out.println("Saldo + limite insuficiente para a operação!");
        System.out.println("Saldo: R$"+saldoAtual+" Limite disponivel: R$" +limite);
       }
        
    }
    
    public void consultarLimite(){
        System.out.println("Seu limite atual é de: R$"+limite);
    }

    public void ExecutarTaxa(){
        saldo -= TAXA_MANUTENCAO;
        System.out.println("Taxa de manutenção executada! ");
       
    }

    
}
