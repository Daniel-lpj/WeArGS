package WeArGS.repository;

import WeArGS.models.ClimaPlantacao;

import java.util.List;
import java.util.Optional;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClimaPlantacaoRepository extends JpaRepository<ClimaPlantacao, Long> {

    Page<ClimaPlantacao> findByDescricaoContaining(String descricao, Pageable pageable);
    
    @Query("SELECT c FROM ClimaPlantacao c")
    List<ClimaPlantacao> getAllClimaPlantacao();

    @Query("SELECT c FROM ClimaPlantacao c WHERE c.clima_plantacao_id = :clima_plantacao_id")
    Optional<ClimaPlantacao> getClimPlantacaoById(long clima_plantacao_id);

    @Query("SELECT c FROM ClimaPlantacao c WHERE c.clima = 'tropical'")
    String getClimaPlantacaoByClima(String clima);

}
