package repository;

import model.Funcionario;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class FuncionarioRepository {

    private List<Funcionario> funcionarios = new ArrayList<>();
    private static FuncionarioRepository instancia;

    private FuncionarioRepository() {
    }

    // . MÉTODO GETINSTANCE
    public static FuncionarioRepository getInstance() {
        if (instancia == null) {
            instancia = new FuncionarioRepository();
        }
        return instancia;
    }

    // . MÉTODO ADICIONAR
    public void adicionar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    // . MÉTODO REMOVER
    public void remover(Funcionario f) {
        funcionarios.remove(f);
    }

    // . MÉTODO LISTAR
    public List<Funcionario> listar() {
        return funcionarios;
    }

    // . MÉTODO ATUALIZAR
    public void atualizar(Funcionario f, String nomeNovo, String cpf, LocalDate dataNascimento, String telefone,
            String cargo) {
        f.setNome(nomeNovo);
        f.setCpf(cpf);
        f.setDataNascimento(dataNascimento);
        f.setTelefone(telefone);
        f.setCargo(cargo);
    }
}
