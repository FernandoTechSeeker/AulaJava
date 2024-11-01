package Aula9;

public class ContaPoupanca extends ContaBancaria {
    private static final double JUROS_POUPANCA =0.06;

    public ContaPoupanca(String nagencia, String nconta, double saldo){
        super(nagencia, nconta, saldo);
    }

    @Override
    public double consultarSaldo() {
       double saldoAtual = saldo;
       System.out.println("Saldo atual: R$"+saldoAtual);
       System.out.println("Redendo a: "+JUROS_POUPANCA+100+"% ao ano");
       return saldoAtual;

    }

    public void aplicarJurosMensal(){
        double jurosMensal = JUROS_POUPANCA/12;
        double juros = saldo * jurosMensal;
        saldo += juros;
        super.consultarSaldo();
        
    }
    
}
