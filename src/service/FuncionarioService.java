package service;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import repository.FuncionarioRepository;
import model.Funcionario;

public class FuncionarioService {
    private FuncionarioRepository repositorioFuncionarios = FuncionarioRepository.getInstance();

    //. ADICIONAR FUNCIONARIO
    public void adicionarFuncionario(String nome, String cpf, LocalDate dataNascimento, String telefone, String cargo) {
        Funcionario funcionario = new Funcionario(nome, cpf, dataNascimento, telefone, cargo);
        repositorioFuncionarios.adicionar(funcionario);
    }

    //. LISTAR FUNCIONARIOS
    public void listarFuncionarios() {
        int contador = 1;
        System.out.println("\n".repeat(2));
        System.out.println("LISTA DE FUNCIONARIOS");
        if (repositorioFuncionarios.listar().isEmpty()) {
            throw new RuntimeException("[INFO] Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario f : repositorioFuncionarios.listar()) {
                System.out.println(contador + " - " + f.getNome() + "(" + f.getCargo() + ")" + ", " + f.getCpf() + ", "
                        + f.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", "
                        + f.getTelefone());
                contador++; 
            }
        }
    }

    //. REMOVER FUNCIONARIO
    public void excluirFuncionario(String cpf) {
        boolean removido = false;
        for (Funcionario f : repositorioFuncionarios.listar()) {
            if (f.getCpf().equals(cpf)) {
                repositorioFuncionarios.remover(f);
                removido = true;
                break;
            }
        }
        if (!removido) {
            throw new RuntimeException("[INFO] Funcionário não encontrado! Tente novamente.");
        }
    }

    //. ATUALIZAR FUNCIONARIO
    public void atualizarFuncionario(String cpf, String nome, String cpfNovo, LocalDate dataNascimento,
            String telefone, String cargo) {
        boolean encontrado = false;
        for (Funcionario f : repositorioFuncionarios.listar()) {
            if (f.getCpf().equals(cpf)) {
                repositorioFuncionarios.atualizar(f, nome, cpfNovo, dataNascimento, telefone, cargo);
                encontrado = true;
            }
        }
        if (!encontrado) {
            throw new RuntimeException("[INFO] Funcionário não encontrado! Nenhuma informação foi alterada.");
        }
    }
}