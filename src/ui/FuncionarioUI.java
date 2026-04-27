package ui;
import java.time.LocalDate;
import service.FuncionarioService;
import util.EntradaUtil;

public class FuncionarioUI {
    public static void exibirMenuFuncionario() {

        int op = 0;
        FuncionarioService funcionarioService = new FuncionarioService();

        while (op != 5) {
            System.out.println();
            System.out.println("------------------------------------------");
            System.out.println("   FUNCIONARIOS                           ");
            System.out.println("------------------------------------------");
            System.out.println("  Opção (1) -> Adicionar funcionário      ");
            System.out.println("  Opção (2) -> Remover funcionário        ");
            System.out.println("  Opção (3) -> Listar funcionários        ");
            System.out.println("  Opção (4) -> Atualizar funcionário      ");
            System.out.println("  Opção (5) -> Voltar ao menu principal   ");
            System.out.println("__________________________________________");
            System.out.println();

            System.out.print("Digite a opção desejada: ");
            op = EntradaUtil.sc.nextInt();
            EntradaUtil.sc.nextLine();

            switch (op) {
                //. CASO 1 -> Adicionar funcionario
                case 1:
                    System.out.println("\n".repeat(5));
                    System.out.println("------- Informe os dados do funcionário ------");
                    System.out.println();

                    System.out.print("Digite o nome completo do funcionário: ");
                    String nome = EntradaUtil.lerString();

                    System.out.print("Digite o CPF do funcionário: ");
                    String cpf = EntradaUtil.lerString();
                    cpf = cpf.replace("-", "").replace(".", "").replace(" ", "");

                    System.out.print("Digite a data de nascimento do funcionário (formato: yyyy/MM/dd): ");
                    String dataNasc = EntradaUtil.lerLocalDate();
                    LocalDate dataNascimento = LocalDate.parse(dataNasc);

                    System.out.print("Digite o telefone do funcionário: ");
                    String telefone = EntradaUtil.lerString();
                    telefone = telefone.replace("(", "").replace(")", "").replace("-", "").replace(" ", "").replace(".",
                            "");

                    System.out.print("Digite o cargo do funcionário: ");
                    String cargo = EntradaUtil.lerString();

                    try {
                        funcionarioService.adicionarFuncionario(nome, cpf, dataNascimento, telefone, cargo);
                        System.out.println();
                        System.out.println("[OK] Funcionário adicionado com sucesso!");
                        System.out.println("\n".repeat(5));
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                //. CASO 2 -> Remover funcionario
                case 2:
                    System.out.println("\n".repeat(5));
                    System.out.println("------- Informe o funcionário a ser removido ------");
                    System.out.println();

                    System.out.print("Digite o CPF do funcionário: ");
                    String cpfRemover = EntradaUtil.lerString().replace("-", "")
                        .replace(".", "").replace(" ", "");
                    try {
                        funcionarioService.excluirFuncionario(cpfRemover);
                        System.out.println();
                        System.out.println("[OK] Funcionário removido com sucesso!");
                        System.out.println("\n".repeat(5));
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                        System.out.println("\n".repeat(5));
                    }
                    break;

                //. CASO 3 -> Listar funcionarios
                case 3:
                    try {
                        funcionarioService.listarFuncionarios();
                        System.out.println("\n".repeat(5));
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                //. CASO 4 -> Atualizar funcionario
                case 4:
                    System.out.println("\n".repeat(5));
                    System.out.println("------- Insira os dados a serem atualizados ------");
                    System.out.println();

                    System.out.print("Digite o cpf do funcionário a ser atualizado: ");
                    String cpfAntigo = EntradaUtil.lerString().replace("-", "")
                        .replace(".", "").replace(" ", "");

                    System.out.print("Digite o novo nome do funcionário: ");
                    String nomeAtualizar = EntradaUtil.lerString();

                    System.out.print("Digite o novo CPF do funcionário: ");
                    String cpfAtualizar = EntradaUtil.lerString();
                    cpfAtualizar = cpfAtualizar.replace("-", "").replace(".", "").replace(" ", "");

                    System.out.print("Digite a nova data de nascimento do funcionário (formato: yyyy/MM/dd): ");
                    String dataNascAtualizar = EntradaUtil.lerLocalDate();
                    LocalDate dataNascimentoAtualizar = LocalDate.parse(dataNascAtualizar);

                    System.out.print("Digite o novo telefone do funcionário: ");
                    String telefoneAtualizar = EntradaUtil.lerString();
                    telefoneAtualizar = telefoneAtualizar.replace("(", "").replace(")", "").replace("-", "")
                            .replace(" ", "").replace(".", "");

                    System.out.print("Digite o novo cargo do funcionário: ");
                    String cargoAtualizar = EntradaUtil.lerString();

                    System.out.println();

                    try {
                        funcionarioService.atualizarFuncionario(cpfAntigo, nomeAtualizar, cpfAtualizar,
                                dataNascimentoAtualizar, telefoneAtualizar, cargoAtualizar);
                        System.out.println();
                        System.out.println("[OK] Funcionário atualizado com sucesso!");
                        System.out.println("\n".repeat(5));
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                        System.out.println("\n".repeat(5));
                    }
                    break;

                //. CASO 5 -> Voltar ao menu principal
                case 5:
                    System.out.println("\n".repeat(5));
                    break;

                //. CASO DEFAULT -> Opção inválida
                default:
                    System.out.println();
                    System.err.println("[ERRO] Opção inválida, tente novamente.");
                    System.out.println();
                }
        }
    }
}