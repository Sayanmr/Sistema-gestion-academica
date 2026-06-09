package universidad.repository;

import universidad.dto.MatriculaDetalleDTO;
import universidad.entity.Curso;
import universidad.entity.Matricula;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatriculaRepository
        extends JpaRepository<Matricula, Integer> {

    boolean existsByEstudianteIdAndCursoCodigo(
            String estudianteId,
            String cursoCodigo);

    @Query("""
        SELECT new universidad.dto.MatriculaDetalleDTO(
            m.estudiante.nombre,
            m.curso.nombre,
            m.fechaMatricula
        )
        FROM Matricula m
    """)
    List<MatriculaDetalleDTO> obtenerDetalle();

    @Query("""
        SELECT m.curso
        FROM Matricula m
        WHERE m.estudiante.id = :idEstudiante
    """)
    List<Curso> cursosDeEstudiante(String idEstudiante);

}