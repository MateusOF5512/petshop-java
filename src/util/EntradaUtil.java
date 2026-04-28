package util;

import java.util.Scanner;

// ! IMPORTANTE (Scanner centralizado): O Scanner é compartilhado entre todas as classes do projeto.
// ! Todas as leituras devem usar os métodos desta classe ou EntradaUtil.sc diretamente.
// ! Isso evita que fechar o Scanner em uma classe encerre o System.in e quebre as demais.

// . EXPLICAÇÃO DE MÉTODOS
// . Trim() -> Remove espaços em branco no inicio e fim da string (String.trim()).
// . isEmpty() -> Verifica se a string está vazia (String.isEmpty()).
// . matches() -> Verifica se a string corresponde ao padrão regex (String.matches()).

public class EntradaUtil {
    public static Scanner sc = new Scanner(System.in);

    // . MÉTODO LER STRING — lê uma string, remove espaços com trim()
    // . rejeita entradas vazias, solicitando nova entrada até receber um valor válido.
    public static String lerString() {
        String entrada = sc.nextLine().trim();
        while (entrada.isEmpty()) {
            System.out.print("Entrada invalida, tente novamente: ");
            entrada = sc.nextLine().trim();
        }
        return entrada;
    }

    // . MÉTODO LER LOCAL DATE -> Lê uma data no formato yyyy-MM-dd, remove espaços com trim()
    // . e valida o formato via regex antes de retornar. Substitui "/" por "-" automaticamente.
    public static String lerLocalDate() {
        String entrada = sc.nextLine().trim();
        entrada = entrada.replace("/", "-").replace(" ", "-");
        while (entrada.isEmpty() || !entrada.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.print("Entrada invalida, tente novamente: ");
            entrada = sc.nextLine().trim();
            entrada = entrada.replace("/", "-").replace(" ", "-");
        }
        return entrada;
    }

    // . MÉTODO LER INT -> Lê a entrada com hasNextInt(), validando se é um inteiro antes de consumir.
    // . Se válido, nextInt() lê e retorna o valor. Se inválido solicita nova entrada.
    public static int lerInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Entrada invalida, tente novamente: ");
            sc.next();
        }
        int entrada = sc.nextInt();
        sc.nextLine();
        return entrada;
    }

    // . MÉTODO LER DOUBLE -> Lê uma string, remove espaços com trim() e normaliza o separador decimal
    // . substituindo "," por "." para garantir compatibilidade entre diferentes localidades do sistema.
    // . Valida o formato via regex antes de converter e retornar como double.
    public static double lerDouble() {
        String entrada = sc.nextLine().trim().replace(",", ".");
        while (entrada.isEmpty() || !entrada.matches("\\d+(\\.\\d+)?")) {
            System.out.print("Entrada invaalida, tente novamente: ");
            entrada = sc.nextLine().trim().replace(",", ".");
        }
        return Double.parseDouble(entrada);
    }
}
