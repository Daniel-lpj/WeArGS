package WeArGS.repository;

import WeArGS.models.Sementes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SementeRepository extends JpaRepository<Sementes, Long> {
    static Page<Sementes> findAll(Specification<Sementes> specs, Pageable pageable) {
        return null;
    }


}
