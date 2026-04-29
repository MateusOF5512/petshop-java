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

        // ! PARA FINS DE CONHECIMENTO: 
        // ! Associação ocorre em Pet, que possui um atributo Cliente.
        // ! Agregação: o repositório mantém uma coleção de Cliente,
        // ! mas os clientes têm ciclo de vida independente e podem existir sem ele.
    }

}