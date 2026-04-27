package util;
import java.util.Scanner;

//! IMPORTANTE (Scanner centralizado): O Scanner é compartilhado entre todas as classes do projeto.
//! Todas as leituras devem usar os métodos desta classe ou EntradaUtil.sc diretamente.
//! Isso evita que fechar o Scanner em uma classe encerre o System.in e quebre as demais.

//. EXPLICAÇÃO DE MÉTODOS
//. Trim() -> Remove espaços em branco no inicio e fim da string (String.trim()).
//. isEmpty() -> Verifica se a string está vazia (String.isEmpty()).
//. matches() -> Verifica se a string corresponde ao padrão regex (String.matches()).

public class EntradaUtil {
    public static Scanner sc = new Scanner(System.in);

    //. MÉTODO LER STRING — lê uma string, remove espaços com trim()
    //. rejeita entradas vazias, solicitando nova entrada até receber um valor válido.
    public static String lerString() {
        String entrada = sc.nextLine().trim();
        while (entrada.isEmpty()) {
            System.out.print("Entrada inválida, tente novamente: ");
            entrada = sc.nextLine().trim();
        }
        return entrada;
    }

    //. MÉTODO LER LOCAL DATE -> Lê uma data no formato yyyy-MM-dd, remove espaços com trim()
    //. e valida o formato via regex antes de retornar. Substitui "/" por "-" automaticamente.
    public static String lerLocalDate() {
        String entrada = sc.nextLine().trim();
        entrada = entrada.replace("/", "-").replace(" ","-");
        while (entrada.isEmpty() || !entrada.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.print("Entrada inválida, tente novamente: ");
            entrada = sc.nextLine().trim();
            entrada = entrada.replace("/", "-").replace(" ","-");
        }
        return entrada;
    }
}
