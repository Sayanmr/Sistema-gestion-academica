package universidad.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalificacionDetalleDTO {

    private String estudiante;
    private String curso;
    private Double nota;
}