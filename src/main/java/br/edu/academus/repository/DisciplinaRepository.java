package br.edu.academus.repository;

import br.edu.academus.domain.Disciplina;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DisciplinaRepository implements PanacheRepository<Disciplina> {
}
