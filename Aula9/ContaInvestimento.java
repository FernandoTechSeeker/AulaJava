package Aula9;

public class ContaInvestimento extends ContaBancaria{
    private static final double TAXA_ADMINSTRACAO = 20.0;
    private static final double TAXA_JUROS_MENSAL = 0.012;
    private double saldoInvestido;

    public ContaInvestimento( String nagencia, String nconta, double saldo){
        super(nagencia, nconta, saldo);
        this.saldoInvestido =0.0;
    }

    public void Investir(double valor){
        if (valor <= getSaldo()) {   
            setSaldo(getSaldo() - valor); 
            double valorInvestido = valor - TAXA_ADMINSTRACAO;
            saldoInvestido  += valorInvestido;
            System.out.println("Investimento de R$"+valorInvestido+ " realizado");
            System.out.println("Saldo investido atualizado: R$"+saldoInvestido);
        }else{
            System.out.println("Saldo insuficiente para a operação! Tente outro valor");
        }
    
    }

    public void Resgatar(double valor){
        if (valor <= saldoInvestido) {
            saldoInvestido -= valor;
            setSaldo(getSaldo()+ valor); 
            System.out.println("Saldo investido atualizado: R$"+saldoInvestido);
            super.consultarSaldo();     
        }else{
            System.out.println("Saldo insuficiente para a operação! Tente outro valor");
        }
    }
    
    public double consultarSaldoInvestido(){
        System.out.println("Saldo investido: R$"+saldoInvestido);
        return saldoInvestido;
    }

    public void aplicarJurosMensal(){
        saldoInvestido += saldoInvestido * TAXA_JUROS_MENSAL;
        System.out.println("Saldo investido atualizado R$"+saldoInvestido);
    }

}