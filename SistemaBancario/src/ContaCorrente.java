public class ContaCorrente extends Conta {
    private double taxaMensal;

    public ContaCorrente(String titular, double saldo, double taxaMensal) {
        super(titular, saldo);
        this.taxaMensal = taxaMensal;
    }

    @Override
    public void aplicartaxas() {
        saldo -= taxaMensal;
        System.out.println("taxa mensal de R$ " + taxaMensal + " foi aplicada a conta corrente de " + titular);
    }
}
