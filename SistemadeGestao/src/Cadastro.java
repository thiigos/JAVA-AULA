import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastro {
    private Scanner scanner;
    private Diretor diretor;
    private SistemaDeAutentificação sistemaDeAutentificação;
    private FolhaDePagamento folhaDePagamento;
    private List<Gerente> gerentes;
    private List<FuncionarioComum> funcionariosComuns;

    public Cadastro(){
        this.scanner = new Scanner(System.in);
        this.diretor = new Diretor("Thiago Henrique Silva", 10000.0, "Diretor", "senha123");
        this.sistemaDeAutentificação = new SistemaDeAutentificação();
        this.folhaDePagamento = new FolhaDePagamento();
        this.gerentes = new ArrayList<>(); // Inicializa a lista de gerentes
        this.funcionariosComuns = new ArrayList<>(); // Inicializa a lista de funcionários comuns
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
        System.out.println("4. remover funcionario");
        System.out.println("5. remover gerente");
        System.out.println("6. Sair");
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
            removerFuncionario();
        } else if (opcao == 5) {
            removerGerente();
        } else if (opcao == 6) {
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
        scanner.nextLine();
        System.out.print("Senha do funcionario: ");
        String senhafuncionario = scanner.nextLine();

        FuncionarioComum funcionarioComum = new FuncionarioComum(nomefuncionario, salariofuncionario, "Funcionario Comum", senhafuncionario);
        funcionariosComuns.add(funcionarioComum);

        System.out.println("Funcionário cadastrado com sucesso.");
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

        Gerente gerente = new Gerente(nomeGerente, salarioGerente, "Gerente", senhaGerente);
        gerentes.add(gerente);

        System.out.println("Gerente cadastrado com sucesso.");
        exibirMenu();
    }

    public void calcularFolha(){
        System.out.println("\nCalculando folha de pagamento: ");

        for (FuncionarioComum funcionario : funcionariosComuns) {
            folhaDePagamento.calcularFolha(funcionario);
        }

        for (Gerente gerente : gerentes) {
            folhaDePagamento.calcularFolha(gerente);
        }

        folhaDePagamento.calcularFolha(diretor);

        exibirMenu();
    }

    public void removerFuncionario() {
        if (funcionariosComuns.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado para remover.");
            exibirMenu();
            return;
        }

        System.out.println("\nFuncionários cadastrados:");
        for (int i = 0; i < funcionariosComuns.size(); i++) {
            System.out.println((i + 1) + ". " + funcionariosComuns.get(i).getNome());
        }

        System.out.print("Escolha o número do funcionário que deseja remover: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao > 0 && opcao <= funcionariosComuns.size()) {
            funcionariosComuns.remove(opcao - 1);
            System.out.println("Funcionário removido com sucesso.");
        } else {
            System.out.println("Opção inválida.");
        }

        exibirMenu();
    }

    public void removerGerente() {
        if (gerentes.isEmpty()) {
            System.out.println("Nenhum gerente cadastrado para remover.");
            exibirMenu();
            return;
        }

        System.out.println("\nGerentes cadastrados:");
        for (int i = 0; i < gerentes.size(); i++) {
            System.out.println((i + 1) + ". " + gerentes.get(i).getNome());
        }

        System.out.print("Escolha o número do gerente que deseja remover: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao > 0 && opcao <= gerentes.size()) {
            gerentes.remove(opcao - 1);
            System.out.println("Gerente removido com sucesso.");
        } else {
            System.out.println("Opção inválida.");
        }

        exibirMenu();
    }

    public void sair() {
        System.out.println("Saindo do sistema...\n");
    }
}

