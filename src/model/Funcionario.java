package model;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private String cargo;

    //. CONSTRUTOR
    public Funcionario(String nome, String cpf, LocalDate dataNascimento, String telefone, String cargo) {
        super(nome, cpf, dataNascimento, telefone);
        this.cargo = cargo;
    }

    //. GETTERS
    public String getCargo() {
        return cargo;
    }

    //. SETTERS
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
