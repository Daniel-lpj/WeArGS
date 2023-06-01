package WeArGS.models;

import WeArGS.controllers.SementesController;
import WeArGS.controllers.SoloController;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


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

    @NotNull
    @ManyToOne
    private Sementes semente;

    public EntityModel<Solo> toModel(){
        return EntityModel.of(
                this,
                linkTo(methodOn(SoloController.class).show(solo_id)).withSelfRel(),
                linkTo(methodOn(SoloController.class).destroy(solo_id)).withRel("delete"),
                linkTo(methodOn(SoloController.class).index(null, Pageable.unpaged())).withRel("all"),
                linkTo(methodOn(SementesController.class).show(this.getSemente().getSemente_id())).withRel("roupa")
        );
    }


}
