package universidad.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Estudiante {

    @Id
    private String id;

    private String nombre;

    private String carrera;
}