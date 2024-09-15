public class PagamentoBoleto extends Pagamento {
    private String codigoBarras;

    public PagamentoBoleto(String codigoBarras, double valor) {
        super(valor);
        this.codigoBarras = codigoBarras;
   }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    @Override
    public double getValor() {
        return super.getValor();
    }

    @Override
    public void realizarPagamento() {
        System.out.println("Pagamento realizado com boleto");
        System.out.println("Código de barras: " + codigoBarras);
   }
}