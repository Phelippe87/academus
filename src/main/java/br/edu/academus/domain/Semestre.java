package br.edu.academus.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Semestre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int ano;          // Ex: 2025
    private int numero;       // Ex: 1 para "2025.1", 2 para "2025.2"

    @ManyToOne
    private Curso curso;

    @OneToMany(mappedBy = "semestre")
    private List<Disciplina> disciplinas;

    // Getters e setters

    public String getDescricaoCompleta() {
        return ano + "." + numero; // Ex: 2025.1
    }
}
