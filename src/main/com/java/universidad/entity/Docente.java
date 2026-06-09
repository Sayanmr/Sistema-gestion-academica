package universidad.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "docentes")
public class Docente {

    @Id
    @Column(name = "num_empleado")
    private String numEmpleado;

    private String nombre;

    private String facultad;
}