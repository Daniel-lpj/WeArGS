package WeArGS.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Sementes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "semente_id", nullable = false)
    private Long semente_id;

    @NotBlank
    @Column(name="descricao", nullable = false)
    @Size(min = 5, max = 100)
    private String descricao;

    @NotBlank
    @Column(name="tipo_semente", nullable = false)
    @Size(min = 5, max = 100)
    private String tipo_semente;

    @NotBlank
    @Column(name="epoca_plantio", nullable = false)
    @Size(min = 5, max = 45)
    private String epoca_plantio;

    @NotBlank
    @Column(name="regiao", nullable = false)
    @Size(min = 5, max = 100)
    private String regiao;

    @NotBlank
    @Column(name="condicoes_solo", nullable = false)
    @Size(min = 5, max = 100)
    private String condicoes_solo;

    @NotBlank
    @Column(name="requisito_luz", nullable = false)
    @Size(min = 5, max = 45)
    private String requisito_luz;

    @NotBlank
    @Column(name="requisito_agua", nullable = false)
    @Size(min = 5, max = 45)
    private String requisito_agua;

    @NotBlank
    @Column(name="resistencia", nullable = false)
    @Size(min = 5, max = 150)
    private String resistencia;

    @NotBlank
    @Column(name="periodo_colheita", nullable = false)
    @Size(min = 5, max = 100)
    private String periodo_colheita;
    
    @OneToOne
    @JoinColumn(name="solo_id")
    private Solo solo;

    @OneToOne
    @JoinColumn(name="clima_plantacao_id")
    private ClimaPlantacao climaPlantacao;

}
