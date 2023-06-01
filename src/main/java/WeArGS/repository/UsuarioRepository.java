package WeArGS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import WeArGS.models.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String username);

}
