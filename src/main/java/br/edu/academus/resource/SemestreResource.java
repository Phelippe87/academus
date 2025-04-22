package br.edu.academus.resource;

import br.edu.academus.domain.Semestre;
import br.edu.academus.repository.SemestreRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/semestres")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SemestreResource {

    @Inject
    SemestreRepository repository;

    @GET
    public List<Semestre> listarTodos() {
        return repository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        Semestre semestre = repository.findById(id);
        if (semestre == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(semestre).build();
    }

    @POST
    @Transactional
    public Response criar(Semestre semestre) {
        repository.persist(semestre);
        return Response.status(Response.Status.CREATED).entity(semestre).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizar(@PathParam("id") Long id, Semestre semestreAtualizado) {
        Semestre semestre = repository.findById(id);
        if (semestre == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        semestre.setAno(semestreAtualizado.getAno());
        semestre.setNumero(semestreAtualizado.getNumero());
        semestre.setCurso(semestreAtualizado.getCurso());
        return Response.ok(semestre).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletar(@PathParam("id") Long id) {
        boolean removido = repository.deleteById(id);
        return removido ? Response.noContent().build() : Response.status(Response.Status.NOT_FOUND).build();
    }
}
