package service;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import repository.FuncionarioRepository;
import model.Funcionario;

public class FuncionarioService {

    // . Criação de um repositório
    private FuncionarioRepository repositorioFuncionarios = FuncionarioRepository.getInstance();


    // . ADICIONAR FUNCIONARIO
    public void adicionarFuncionario(String nome, String cpf, LocalDate dataNascimento,
            String telefone, String cargo) {

        Funcionario funcionario = new Funcionario(nome, cpf, dataNascimento, telefone, cargo);
        repositorioFuncionarios.adicionar(funcionario);
    }


    // . LISTAR FUNCIONARIOS
    public void listarFuncionarios() {

        int contador = 1;

        System.out.println("\n".repeat(2));
        System.out.println("LISTA DE FUNCIONARIOS");

        if (repositorioFuncionarios.listar().isEmpty()) {
            throw new RuntimeException("[INFO] Nenhum funcionário cadastrado.");
        }

        for (Funcionario f : repositorioFuncionarios.listar()) {
            System.out.println(contador + " - " + f.getNome() + " (" + f.getCargo() + "), " + f.getCpf() + ", "
                    + f.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", "
                    + f.getTelefone());
            contador++;
        }
    }


    // . BUSCAR FUNCIONARIO POR CPF
    public Funcionario buscarFuncionario(String cpf) {

        for (Funcionario f : repositorioFuncionarios.listar()) {
            if (f.getCpf().equals(cpf)) {
                return f;
            }
        }

        throw new RuntimeException("[INFO] Funcionário não encontrado.");
    }


    // . REMOVER FUNCIONARIO
    public void excluirFuncionario(String cpf) {

        Funcionario funcionario = buscarFuncionario(cpf);
        repositorioFuncionarios.remover(funcionario);
    }


    // . ATUALIZAR FUNCIONARIO
    public void atualizarFuncionario(String cpf, String nome, String cpfNovo, LocalDate dataNascimento,
            String telefone, String cargo) {

        Funcionario funcionario = buscarFuncionario(cpf);
        repositorioFuncionarios.atualizar(funcionario, nome, cpfNovo, dataNascimento, telefone, cargo);
    }

}