public class Main {
    public static void main(String[] args) {

        Pessoa aluno = new Aluno ("Thiago", 19, 73485);

        Pessoa professor = new Professor ("Alysson", 21, "POO");

        System.out.println("Informações da primeira pessoa:\n"+aluno.toString()+"\n");
        System.out.println("Informações da segunda pessoa:\n"+professor.toString()+"\n");
        aluno.apresentar(aluno.getIdade());
        professor.apresentar(professor.getIdade());
    }
}
