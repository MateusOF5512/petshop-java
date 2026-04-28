package util;
import java.time.LocalDate;

import service.ClienteService;
import service.FuncionarioService;
import service.PetService;

// ! PLACEHOLDER — classe auxiliar utilizada apenas para popular o sistema com dados de teste,
// ! facilitando a demonstração e validação das funcionalidades durante o desenvolvimento.

public class Placeholder {
    FuncionarioService funcionarioService = new FuncionarioService();
    ClienteService clienteService = new ClienteService();
    PetService petService = new PetService();

    public void chamarPlaceholder() {
        clienteService.adicionarCliente("Joao Leal", "123.456.789-09",
    LocalDate.of(2000, 7, 1), "(11) 99911-9999");

    clienteService.adicionarCliente("Mateus Ortiz", "987.654.321-00",
        LocalDate.of(2000, 4, 1), "(12) 99922-9999");

    clienteService.adicionarCliente("Pedro Henrique", "456.123.789-10",
        LocalDate.of(2000, 3, 1), "(13) 99933-9999");

    clienteService.adicionarCliente("Gabriel Alves", "741.852.963-20",
        LocalDate.of(2000, 2, 1), "(14) 99944-9999");

    clienteService.adicionarCliente("Daniel Silva", "159.357.486-30",
        LocalDate.of(2000, 2, 1), "(14) 99955-9999");

    funcionarioService.adicionarFuncionario("Fernanda Alves", "321.654.987-40",
        LocalDate.of(1992, 7, 8), "(48) 98822-3344", "Gerente");

    funcionarioService.adicionarFuncionario("Taísa", "654.987.123-50",
        LocalDate.of(1992, 7, 8), "(48) 97733-4455", "Banho e Tosa");

    funcionarioService.adicionarFuncionario("Thiago Ferreira", "789.123.456-60",
        LocalDate.of(1992, 7, 8), "(48) 96644-5566", "Atendente");
    
    petService.adicionarPet("Maju", "1", "Cachorro", "Pinscher", 
        2022, 6, clienteService.buscarCliente("123.456.789-09"));

    petService.adicionarPet("Thor", "2", "Cachorro", "Pitbull", 
        2018, 14, clienteService.buscarCliente("159.357.486-30"));
    }
}
