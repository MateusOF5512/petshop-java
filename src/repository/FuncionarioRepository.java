package repository;

import model.Funcionario;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class FuncionarioRepository {

    // . Lista que simula o banco de dados
    private List<Funcionario> funcionarios = new ArrayList<>();

    // . Criação de uma instância única do repositório (SINGLETON)
    private static FuncionarioRepository instancia;


    // . CONSTRUTOR PRIVADO -> Impede que outras classes criem um novo repositório
    private FuncionarioRepository() {}


    // . Ao ser utilizado, cria um repositório e o retorna, caso contrário, retorna o
    // . repositório criado anteriormente
    public static FuncionarioRepository getInstance() {

        if (instancia == null) {
            instancia = new FuncionarioRepository();
        }

        return instancia;
    }


    // . MÉTODO ADICIONAR -> Adiciona um objeto funcionário à lista
    public void adicionar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }


    // . MÉTODO REMOVER -> Remove um objeto funcionário da lista
    public void remover(Funcionario f) {
        funcionarios.remove(f);
    }


    // . MÉTODO LISTAR -> Retorna a lista de funcionários
    public List<Funcionario> listar() {
        return funcionarios;
    }


    // . MÉTODO ATUALIZAR -> Recebe o objeto a ser atualizado e os novos atributos
    // . e atualiza utilizando os setters
    public void atualizar(Funcionario f, String nomeNovo, String cpf, LocalDate dataNascimento,
            String telefone, String cargo) {
        f.setNome(nomeNovo);
        f.setCpf(cpf);
        f.setDataNascimento(dataNascimento);
        f.setTelefone(telefone);
        f.setCargo(cargo);
    }

}