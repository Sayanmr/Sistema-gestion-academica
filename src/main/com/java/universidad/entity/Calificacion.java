package universidad.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "calificaciones")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "codigo_curso")
    private Curso curso;

    private Double nota;
}