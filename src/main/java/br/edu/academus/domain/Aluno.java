package br.edu.academus.domain;

public class Aluno {

    private Long id;
    private String nome;

    // Construtor vazio
    public Aluno() {}

    // Construtor completo
    public Aluno(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
