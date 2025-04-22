package br.edu.academus.repository;

import br.edu.academus.domain.Usuario;
import br.edu.academus.domain.enums.Perfil;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    public List<Usuario> listarPorPerfil(Perfil perfil) {
        return find("perfil", perfil).list();
    }

    public Usuario buscarPorIdEPerfil(Long id, Perfil perfil) {
        return find("id = ?1 and perfil = ?2", id, perfil).firstResult();
    }
}
