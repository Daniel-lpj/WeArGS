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
public class Solo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long solo_id;

    @JsonProperty(value = "usuario_id", access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private Long usuario_id;

    @NotBlank
    @Size(min = 5, max = 45)
    private String tipo_solo;

    @NotBlank
    @Size(min = 5, max = 45)
    private String umidade_solo;

    @NotBlank
    @Size(min = 5, max = 45)
    private String ph_solo;

    @NotNull
    private Long materia_organica;

    @NotNull
    private Long nutrientes;

}
