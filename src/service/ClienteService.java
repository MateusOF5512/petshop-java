package service;
import repository.ClienteRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.Cliente;

public class ClienteService {

    //. Criação de um repositório
    private ClienteRepository repositorioClientes = ClienteRepository.getInstance();

    //. ADICIONAR CLIENTE -> Recebe os dados da UI, cria um objeto cliente e adiciona na instância
    public void adicionarCliente(String nome, String cpf, LocalDate dataNascimento, String telefone) {
        Cliente cliente = new Cliente(nome, cpf, dataNascimento, telefone);
        repositorioClientes.adicionar(cliente); }

    //. LISTAR CLIENTES -> Percorre a lista, imprimindo os dados (via getters)
    public void listarClientes() {
        int contador = 1;
        System.out.println("\n".repeat(2));
        System.out.println("LISTA DE CLIENTES");
        if (repositorioClientes.listar().isEmpty()) {
            throw new RuntimeException("[INFO] Nenhum cliente cadastrado.");
        } else {
            for (Cliente c : repositorioClientes.listar()) {
                System.out.println(contador + " - " + c.getNome() + ", " + c.getCpf() + ", "
                        + c.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", "
                        + c.getTelefone());
                contador++;
            }
        }
    }

    //. REMOVER CLIENTE -> Recebe o cpf da UI e remove da instância
    //. se não existir o nome na lista, cria um erro que pode ser capturado na UI
    public void excluirCliente(String cpf) {
        //. método remove if retorna um boolean que pode ser armazenado em uma variável
        boolean removido = false;
        for (Cliente c : repositorioClientes.listar()) {
            if (c.getCpf().equals(cpf)) {
                repositorioClientes.remover(c);
                removido = true;
                break; }
        }
        if (!removido) {
            throw new RuntimeException("[INFO] Cliente não encontrado! Tente novamente.");
        }
    }

    //. ATUALIZAR CLIENTE -> Recebe o cpf e os dados novos da UI
    //. tenta atualizar, se o cliente não for encontrado, cria um erro que pode ser capturado na UI
    public void atualizarCliente(String cpf, String nome, String cpfNovo, LocalDate dataNascimento, String telefone) {
        boolean encontrado = false;
        for (Cliente c : repositorioClientes.listar()) {
            if (c.getCpf().equals(cpf)) {
                repositorioClientes.atualizar(c, nome, cpfNovo, dataNascimento, telefone);
                encontrado = true; }
        } if (!encontrado) {
            throw new RuntimeException("[INFO] Cliente nao encontrado! Nenhuma informação foi alterada.");
        }
    }
}
