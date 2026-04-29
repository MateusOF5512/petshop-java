package ui;

import java.time.LocalDate;
import service.ClienteService;
import util.EntradaUtil;

public class ClienteUI {

    public static void exibirMenuCliente() {

        int op = 0;
        ClienteService clienteService = new ClienteService();

        while (op != 5) {

            System.out.println();
            System.out.println("------------------------------------------");
            System.out.println("   CLIENTES                               ");
            System.out.println("------------------------------------------");
            System.out.println("  Opção (1) -> Adicionar cliente          ");
            System.out.println("  Opção (2) -> Remover cliente            ");
            System.out.println("  Opção (3) -> Listar clientes            ");
            System.out.println("  Opção (4) -> Atualizar clientes         ");
            System.out.println("  Opção (5) -> Voltar ao menu principal   ");
            System.out.println("__________________________________________");
            System.out.println();

            System.out.print("Digite a opção desejada: ");
            op = EntradaUtil.lerInt();

            switch (op) {

                // . CASO 1 -> Adicionar cliente
                case 1:
                    System.out.println("\n".repeat(4));
                    System.out.println("------- Informe os dados do cliente ------");
                    System.out.println();

                    System.out.print("Digite o nome completo do cliente: ");
                    String nome = EntradaUtil.lerString();

                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = EntradaUtil.lerString();
                    cpf = cpf.replace("-", "").replace(".", "").replace(" ", "");

                    System.out.print("Digite a data de nascimento do cliente (formato: yyyy/MM/dd): ");
                    String dataNasc = EntradaUtil.lerLocalDate();
                    LocalDate dataNascimento = LocalDate.parse(dataNasc);

                    System.out.print("Digite o telefone do cliente: ");
                    String telefone = EntradaUtil.lerString();
                    telefone = telefone.replace("(", "").replace(")", "").replace("-", "")
                            .replace(" ", "").replace(".", "");

                    try {
                        clienteService.adicionarCliente(nome, cpf, dataNascimento, telefone);
                        System.out.println();
                        System.out.println("[OK] Cliente adicionado com sucesso!");
                        System.out.println("\n".repeat(4));
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                // . CASO 2 -> Remover cliente
                case 2:
                    System.out.println("\n".repeat(4));
                    System.out.println("------- Informe o cliente a ser removido ------");
                    System.out.println();

                    try {
                        clienteService.listarClientes();
                        System.out.println();
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                        break;
                    }

                    System.out.print("Digite o CPF do cliente: ");
                    String cpfRemover = EntradaUtil.lerString().replace("-", "")
                            .replace(".", "").replace(" ", "");

                    try {
                        clienteService.excluirCliente(cpfRemover);
                        System.out.println();
                        System.out.println("[OK] Cliente removido com sucesso!");
                        System.out.println("\n".repeat(4));
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                        System.out.println("\n".repeat(4));
                    }
                    break;

                // . CASO 3 -> Listar clientes
                case 3:
                    try {
                        clienteService.listarClientes();
                        System.out.println("\n".repeat(4));
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                // . CASO 4 -> Atualizar clientes
                case 4:
                    System.out.println("\n".repeat(4));
                    System.out.println("------- Insira os dados a serem atualizados ------");
                    System.out.println();

                    try {
                        clienteService.listarClientes();
                        System.out.println();
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                        break;
                    }

                    System.out.print("Digite o CPF do cliente a ser atualizado: ");
                    String cpfAntigo = EntradaUtil.lerString().replace("-", "")
                            .replace(".", "").replace(" ", "");

                    System.out.print("Digite o novo nome do cliente: ");
                    String nomeAtualizar = EntradaUtil.lerString();

                    System.out.print("Digite o novo CPF do cliente: ");
                    String cpfNovo = EntradaUtil.lerString();
                    String cpfAtualizar = cpfNovo.replace("-", "").replace(".", "").replace(" ", "");

                    System.out.print("Digite a nova data de nascimento do cliente (formato: yyyy/MM/dd): ");
                    String dataNascAtualizar = EntradaUtil.lerLocalDate();
                    LocalDate dataNascimentoAtualizar = LocalDate.parse(dataNascAtualizar);

                    System.out.print("Digite o novo telefone do cliente: ");
                    String telefoneAtualizar = EntradaUtil.lerString();
                    telefoneAtualizar = telefoneAtualizar.replace("(", "").replace(")", "").replace("-", "")
                            .replace(" ", "").replace(".", "");

                    System.out.println();

                    try {
                        clienteService.atualizarCliente(cpfAntigo, nomeAtualizar, cpfAtualizar,
                                dataNascimentoAtualizar, telefoneAtualizar);
                        System.out.println();
                        System.out.println("[OK] Cliente atualizado com sucesso!");
                        System.out.println("\n".repeat(4));
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                        System.out.println("\n".repeat(4));
                    }
                    break;

                // . CASO 5 -> Voltar ao menu principal
                case 5:
                    System.out.println("\n".repeat(4));
                    break;

                // . CASO DEFAULT -> Opção inválida
                default:
                    System.out.println();
                    System.err.println("[ERRO] Opção inválida, tente novamente.");
                    System.out.println();
            }
        }
    }

}