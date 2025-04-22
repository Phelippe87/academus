package br.edu.academus.domain;

import jakarta.persistence.*;

@Entity
public class MatriculaDisciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Disciplina disciplina;

    private String semestre; // opcional, mas útil

    // Getters e setters
}
