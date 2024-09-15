public class Main {
    public static void main(String[] args) {
        Pagamento pagamentoCartao = new PagamentoCartao("Thiago Henrique Silva", "1234 5678 9123 4567", 500 );
        Pagamento pagamentoBoleto = new PagamentoBoleto("123456789123456789", 250);
        Pagamento pagamentoPix = new PagamentoPix("123.456.789-12", 300);

        Pedido pedido = new Pedido(200);

        System.out.println("Processando pagamento com cartão: ");
        pedido.processarPagamento(pagamentoCartao);

        System.out.println("\nProcessando pagamento com boleto: ");
        pedido.processarPagamento(pagamentoBoleto);

        System.out.println("\nProcessando pagamento com Pix: ");
        pedido.processarPagamento(pagamentoPix);
    }
}