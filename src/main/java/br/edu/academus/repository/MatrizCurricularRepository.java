package br.edu.academus.repository;

import br.edu.academus.domain.MatrizCurricular;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MatrizCurricularRepository implements PanacheRepository<MatrizCurricular> {
}
