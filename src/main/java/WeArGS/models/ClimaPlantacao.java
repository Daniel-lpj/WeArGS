package WeArGS.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Long clima_plantacao_id;

    @JsonProperty(value = "usuario_id", access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private Long usuario_id;

    @NotBlank
    @Size(min = 5, max = 45)
    private String regiao;

    @NotBlank
    @Size(min = 5, max = 45)
    private String clima;

    @NotNull
    private Long temperatura;

    @NotNull
    private Long horas_sol;

    @NotNull
    private Long umidade;

    @NotNull
    private Long precipitacao;


}
