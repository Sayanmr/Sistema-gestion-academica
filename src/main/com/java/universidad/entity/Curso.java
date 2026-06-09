package universidad.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Curso {

    @Id
    private String codigo;

    private String nombre;
}