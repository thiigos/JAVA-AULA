public class Aluno extends Pessoa {
    private int matricula;

    public Aluno(String nome, int idade, int matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }

    public int getMatricula(){
        return matricula;
    }

    @Override
    public String toString(){
        return super.toString() + "\nMatricula: " + matricula;
    }
}


