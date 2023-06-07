package WeArGS.repository;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import WeArGS.models.Usuario;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Page<Usuario> findByDescricaoContaining(String descricao, Pageable pageable);

    Optional<Usuario> findByEmail(String username);
    
    @Query("SELECT u FROM Usuario u")

    List<Usuario> getAllUsuario();

    @Query("SELECT u FROM Usuario u WHERE u.usuario_id = :usuario_id")
    Optional<Usuario> getUsuarioById(long usuario_id);

    @Query("SELECT u FROM Usuario u WHERE u.nome_usuario = :nome_usuario")
    String getUsuarioByName(String nome_usuario);
}

