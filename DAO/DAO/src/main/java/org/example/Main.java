package org.example;

public class Main {
    public static void main(String[] args) {
       try(PessoaDAO dao = new PessoaDAO("Alunos")) {
           Pessoa pessoa1 = new Pessoa(1, "Rafael", 40, (float) 1.88);
           Pessoa pessoa2 = new Pessoa(2, "Paulo", 95, (float) 1.76);
           Pessoa pessoa3 = new Pessoa(3, "Marcio", 2, (float) 1.28);
           Pessoa pessoa4 = new Pessoa(4, "Roberto", 42, (float) 1.18);

           dao.inserirPessoa(pessoa1);
           dao.inserirPessoa(pessoa2);
           dao.inserirPessoa(pessoa3);
           dao.inserirPessoa(pessoa4);

           System.out.println("Todas as pessoas: ");
           dao.obterTodasPessoas().forEach(System.out::println);
       }
    }
}