package WeArGS.repository;

import WeArGS.models.Sementes;
import WeArGS.models.Solo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoloRepository extends JpaRepository<Solo, Long> {

    Page<Solo> findByDescricaoContaining(String descricao, Pageable pageable);

}
