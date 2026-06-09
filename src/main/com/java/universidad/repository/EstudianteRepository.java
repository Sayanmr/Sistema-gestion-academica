package universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import universidad.entity.Estudiante;

public interface EstudianteRepository
        extends JpaRepository<Estudiante, String> {
}