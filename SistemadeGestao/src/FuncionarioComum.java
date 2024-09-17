public class FuncionarioComum extends Funcionario {
    private String senha;

    public FuncionarioComum(String nome, Double salario, String cargo, String senha){
        super(nome, salario, cargo);
        this.senha = senha;
    }

    @Override
    public double calcularSalarioLiquido(){
        return getSalario() * 0.90;
    }
}
