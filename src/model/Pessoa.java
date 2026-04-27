package model;
import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;

    //. CONSTRUTOR -> Permite que seja criado um objeto Pessoa (pode ser usado em classes que herdam de Pessoa)
    //. Protected garante que só subclasses (Cliente, Funcionario) ou classes do mesmo package possam instanciá-lo
    protected Pessoa(String nome, String cpf, LocalDate dataNascimento, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

   //. GETTERS - > Permite que sejam acessados os atributos privados de um objeto Pessoa (ou classes que herdam de Pessoa)
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    //. SETTERS -> Permitem alterar os atributos privados de um objeto Pessoa (e de classes que herdam de Pessoa)
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
