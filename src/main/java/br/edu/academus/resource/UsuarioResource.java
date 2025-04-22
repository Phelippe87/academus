package br.edu.academus.resource;

import br.edu.academus.domain.*;
import br.edu.academus.domain.enums.Perfil;
import br.edu.academus.repository.UsuarioRepository;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioRepository repository;

    @GET
    public List<Usuario> listarTodos() {
        return repository.listAll();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        Usuario usuario = repository.findById(id);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(usuario).build();
    }

    @POST
    @Path("/aluno")
    @Transactional
    public Response criarAluno(Aluno aluno) {
        aluno.setPerfil(Perfil.ALUNO);
        repository.persist(aluno);
        return Response.status(Response.Status.CREATED).entity(aluno).build();
    }

    @POST
    @Path("/professor")
    @Transactional
    public Response criarProfessor(Professor professor) {
        professor.setPerfil(Perfil.PROFESSOR);
        repository.persist(professor);
        return Response.status(Response.Status.CREATED).entity(professor).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletar(@PathParam("id") Long id) {
        Usuario usuario = repository.findById(id);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        repository.delete(usuario);
        return Response.noContent().build();
    }
}
