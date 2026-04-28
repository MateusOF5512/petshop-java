package repository;

import model.Pet;
import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class PetRepository {

    private List<Pet> pets = new ArrayList<>();
    private static PetRepository instancia;

    private PetRepository() {
    }

    // . MÉTODO GETINSTANCE
    public static PetRepository getInstance() {
        if (instancia == null) {
            instancia = new PetRepository();
        }
        return instancia;
    }

    // . MÉTODO ADICIONAR
    public void adicionar(Pet pet) {
        pets.add(pet);
    }

    // . MÉTODO REMOVER
    public void remover(Pet p) {
        pets.remove(p);
    }

    // . MÉTODO LISTAR
    public List<Pet> listar() {
        return pets;
    }

    // . MÉTODO ATUALIZAR
    public void atualizar(Pet p, String nomeNovo, String codigo, String animal, String raca, int anoNascimento,
            double peso, Cliente dono) {
        p.setNome(nomeNovo);
        p.setCodigo(codigo);
        p.setAnimal(animal);
        p.setRaca(raca);
        p.setAnoNascimento(anoNascimento);
        p.setPeso(peso);
        p.setDono(dono);
    }
}