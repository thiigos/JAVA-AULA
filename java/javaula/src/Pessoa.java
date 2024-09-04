public abstract class Pessoa implements Apresentavel{
    private String nome;
    private int idade;

    public Pessoa(){}

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public void apresentar() {
        System.out.println("Olá, eu sou " + nome + "!");
    }

    public void apresentar(int idade) {
        System.out.println("Olá, eu sou " + nome + " e tenho " + idade + " anos!");
    }
    @Override
    public String toString() {
        return "Nome: " + nome + "\nIdade: " + idade;
    }
}