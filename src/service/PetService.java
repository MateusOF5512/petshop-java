package service;

import repository.PetRepository;
import model.Pet;
import model.Cliente;

public class PetService {

    // . Criação de um repositório
    private PetRepository repositorioPets = PetRepository.getInstance();


    // . ADICIONAR PET
    public void adicionarPet(String nome, String codigo, String animal, String raca,
            int anoNascimento, double peso, Cliente dono) {

        Pet pet = new Pet(nome, codigo, animal, raca, anoNascimento, peso, dono);
        repositorioPets.adicionar(pet);
    }


    // . LISTAR PETS
    public void listarPets() {

        int contador = 1;

        System.out.println("\n".repeat(2));
        System.out.println("LISTA DE PETS");

        if (repositorioPets.listar().isEmpty()) {
            throw new RuntimeException("[INFO] Nenhum pet cadastrado.");
        }

        for (Pet p : repositorioPets.listar()) {
            System.out.println(contador + " - " + p.getNome() + " (" + p.getCodigo() + ") - "
                    + p.getAnimal() + ", " + p.getRaca() + ", "
                    + p.getAnoNascimento() + ", " + p.getPeso() + " kg"
                    + " | Dono: " + p.getDono().getNome());
            contador++;
        }
    }


    // . BUSCAR PET POR CODIGO
    public Pet buscarPet(String codigo) {

        for (Pet p : repositorioPets.listar()) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }

        throw new RuntimeException("[INFO] Pet não encontrado.");
    }


    // . REMOVER PET
    public void excluirPet(String codigo) {

        Pet pet = buscarPet(codigo);
        repositorioPets.remover(pet);
    }


    // . ATUALIZAR PET
    public void atualizarPet(String codigo, String nomeNovo, String codigoNovo, String animal,
            String raca, int anoNascimento, double peso, Cliente dono) {

        Pet pet = buscarPet(codigo);
        repositorioPets.atualizar(pet, nomeNovo, codigoNovo, animal, raca, anoNascimento, peso, dono);
    }

}