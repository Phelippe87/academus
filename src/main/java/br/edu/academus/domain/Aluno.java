package br.edu.academus.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Aluno extends Usuario {

    @ManyToMany(mappedBy = "alunos")
    private List<Curso> cursos;

    // Getters e Setters
    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
