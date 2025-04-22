package br.edu.academus.resource;

import br.edu.academus.domain.Disciplina;
import br.edu.academus.repository.DisciplinaRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/disciplinas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DisciplinaResource {

    @Inject
    DisciplinaRepository repository;

    @GET
    public List<Disciplina> listarTodas() {
        return repository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        Disciplina disciplina = repository.findById(id);
        if (disciplina == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(disciplina).build();
    }

    @POST
    @Transactional
    public Response criar(Disciplina disciplina) {
        repository.persist(disciplina);
        return Response.status(Response.Status.CREATED).entity(disciplina).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizar(@PathParam("id") Long id, Disciplina nova) {
        Disciplina disciplina = repository.findById(id);
        if (disciplina == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        disciplina.setNome(nova.getNome());
        disciplina.setDescricao(nova.getDescricao());
        disciplina.setProfessor(nova.getProfessor());
        disciplina.setCurso(nova.getCurso());
        return Response.ok(disciplina).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletar(@PathParam("id") Long id) {
        boolean removido = repository.deleteById(id);
        return removido
                ? Response.noContent().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }
}
