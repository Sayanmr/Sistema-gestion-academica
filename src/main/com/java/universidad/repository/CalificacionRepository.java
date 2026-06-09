package universidad.repository;

import universidad.dto.CalificacionDetalleDTO;
import universidad.entity.Calificacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CalificacionRepository
        extends JpaRepository<Calificacion, Integer> {

    @Query("""
        SELECT new universidad.dto.CalificacionDetalleDTO(
            c.estudiante.nombre,
            c.curso.nombre,
            c.nota
        )
        FROM Calificacion c
    """)
    List<CalificacionDetalleDTO> obtenerDetalle();

    @Query("""
        SELECT AVG(c.nota)
        FROM Calificacion c
        WHERE c.estudiante.id = :idEstudiante
    """)
    Double promedioEstudiante(String idEstudiante);


}