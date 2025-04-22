package br.edu.academus.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class MatrizCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Curso curso;

    @OneToMany
    private List<Disciplina> disciplinas;

    // Getters e setters
}
