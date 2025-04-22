package br.edu.academus.domain;

import jakarta.persistence.*;

@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @ManyToOne
    private Professor professor;

    @ManyToOne
    private Curso curso;

    // Getters e setters
}
