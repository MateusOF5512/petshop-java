package ui;
import util.EntradaUtil;

public class MainUI {
    public static void exibirMenu() {
        int op = 0;

        while (op != 4) {
            System.out.println("==================================");
            System.out.println("        Menu Principal            ");
            System.out.println("==================================");
            System.out.println("  Opção (1) -> Menu Clientes      ");
            System.out.println("  Opção (2) -> Menu Funcionários  ");
            System.out.println("  Opção (3) -> Menu Pet           ");
            System.out.println("  Opção (4) -> Sair               ");
            System.out.println("__________________________________");
            System.out.println();
            System.out.print("Digite a opção desejada: ");
            op = EntradaUtil.sc.nextInt();
            EntradaUtil.sc.nextLine();

            switch (op) {
                case 1:
                    System.out.println("\n".repeat(10));
                    ClienteUI.exibirMenuCliente();
                    break;
                case 2:
                    System.out.println("\n".repeat(10));
                    FuncionarioUI.exibirMenuFuncionario();
                    break;
                case 3:
                    System.out.println("\n".repeat(10));
                    PetUI.exibirMenuPet();
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Saindo do programa...");
                    System.exit(0);
                default:
                    System.out.println();
                    System.err.println("[ERRO] Opção inválida, tente novamente.");
                    System.out.println();
            }
        }
    }
}
