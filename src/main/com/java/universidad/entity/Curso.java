package universidad.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cursos")
public class Curso {

    @Id
    private String codigo;

    private String nombre;
}