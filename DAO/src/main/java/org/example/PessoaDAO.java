package org.example;

import java.sql.SQLException;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PessoaDAO implements AutoCloseable {

    private final Connection conexao;

    public PessoaDAO(String nomeBanco) {
        try {
            Path currentRelativaPath = Paths.get("");
            String projectPath = currentRelativaPath.toAbsolutePath().toString();

            String dbDirectory = projectPath + File.separator + "db";
            File directory = new File(dbDirectory);

            if (!directory.exists()) {
                directory.mkdirs();
                System.out.println("Diretório criado: " + dbDirectory);
            }

            String url = "jdbc:sqlite:" + dbDirectory + nomeBanco + "db";
            conexao = DriverManager.getConnection(url);
            criarTabelaPessoas();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ou criar o banco de dados: " + e.getMessage());
            throw new RuntimeException("Erro ao conectar ou criar o banco de dados", e);
        }
    }

    private void criarTabelaPessoas() {
        String sql = "CREATE TABLE IF NOT EXISTS pessoas (" + "id INTEGER PRIMARY KEY AUTOINCREMENT," + "nome TEXT," + "idade INTEGER," + "altura REAL" + ")";
        try (PreparedStatement statement = conexao.prepareStatement(sql)){
            statement.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela pessoas: " + e.getMessage());
            throw new RuntimeException("Erro ao criar tabela pessoas", e);
        }
    }
    public void inserirPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (id, nome, idade, altura) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, pessoa.getId());
            statement.setString(2, pessoa.getNome());
            statement.setInt(3, pessoa.getIdade());
            statement.setFloat(4, pessoa.getAltura());
            statement.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir pessoa de banco de dados: " + e.getMessage());
            throw new RuntimeException("Erro ao inserir pessoa no banco de dados", e);
        }
    }

    public Pessoa obterPessoaPorId(int id) {
        String sql = "SELECT id, nome, idade, altura FROM pessoas WHERE id = ?";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    return null;
                }
                return new Pessoa(result.getInt("id"),
                        result.getString("nome"),
                        result.getInt("idade"),
                        result.getFloat("altura"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter pessoa por ID: " + e.getMessage());
            throw new RuntimeException("Erro ao obter pessoa por ID", e);
        }
    }

    public List<Pessoa> obterTodasPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT id, nome, idade, altura FROM pessoas";
        try(PreparedStatement statement = conexao.prepareStatement(sql)) {
            try(ResultSet result = statement.executeQuery()){
                while (result.next()) {
                    pessoas.add(new Pessoa(result.getInt("id"), result.getString("nome"), result.getInt("idade"), result.getFloat("altura")));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter todas as pessoas: " + e.getMessage());
            throw new RuntimeException("Erro ao obter todas as pessoas", e);
        }
        return pessoas;
    }
    public void alterarPessoa(int id, String nome, Integer idade, Float altura) {
        StringBuilder sqlBuilder = new StringBuilder("UPDATE pessoas SET ");
        List<Object> parametros = new ArrayList<>();
        if (nome != null) {
            sqlBuilder.append("nome = ?,");
            parametros.add(nome);}
        if (idade != null) {
            sqlBuilder.append("idade = ?,");
            parametros.add(idade);}
        if (altura != null) {
            sqlBuilder.append("altura = ?,");
            parametros.add(altura);}
        sqlBuilder.append(" Where id = ?");
        parametros.add(id);
        try (PreparedStatement statement = conexao.prepareStatement(sqlBuilder.toString())) {
            for (int i = 0; i < parametros.size(); i++) {
                statement.setObject(i + 1, parametros.get(i));
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao alterar pessoa: " + e.getMessage());
            throw new RuntimeException("Erro ao alterar pessoa", e);
        }
    }
}