package repository;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class ClienteRepository {

    // . Lista que simula o banco de dados
    private List<Cliente> clientes = new ArrayList<>();

    // . Criação de uma instância única do repositório (SINGLETON)
    private static ClienteRepository instancia;

    // . CONSTRUTOR PRIVADO -> Impede que outras classes criem um novo repositório
    private ClienteRepository() {
    }

    // . Ao ser utilizado, cria um repositório, caso contrário, retorna o
    // . repositório criado anteriormente
    public static ClienteRepository getInstance() {
        if (instancia == null) {
            instancia = new ClienteRepository();
        }
        return instancia;
    }

    // . MÉTODO ADICIONAR -> Adiciona um objeto cliente à lista
    public void adicionar(Cliente cliente) {
        clientes.add(cliente);
    }

    // . MÉTODO REMOVER -> Remove um objeto cliente da lista
    public void remover(Cliente c) {
        clientes.remove(c);
    }

    // . MÉTODO LISTAR -> Retorna a lista de clientes
    public List<Cliente> listar() {
        return clientes;
    }

    // . MÉTODO ATUALIZAR -> Recebe o objeto a ser atualizado, e os novos atributos
    // . atualiza utilizando os setters
    public void atualizar(Cliente c, String nomeNovo, String cpf, LocalDate dataNascimento, String telefone) {
        c.setNome(nomeNovo);
        c.setCpf(cpf);
        c.setDataNascimento(dataNascimento);
        c.setTelefone(telefone);
    }
}
