package ui;

import service.PetService;
import util.EntradaUtil;

public class PetUI {

    public static void exibirMenuPet() {

        int op = 0;
        PetService petService = new PetService();

        while (op != 5) {
            System.out.println();
            System.out.println("------------------------------------------");
            System.out.println("   PETS                                   ");
            System.out.println("------------------------------------------");
            System.out.println("  Opção (1) -> Adicionar pet              ");
            System.out.println("  Opção (2) -> Remover pet                ");
            System.out.println("  Opção (3) -> Listar pets               ");
            System.out.println("  Opção (4) -> Atualizar pet              ");
            System.out.println("  Opção (5) -> Voltar ao menu principal   ");
            System.out.println("__________________________________________");
            System.out.println();

            System.out.print("Digite a opção desejada: ");
            op = EntradaUtil.lerInt();

            switch (op) {

                // . CASO 1 -> Adicionar pet
                case 1:
                    System.out.println("\n".repeat(5));
                    System.out.println("------- Informe os dados do pet ------");
                    System.out.println();

                    System.out.print("Digite o nome do pet: ");
                    String nome = EntradaUtil.lerString();

                    System.out.print("Digite o codigo do pet: ");
                    String codigo = EntradaUtil.lerString();

                    System.out.print("Digite o animal: ");
                    String animal = EntradaUtil.lerString();

                    System.out.print("Digite a raça do pet: ");
                    String raca = EntradaUtil.lerString();

                    System.out.print("Digite o ano de nascimento do pet: ");
                    int anoNascimento = EntradaUtil.lerInt();

                    System.out.print("Digite o peso do pet: ");
                    double peso = EntradaUtil.lerDouble();

                    try {
                        petService.adicionarPet(nome, codigo, animal, raca, anoNascimento, peso);
                        System.out.println();
                        System.out.println("[OK] Pet adicionado com sucesso!");
                        System.out.println("\n".repeat(5));
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                // . CASO 2 -> Remover pet
                case 2:
                    System.out.println("\n".repeat(5));
                    System.out.println("------- Informe o pet a ser removido ------");
                    System.out.println();

                    System.out.print("Digite o codigo do pet: ");
                    String codigoRemover = EntradaUtil.lerString();

                    try {
                        petService.excluirPet(codigoRemover);
                        System.out.println();
                        System.out.println("[OK] Pet removido com sucesso!");
                        System.out.println("\n".repeat(5));
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                        System.out.println("\n".repeat(5));
                    }
                    break;

                // . CASO 3 -> Listar pets
                case 3:
                    try {
                        petService.listarPets();
                        System.out.println("\n".repeat(5));
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                // . CASO 4 -> Atualizar pet
                case 4:
                    System.out.println("\n".repeat(5));
                    System.out.println("------- Insira os dados a serem atualizados ------");
                    System.out.println();

                    System.out.print("Digite o codigo do pet a ser atualizado: ");
                    String codigoAntigo = EntradaUtil.lerString();

                    System.out.print("Digite o novo nome do pet: ");
                    String nomeNovo = EntradaUtil.lerString();

                    System.out.print("Digite o novo codigo do pet: ");
                    String codigoNovo = EntradaUtil.lerString();

                    System.out.print("Digite o novo animal: ");
                    String animalNovo = EntradaUtil.lerString();

                    System.out.print("Digite a nova raça do pet: ");
                    String racaNova = EntradaUtil.lerString();

                    System.out.print("Digite a novo ano de nascimento do pet: ");
                    int anoNascimentoAtualizar = EntradaUtil.lerInt();

                    System.out.print("Digite o novo peso do pet: ");
                    double pesoNovo = EntradaUtil.lerDouble();

                    try {
                        petService.atualizarPet(codigoAntigo, nomeNovo, codigoNovo, animalNovo, racaNova,
                                anoNascimentoAtualizar, pesoNovo);

                        System.out.println();
                        System.out.println("[OK] Pet atualizado com sucesso!");
                        System.out.println("\n".repeat(5));

                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                        System.out.println("\n".repeat(5));
                    }
                    break;

                // . CASO 5 -> Voltar ao menu principal
                case 5:
                    System.out.println("\n".repeat(5));
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