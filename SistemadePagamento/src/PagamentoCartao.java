public class PagamentoCartao extends Pagamento {
    private String nomeTitular;
    private String numeroCartao;

    public PagamentoCartao(String nomeTitular, String numeroCartao, double valor) {
        super(valor);
        this.nomeTitular = nomeTitular;
        this.numeroCartao = numeroCartao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    @Override
    public double getValor() {
        return super.getValor();
    }

    @Override
    public void realizarPagamento() {
        System.out.println("Pagamento realizado com cartão de crédito");
        System.out.println("Titular: " + nomeTitular + " \nNúmero do cartão: " + numeroCartao);
    }
}
