package service;

import repository.PetRepository;
import model.Pet;

public class PetService {

    // . Criação de um repositório
    private PetRepository repositorioPets = PetRepository.getInstance();

    // . ADICIONAR PET
    public void adicionarPet(String nome, String codigo, String animal, String raca, int anoNascimento,
            double peso) {
        Pet pet = new Pet(nome, codigo, animal, raca, anoNascimento, peso);
        repositorioPets.adicionar(pet);
    }

    // . LISTAR PETS
    public void listarPets() {
        int contador = 1;
        System.out.println("\n".repeat(2));
        System.out.println("LISTA DE PETS");

        if (repositorioPets.listar().isEmpty()) {
            throw new RuntimeException("[INFO] Nenhum pet cadastrado.");
        } else {
            for (Pet p : repositorioPets.listar()) {
                System.out.println(contador + " - " + p.getNome() + "(" + p.getCodigo() + ")" + " - " + p.getAnimal()
                        + ", " + p.getRaca() + ", " +
                        p.getAnoNascimento() + ", " + p.getPeso() + " kg");
                contador++;
            }
        }
    }

    // . REMOVER PET
    public void excluirPet(String codigo) {
        boolean removido = false;

        for (Pet p : repositorioPets.listar()) {
            if (p.getCodigo().equals(codigo)) {
                repositorioPets.remover(p);
                removido = true;
                break;
            }
        }
        if (!removido) {
            throw new RuntimeException("[INFO] Pet não encontrado! Tente novamente.");
        }
    }

    // . ATUALIZAR PET
    public void atualizarPet(String codigo, String nomeNovo, String codigoNovo, String animal, String raca,
            int anoNascimento, double peso) {
        boolean encontrado = false;
        for (Pet p : repositorioPets.listar()) {
            if (p.getCodigo().equals(codigo)) {
                repositorioPets.atualizar(p, nomeNovo, codigoNovo, animal, raca, anoNascimento, peso);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            throw new RuntimeException("[INFO] Pet não encontrado! Nenhuma informação foi alterada.");
        }
    }
}