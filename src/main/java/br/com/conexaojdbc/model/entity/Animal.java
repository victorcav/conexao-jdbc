package br.com.conexaojdbc.model.entity;

// Calsse do padrao de projeto JAVABEAN:
public class Animal {

    private String nome;
    private String especie;
    protected int idade;
    protected String sexo;

    public Animal() {
    }

    public Animal(String nome, String especie, int idade, String sexo) {
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return this.especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return this.sexo;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", idade=" + idade +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
