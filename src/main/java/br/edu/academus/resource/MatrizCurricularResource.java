package br.edu.academus.resource;

import br.edu.academus.domain.MatrizCurricular;
import br.edu.academus.repository.MatrizCurricularRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/matrizes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MatrizCurricularResource {

    @Inject
    MatrizCurricularRepository repository;

    @GET
    public List<MatrizCurricular> listarTodas() {
        return repository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        MatrizCurricular matriz = repository.findById(id);
        if (matriz == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(matriz).build();
    }

    @POST
    @Transactional
    public Response criar(MatrizCurricular matriz) {
        repository.persist(matriz);
        return Response.status(Response.Status.CREATED).entity(matriz).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizar(@PathParam("id") Long id, MatrizCurricular novaMatriz) {
        MatrizCurricular matriz = repository.findById(id);
        if (matriz == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        matriz.setNome(novaMatriz.getNome());
        matriz.setCurso(novaMatriz.getCurso());
        matriz.setDisciplinas(novaMatriz.getDisciplinas());

        return Response.ok(matriz).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletar(@PathParam("id") Long id) {
        boolean removido = repository.deleteById(id);
        return removido ? Response.noContent().build() : Response.status(Response.Status.NOT_FOUND).build();
    }
}
