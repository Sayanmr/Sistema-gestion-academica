package universidad.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    private String id;

    private String nombre;

    private String carrera;
}