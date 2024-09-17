public class Diretor extends Funcionario implements Autenticavel {
    private String senha;

    public Diretor(String nome, Double salario,String cargo, String senha) {
        super(nome, salario, cargo);
        this.senha = senha;
    }

    @Override
    public double calcularSalarioLiquido() {
        return getSalario();
    }

    @Override
    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }
}
