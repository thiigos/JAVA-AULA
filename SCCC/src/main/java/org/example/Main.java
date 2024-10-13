package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try (ClienteDAO clienteDAO = new ClienteDAO("clientes");
             ServicoDAO servicoDAO = new ServicoDAO("clientes")) {

            DatabaseInitializer.inicializarServicos(servicoDAO);

            System.out.println("Bem-vindo ao Sistema de Cadastro de Clientes e Serviços!");

            while (true) {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Cadastrar novo cliente");
                System.out.println("2. Listar todos os clientes");
                System.out.println("3. Alocar serviço para um cliente");
                System.out.println("4. Listar serviços de um cliente");
                System.out.println("5. Sair");

                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println("Nome do cliente:");
                        String nome = scanner.nextLine();
                        System.out.println("Email do cliente:");
                        String email = scanner.nextLine();
                        System.out.println("Telefone do cliente:");
                        String telefone = scanner.nextLine();
                        System.out.println("Endereço do cliente:");
                        String endereco = scanner.nextLine();
                        System.out.println("CPF do cliente:");
                        String cpf = scanner.nextLine();

                        Cliente novoCliente = new Cliente(nome, email, telefone, endereco, cpf);
                        clienteDAO.inserirCliente(novoCliente);
                        System.out.println("Cliente cadastrado com sucesso! ID: " + novoCliente.getId());
                        break;

                    case 2:
                        List<Cliente> clientes = clienteDAO.obterTodosClientes();
                        if (clientes.isEmpty()) {
                            System.out.println("Nenhum cliente cadastrado.");
                        } else {
                            for (Cliente cliente : clientes) {
                                System.out.println(cliente);
                            }
                        }
                        break;

                    case 3:
                        System.out.println("ID do cliente:");
                        int clienteId = scanner.nextInt();
                        scanner.nextLine();

                        List<Servico> servicosDisponiveis = servicoDAO.obterTodosServicos();
                        System.out.println("Serviços disponíveis:");
                        for (Servico servico : servicosDisponiveis) {
                            System.out.println("ID: " + servico.getId() + " - " + servico.getNome());
                        }

                        System.out.println("ID do serviço a alocar:");
                        int servicoId = scanner.nextInt();

                        clienteDAO.alocarServicoAoCliente(clienteId, servicoId);
                        System.out.println("Serviço alocado com sucesso!");
                        break;

                    case 4:
                        System.out.println("ID do cliente:");
                        int idCliente = scanner.nextInt();
                        List<Servico> servicosCliente = clienteDAO.obterServicosDoCliente(idCliente);

                        if (servicosCliente.isEmpty()) {
                            System.out.println("Este cliente não possui serviços alocados.");
                        } else {
                            System.out.println("Serviços alocados para o cliente ID " + idCliente + ":");
                            for (Servico servico : servicosCliente) {
                                System.out.println(servico);
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Saindo...");
                        return;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }
}
