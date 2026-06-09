package universidad.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_estudiantes")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "codigo_cursos")
    private Curso curso;

    private LocalDateTime fechaMatricula;
}