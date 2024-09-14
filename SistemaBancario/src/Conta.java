public abstract class Conta {
    protected String titular;
    protected double saldo;

    public Conta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito de R$" + valor + " foi realidado com sucesso na conta de " + titular);
        } else {
            System.out.println("valor do depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor >0 && valor<= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + "foi realidado com sucesso da conta de " + titular);
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido.");
        }
    }

    public void transferir(double valor, Conta contadestino) {
        if (valor >0 && valor<= saldo) {
            this.sacar(valor);
            contadestino.depositar(valor);
            System.out.println("Transferência de R$ " + valor + " realizada da conta " + titular + " para a conta de " + contadestino.getTitular());
        } else {
            System.out.println("Transferência não realizada. Saldo insuficiente ou valor inválido.");
        }
    }

    public abstract void aplicartaxas();
}
