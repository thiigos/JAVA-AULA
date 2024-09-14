public class ContaPoupanca extends Conta {
    private double taxajuros;

    public ContaPoupanca(String titular, double saldo, double taxajuros) {
        super(titular, saldo);
        this.taxajuros = taxajuros;
    }

    @Override
    public void aplicartaxas() {
        double juros = saldo * (taxajuros/100);
        saldo += juros;
        System.out.println("juros de R$" + juros + " aplicados à conta poupança " + titular);
    }
}
