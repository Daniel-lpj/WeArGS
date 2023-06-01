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
public class Sementes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long semente_id;

    @JsonProperty(value = "solo_id", access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private Long solo_id;

    @NotNull
    private Long clima_plantacao_id;

    @NotBlank
    @Size(min = 5, max = 100)
    private String descricao;

    @NotBlank
    @Size(min = 5, max = 100)
    private String tipo_semente;

    @NotBlank
    @Size(min = 5, max = 45)
    private String epoca_plantio;

    @NotBlank
    @Size(min = 5, max = 100)
    private String regiao;

    @NotBlank
    @Size(min = 5, max = 100)
    private String condicoes_solo;

    @NotBlank
    @Size(min = 5, max = 45)
    private String requisito_luz;

    @NotBlank
    @Size(min = 5, max = 45)
    private String requisito_agua;

    @NotBlank
    @Size(min = 5, max = 150)
    private String resistencia;

    @NotBlank
    @Size(min = 5, max = 100)
    private String inicio_colheita;

}
