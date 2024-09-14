import java.util.Scanner;

public class Banco {
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;
    private Scanner scanner;

    public Banco() {
        this.contaCorrente = new ContaCorrente("Thiago Henrique Silva", 2000, 5);
        this.contaPoupanca = new ContaPoupanca("Thiago Henrique Silva", 3000, 1.5);
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        exibirMenu();
    }

    public void exibirMenu() {
        System.out.println("=========================");
        System.out.println("1. Ver saldo Conta Corrente");
        System.out.println("2. Ver saldo Conta Poupança");
        System.out.println("3. Depositar em Conta Corrente");
        System.out.println("4. Depositar em Conta Poupança");
        System.out.println("5. Sacar da Conta Corrente");
        System.out.println("6. Sacar da Conta Poupança");
        System.out.println("7. Transferir da Conta Corrente para Poupança");
        System.out.println("8. Transferir da Conta Poupança para Corrente");
        System.out.println("9. Aplicar taxas");
        System.out.println("10. Sair");
        System.out.println("=========================");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        processarOpcao(opcao);
    }

    public void processarOpcao(int opcao) {
        if (opcao == 1) {
            exibirSaldoContaCorrente();
        } else if (opcao == 2) {
            exibirSaldoContaPoupanca();
        } else if (opcao == 3) {
            depositarContaCorrente();
        } else if (opcao == 4) {
            depositarContaPoupanca();
        } else if (opcao == 5) {
            sacarContaCorrente();
        } else if (opcao == 6) {
            sacarContaPoupanca();
        } else if (opcao == 7) {
            transferirCorrenteParaPoupanca();
        } else if (opcao == 8) {
            transferirPoupancaParaCorrente();
        } else if (opcao == 9) {
            aplicarTaxas();
        } else if (opcao == 10) {
            sair();
        } else {
            System.out.println("Opção inválida, tente novamente.\n");
            exibirMenu();
        }
    }

    public void exibirSaldoContaCorrente() {
        System.out.println("Saldo Conta Corrente: R$" + contaCorrente.getSaldo() + "\n");
        exibirMenu();
    }

    public void exibirSaldoContaPoupanca() {
        System.out.println("Saldo Conta Poupança: R$" + contaPoupanca.getSaldo() + "\n");
        exibirMenu();
    }

    public void depositarContaCorrente() {
        System.out.print("Digite o valor para depositar na Conta Corrente: R$");
        double valor = scanner.nextDouble();
        contaCorrente.depositar(valor);
        exibirMenu();
    }

    public void depositarContaPoupanca() {
        System.out.print("Digite o valor para depositar na Conta Poupança: R$");
        double valor = scanner.nextDouble();
        contaPoupanca.depositar(valor);
        exibirMenu();
    }

    public void sacarContaCorrente() {
        System.out.print("Digite o valor para sacar da Conta Corrente: R$");
        double valor = scanner.nextDouble();
        contaCorrente.sacar(valor);
        exibirMenu();
    }

    public void sacarContaPoupanca() {
        System.out.print("Digite o valor para sacar da Conta Poupança: R$");
        double valor = scanner.nextDouble();
        contaPoupanca.sacar(valor);
        exibirMenu();
    }

    public void transferirCorrenteParaPoupanca() {
        System.out.print("Digite o valor para transferir da Conta Corrente para Poupança: R$");
        double valor = scanner.nextDouble();
        contaCorrente.transferir(valor, contaPoupanca);
        exibirMenu();
    }

    public void transferirPoupancaParaCorrente() {
        System.out.print("Digite o valor para transferir da Conta Poupança para Corrente: R$");
        double valor = scanner.nextDouble();
        contaPoupanca.transferir(valor, contaCorrente);
        exibirMenu();
    }

    public void aplicarTaxas() {
        contaCorrente.aplicartaxas();
        contaPoupanca.aplicartaxas();
        exibirMenu();
    }

    public void sair() {
        System.out.println("Saindo do sistema...\n");
    }
}