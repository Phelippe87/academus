package br.edu.academus.resource;

import br.edu.academus.domain.MatriculaDisciplina;
import br.edu.academus.repository.MatriculaDisciplinaRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/matriculas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MatriculaDisciplinaResource {

    @Inject
    MatriculaDisciplinaRepository repository;

    @GET
    public List<MatriculaDisciplina> listarTodas() {
        return repository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        MatriculaDisciplina matricula = repository.findById(id);
        if (matricula == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(matricula).build();
    }

    @POST
    @Transactional
    public Response criar(MatriculaDisciplina matricula) {
        repository.persist(matricula);
        return Response.status(Response.Status.CREATED).entity(matricula).build();
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
