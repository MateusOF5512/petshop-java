package service;

import repository.ClienteRepository;
import repository.PetRepository;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.Cliente;
import model.Pet;

public class ClienteService {

    // . Acessando o repositório de pets para composição (excluir pets ao excluir cliente)
    private PetRepository repositorioPets = PetRepository.getInstance();

    // . Criação de um repositório
    private ClienteRepository repositorioClientes = ClienteRepository.getInstance();


    // . ADICIONAR CLIENTE -> Recebe os dados da UI, cria um objeto cliente e
    // . adiciona na instância
    public void adicionarCliente(String nome, String cpf, LocalDate dataNascimento, String telefone) {

        Cliente cliente = new Cliente(nome, cpf, dataNascimento, telefone);
        repositorioClientes.adicionar(cliente);
    }


    // . LISTAR CLIENTES -> Percorre a lista, imprimindo os dados (via getters)
    public void listarClientes() {

        int contador = 1;

        System.out.println("\n".repeat(2));
        System.out.println("LISTA DE CLIENTES");

        if (repositorioClientes.listar().isEmpty()) {
            throw new RuntimeException("[INFO] Nenhum cliente cadastrado.");
        }

        for (Cliente c : repositorioClientes.listar()) {
            System.out.println(contador + " - " + c.getNome() + ", " + c.getCpf() + ", "
                    + c.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", "
                    + c.getTelefone());
            for (Pet p : repositorioPets.listar()) {
                if (p.getDono().getCpf().equals(c.getCpf())) {
                    System.out.println(" └──" + p.getNome() + " (" + p.getCodigo() + ")");
                }
            }
            contador++;
        }
    }


    // . BUSCAR CLIENTE POR CPF -> Percorre a lista e retorna o cliente encontrado
    // . se não encontrar, lança uma exceção que pode ser capturada na UI
    public Cliente buscarCliente(String cpf) {

        for (Cliente c : repositorioClientes.listar()) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }

        throw new RuntimeException("[INFO] Cliente não encontrado.");
    }


    // . REMOVER CLIENTE -> Busca o cliente pelo CPF, remove seus pets (composição)
    // . e depois o remove da lista. Se não encontrar, lança uma exceção.
    public void excluirCliente(String cpf) {

        Cliente cliente = buscarCliente(cpf);

        // . Itera sobre uma cópia da lista para evitar ConcurrentModificationException ao remover da original
        for (Pet p : new ArrayList<>(repositorioPets.listar())) {
            if (p.getDono().getCpf().equals(cpf)) {
                repositorioPets.remover(p);
            }
        }

        repositorioClientes.remover(cliente);
    }


    // . ATUALIZAR CLIENTE -> Busca o cliente pelo CPF e atualiza seus dados
    // . se não encontrar, lança uma exceção que pode ser capturada na UI
    public void atualizarCliente(String cpf, String nome, String cpfNovo, LocalDate dataNascimento, String telefone) {

        Cliente cliente = buscarCliente(cpf);
        repositorioClientes.atualizar(cliente, nome, cpfNovo, dataNascimento, telefone);
    }

}