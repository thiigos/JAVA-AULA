import java.util.Scanner;

public class Cadastro {
    private Scanner scanner;
    private Diretor diretor;
    private SistemaDeAutentificação sistemaDeAutentificação;
    private FolhaDePagamento folhaDePagamento;
    private Gerente gerente;
    private FuncionarioComum funcionarioComum;

    public Cadastro(){
        this.scanner = new Scanner(System.in);
        this.diretor = new Diretor("Thiago Henrique Silva", 10000.0, "Diretor", "senha123");
        this.sistemaDeAutentificação = new SistemaDeAutentificação();
        this.folhaDePagamento = new FolhaDePagamento();
    }

    public void loginDiretor(){

        System.out.println("olá " + diretor.nome + ", por favor digite sua senha");
        System.out.print("\nSenha: ");
        String loginSenha = scanner.nextLine();
        sistemaDeAutentificação.login(diretor, loginSenha);
        iniciar();
    }

    public void iniciar(){
        exibirMenu();
    }

    private void exibirMenu() {
        System.out.println("\n========================");
        System.out.println("1. cadastrar funcionario");
        System.out.println("2. cadastrar Gerente");
        System.out.println("3. calcular folha de pagamento");
        System.out.println("4. Sair");
        System.out.println("========================");
        System.out.println("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        processarOpcao(opcao);
    }

    public void processarOpcao(int opcao) {
        if (opcao == 1) {
            cadastrarComum();
        } else if (opcao == 2) {
            cadastrarGerente();
        } else if (opcao == 3) {
            calcularFolha();
        } else if (opcao == 4) {
            sair();
        } else {
            System.out.println("Opção inválida, tente novamente.\n");
            exibirMenu();
        }
    }

    public void cadastrarComum(){
        System.out.print("\nNome do funcionario: ");
        String nomefuncionario = scanner.nextLine();
        System.out.print("Salário do funcionario: ");
        double salariofuncionario = scanner.nextDouble();
        scanner.nextLine(); // Limpa o buffer
        System.out.print("Senha do funcionario: ");
        String senhafuncionario = scanner.nextLine();
        this.funcionarioComum = new FuncionarioComum(nomefuncionario, salariofuncionario, "funcionario Comum", senhafuncionario);
        exibirMenu();
    }

    public void cadastrarGerente(){
        System.out.print("\nNome do Gerente: ");
        String nomeGerente = scanner.nextLine();
        System.out.print("Salário do Gerente: ");
        double salarioGerente = scanner.nextDouble();
        scanner.nextLine(); // Limpa o buffer
        System.out.print("Senha do Gerente: ");
        String senhaGerente = scanner.nextLine();
        this.gerente = new Gerente(nomeGerente, salarioGerente, "Gerente", senhaGerente);
        exibirMenu();
    }

    public void calcularFolha(){
        System.out.println("\nCalculando folha de pagamento: ");
        folhaDePagamento.calcularFolha(funcionarioComum);
        folhaDePagamento.calcularFolha(gerente);
        folhaDePagamento.calcularFolha(diretor);
        exibirMenu();
    }

    public void sair() {
        System.out.println("Saindo do sistema...\n");
    }
}
