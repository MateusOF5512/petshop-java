package model;

public class Pet {
    private String nome;
    private String codigo;
    private String animal;
    private String raca;
    private int anoNascimento;
    private double peso;

    // . CONSTRUTOR
    public Pet(String nome, String codigo, String animal, String raca, int anoNascimento, double peso) {
        this.nome = nome;
        this.codigo = codigo;
        this.animal = animal;
        this.raca = raca;
        this.anoNascimento = anoNascimento;
        this.peso = peso;
    }

    // . GETTERS
    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getAnimal() {
        return animal;
    }

    public String getRaca() {
        return raca;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public double getPeso() {
        return peso;
    }

    // . SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setAnoNascimento(int dataNascimento) {
        this.anoNascimento = dataNascimento;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}