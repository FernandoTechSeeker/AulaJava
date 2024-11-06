package Aula9;

public class Banco {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente("001", "123-4", 100);
        ContaPoupanca contaPoupanca = new ContaPoupanca("002", "345-6", 1500.57);
        ContaInvestimento contaInvestimento = new ContaInvestimento("003", "123-4", 10000.00);

        System.out.println("Conta Corrente");
        contaCorrente.consultarSaldo();
        contaCorrente.consultarLimite();

        contaCorrente.depositar(200.50);
        contaCorrente.sacar(100);
        contaCorrente.ExecutarTaxa();
        contaCorrente.consultarSaldo();

        System.out.println();
        System.out.println("------------------------------------------------------");

        System.out.println();
        System.out.println("Conta Poupança");
        contaPoupanca.consultarSaldo();
        contaPoupanca.depositar(120.50);
        contaPoupanca.sacar(1000d);
        contaPoupanca.aplicarJurosMensal();

        System.out.println();
        System.out.println("Conta Investimento");
        contaInvestimento.consultarSaldo();
        contaInvestimento.consultarSaldoInvestido();
        contaInvestimento.Investir(1000);
        contaInvestimento.consultarSaldo();
        contaInvestimento.consultarSaldoInvestido();
        contaInvestimento.Resgatar(100);

        contaInvestimento.aplicarJurosMensal();

    }
    
}
