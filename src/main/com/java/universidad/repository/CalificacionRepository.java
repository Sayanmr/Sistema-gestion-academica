package universidad.repository;

import universidad.entity.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalificacionRepository
        extends JpaRepository<Calificacion, Integer> {
}