package WeArGS.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class ClimaPlantacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clima_plantacao_id", insertable = false, updatable = false)
    private Long clima_plantacao_id;

    @NotBlank
    @Column(name="regiao", nullable = false)
    @Size(min = 5, max = 45)
    private String regiao;

    @NotBlank
    @Column(name="clima", nullable = false)
    @Size(min = 5, max = 45)
    private String clima;

    @Column(name="temperatura", nullable = false)
    private Long temperatura;

    @Column(name="horas_sol", nullable = false)
    private Long horas_sol;

    @Column(name="umidade", nullable = false)
    private Long umidade;

    @Column(name="precipitacao", nullable = false)
    private Long precipitacao;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
}
