public class FolhaDePagamento {
    public void calcularFolha(Funcionario funcionario){
        System.out.println("\nFuncionario: " + funcionario.getNome());
        System.out.println("Cargo: " + funcionario.getCargo());
        System.out.println("Salario líquido: " + funcionario.calcularSalarioLiquido());
    }
}
