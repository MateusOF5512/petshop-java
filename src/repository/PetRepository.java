package repository;

import model.Pet;
import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class PetRepository {

    // . Lista que simula o banco de dados
    private List<Pet> pets = new ArrayList<>();

    // . Criação de uma instância única do repositório (SINGLETON)
    private static PetRepository instancia;


    // . CONSTRUTOR PRIVADO -> Impede que outras classes criem um novo repositório
    private PetRepository() {}


    // . Ao ser utilizado, cria um repositório e o retorna, caso contrário, retorna o
    // . repositório criado anteriormente
    public static PetRepository getInstance() {

        if (instancia == null) {
            instancia = new PetRepository();
        }

        return instancia;
    }


    // . MÉTODO ADICIONAR -> Adiciona um objeto pet à lista
    public void adicionar(Pet pet) {
        pets.add(pet);
    }


    // . MÉTODO REMOVER -> Remove um objeto pet da lista
    public void remover(Pet p) {
        pets.remove(p);
    }


    // . MÉTODO LISTAR -> Retorna a lista de pets
    public List<Pet> listar() {
        return pets;
    }


    // . MÉTODO ATUALIZAR -> Recebe o objeto a ser atualizado e os novos atributos
    // . e atualiza utilizando os setters
    public void atualizar(Pet p, String nomeNovo, String codigo, String animal, String raca,
            int anoNascimento, double peso, Cliente dono) {
        p.setNome(nomeNovo);
        p.setCodigo(codigo);
        p.setAnimal(animal);
        p.setRaca(raca);
        p.setAnoNascimento(anoNascimento);
        p.setPeso(peso);
        p.setDono(dono);
    }

}