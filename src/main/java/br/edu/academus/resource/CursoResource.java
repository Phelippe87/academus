package br.edu.academus.resource;

import br.edu.academus.domain.Curso;
import br.edu.academus.repository.CursoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/cursos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CursoResource {

    @Inject
    CursoRepository cursoRepository;

    @GET
    public List<Curso> listar() {
        return cursoRepository.listAll();
    }

    @POST
    @Transactional
    public Curso criar(Curso curso) {
        cursoRepository.persist(curso);
        return curso;
    }
}
