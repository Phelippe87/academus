package br.edu.academus.repository;

import br.edu.academus.domain.Aluno;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AlunoRepository {

    private final List<Aluno> alunos = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Aluno> listarTodos() {
        return alunos;
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return alunos.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    public Aluno salvar(Aluno aluno) {
        aluno.setId(idCounter++);
        alunos.add(aluno);
        return aluno;
    }

    public boolean deletar(Long id) {
        return alunos.removeIf(a -> a.getId().equals(id));
    }
}
