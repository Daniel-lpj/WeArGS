package WeArGS.repository;

import WeArGS.models.Sementes;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SementeRepository extends JpaRepository<Sementes, Long> {
    static Page<Sementes> findAll(Specification<Sementes> specs, Pageable pageable) {
        return null;
    }

    @Query("SELECT s FROM Sementes s")
    List<Sementes> getAllSementes();

    @Query("SELECT s FROM Sementes s WHERE s.semente_id = :semente_id")
    Optional<Sementes> getSementeById(long semente_id);

    @Query("SELECT s FROM Sementes s WHERE s.tipo_semente = 'fruta'")
    String getSementeByTipo(String tipo_semente);


}
