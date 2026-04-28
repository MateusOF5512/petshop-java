import ui.MainUI;
import util.Placeholder;

public class Main {
    public static void main(String[] args) {
        Placeholder Placeholder = new Placeholder();

        System.out.println("\n".repeat(3));
        System.out.println("PETSHOP ========================== ");
        System.out.println("===== por João Leal e Mateus Ortiz");
        System.out.println("\n".repeat(3));

        Placeholder.chamarPlaceholder();
        
        MainUI.exibirMenu();
    }
}