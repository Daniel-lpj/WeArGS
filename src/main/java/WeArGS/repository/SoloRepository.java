package WeArGS.repository;

import WeArGS.models.Sementes;
import WeArGS.models.Solo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SoloRepository extends JpaRepository<Solo, Long> {

    Page<Solo> findByDescricaoContaining(String descricao, Pageable pageable);
    
    @Query("SELECT s FROM Solo s")
    List<Solo> getAllSolo();

    @Query("SELECT s FROM Solo s WHERE s.solo_id = :solo_id")
    Optional<Solo> getSoloById(long solo_id);

    @Query("SELECT s FROM Solo s WHERE s.tipo_solo = :'alcalino'")
    String getSoloByPh(String tipo_solo);
}
