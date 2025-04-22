package br.edu.academus.resource;

import br.edu.academus.domain.Usuario;
import br.edu.academus.domain.enums.Perfil;
import br.edu.academus.repository.UsuarioRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/professores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfessorResource {

    @Inject
    UsuarioRepository repository;

    @GET
    public List<Usuario> listar() {
        return repository.listarPorPerfil(Perfil.PROFESSOR);
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        Usuario usuario = repository.buscarPorIdEPerfil(id, Perfil.PROFESSOR);
        if (usuario == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(usuario).build();
    }

    @POST
    @Transactional
    public Response criar(Usuario usuario) {
        usuario.setPerfil(Perfil.PROFESSOR);
        repository.persist(usuario);
        return Response.status(Response.Status.CREATED).entity(usuario).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletar(@PathParam("id") Long id) {
        Usuario usuario = repository.buscarPorIdEPerfil(id, Perfil.PROFESSOR);
        if (usuario == null) return Response.status(Response.Status.NOT_FOUND).build();
        repository.delete(usuario);
        return Response.noContent().build();
    }
}
