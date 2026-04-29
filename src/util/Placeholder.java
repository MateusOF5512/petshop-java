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

        clienteService.adicionarCliente("Joao Leal", "12345678909",
                LocalDate.of(2000, 7, 1), "11999119999");

        clienteService.adicionarCliente("Mateus Ortiz", "98765432100",
                LocalDate.of(2000, 4, 1), "12999229999");

        clienteService.adicionarCliente("Pedro Henrique", "45612378910",
                LocalDate.of(2000, 3, 1), "13999339999");

        clienteService.adicionarCliente("Gabriel Alves", "74185296320",
                LocalDate.of(2000, 2, 1), "14999449999");

        clienteService.adicionarCliente("Daniel Silva", "15935748630",
                LocalDate.of(2000, 2, 1), "14999559999");

        funcionarioService.adicionarFuncionario("Fernanda Alves", "32165498740",
                LocalDate.of(1992, 7, 8), "48988223344", "Gerente");

        funcionarioService.adicionarFuncionario("Taísa", "65498712350",
                LocalDate.of(1992, 7, 8), "48977334455", "Banho e Tosa");

        funcionarioService.adicionarFuncionario("Thiago Ferreira", "78912345660",
                LocalDate.of(1992, 7, 8), "48966445566", "Atendente");

            petService.adicionarPet("Rex", "01", "Cachorro", "Labrador",
                2020, 28.5, clienteService.buscarCliente("12345678909"));

        petService.adicionarPet("Mimi", "02", "Gato", "Siamês",
                2021, 4.2, clienteService.buscarCliente("98765432100"));

        petService.adicionarPet("Thor", "03", "Cachorro", "Pinscher",
                2019, 6.8, clienteService.buscarCliente("45612378910"));

        petService.adicionarPet("Luna", "04", "Gato", "Persa",
                2022, 3.9, clienteService.buscarCliente("74185296320"));

        petService.adicionarPet("Bob", "05", "Cachorro", "Poodle",
                2018, 9.4, clienteService.buscarCliente("15935748630"));

        petService.adicionarPet("Mel", "06", "Cachorro", "Shih Tzu",
                2023, 5.1, clienteService.buscarCliente("12345678909"));

        petService.adicionarPet("Nina", "07", "Gato", "Vira-lata",
                2020, 4.7, clienteService.buscarCliente("98765432100"));
    }

}