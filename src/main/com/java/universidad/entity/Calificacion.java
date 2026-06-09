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
    @JoinColumn(name = "id_estudiantes")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "codigo_cursos")
    private Curso curso;

    private Double nota;
}