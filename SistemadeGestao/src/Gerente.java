public class Gerente extends Funcionario implements Autenticavel{
    private String senha;

    public Gerente(String nome, double salario, String cargo, String senha) {
        super(nome, salario, cargo);
        this.senha = senha;
    }

    @Override
    public double calcularSalarioLiquido() {
        return getSalario()*0.95;
    }

    @Override
    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }
}
