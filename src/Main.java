import ui.MainUI;
// import util.Placeholder;

public class Main {
    public static void main(String[] args) {
        // Placeholder Placeholder = new Placeholder();
        // Placeholder.chamarPlaceholder();

        System.out.println("\n".repeat(3));
        System.out.println("PETSHOP ========================== ");
        System.out.println("===== por João Leal e Mateus Ortiz");
        System.out.println("\n".repeat(3));
        
        MainUI.exibirMenu();
    }

}

// ! ASSOCIAÇÃO: PetUI usa ClienteService para buscar/listar clientes, mas ambas existem de forma independente.
// ! COMPOSIÇÃO: Pet só existe se tiver um Cliente (dono). Ao excluir um Cliente, seus Pets são removidos junto.