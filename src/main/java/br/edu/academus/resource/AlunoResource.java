package br.edu.academus.resource;

import br.edu.academus.domain.Aluno;
import br.edu.academus.repository.AlunoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/alunos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlunoResource {

    @Inject
    AlunoRepository repository;

    @GET
    public List<Aluno> listar() {
        return repository.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        return repository.buscarPorId(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @POST
    public Response criar(Aluno aluno) {
        Aluno salvo = repository.salvar(aluno);
        return Response.status(Response.Status.CREATED).entity(salvo).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        boolean removido = repository.deletar(id);
        return removido
                ? Response.noContent().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }
}
