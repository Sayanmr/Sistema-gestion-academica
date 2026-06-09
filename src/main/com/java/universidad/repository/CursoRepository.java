package universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import universidad.entity.Curso;

public interface CursoRepository
        extends JpaRepository<Curso, String> {
}