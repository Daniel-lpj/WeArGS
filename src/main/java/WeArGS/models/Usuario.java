package WeArGS.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuario_id;

    @NotBlank
    @Size(min = 5, max = 45)
    private String nome_usuario;

    @NotBlank
    @Size(min = 5, max = 45)
    private String email_usuario;

    @NotBlank
    @Size(min = 5, max = 45)
    private String senha_usuario;

    @NotBlank
    private Date data_criacao;

    @NotBlank
    private Date data_alteracao;

}
