package model;
import java.time.LocalDate;

public class Cliente extends Pessoa {

    //. CONSTRUTOR -> Utiliza o super para reaprovar o construtor da classe Pessoa
    public Cliente(String nome, String cpf, LocalDate dataNascimento, String telefone) {
        super(nome, cpf, dataNascimento, telefone);
    }
}