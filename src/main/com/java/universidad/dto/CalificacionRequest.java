package universidad.dto;

import lombok.Data;

@Data
public class CalificacionRequest {

    private String idEstudiante;
    private String codigoCurso;
    private Double nota;
}