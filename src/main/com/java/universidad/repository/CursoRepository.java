package universidad.repository;

import universidad.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository
        extends JpaRepository<Curso,String> {
}