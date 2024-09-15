public class Pedido {
    private double valorTotal;

    public Pedido(double valorTotal){
        this.valorTotal = valorTotal;
    }

    public void processarPagamento(Pagamento pagamento){
        if (pagamento.getValor() > 0 && pagamento.getValor()>= valorTotal){
            pagamento.realizarPagamento();
            System.out.println("Valor total: " + valorTotal);
            double troco = pagamento.getValor() - valorTotal;
            System.out.println("Troco: " + troco);

        } else {
            System.out.println("Erro: valor do pagamento insuficiente ou inválido.");
        }
    }
}
