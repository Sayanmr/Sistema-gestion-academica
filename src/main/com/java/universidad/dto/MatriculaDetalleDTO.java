package universidad.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class MatriculaDetalleDTO {

    private String estudiante;
    private String curso;
    private LocalDateTime fechaMatricula;
}