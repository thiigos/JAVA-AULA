public class PagamentoPix extends Pagamento {
    private String chavePix;

    public PagamentoPix(String chavePix, double valor){
        super(valor);
        this.chavePix = chavePix;
    }

    public String getChavePix() {
        return chavePix;
    }

    @Override
    public double getValor() {
        return super.getValor();
    }

    @Override
    public void realizarPagamento() {
        System.out.println("Pagamento realizado com pix");
        System.out.println("Chave pix: " + chavePix);
    }
}
