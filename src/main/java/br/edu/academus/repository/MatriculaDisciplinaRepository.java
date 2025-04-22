package br.edu.academus.repository;

import br.edu.academus.domain.MatriculaDisciplina;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MatriculaDisciplinaRepository implements PanacheRepository<MatriculaDisciplina> {
}
