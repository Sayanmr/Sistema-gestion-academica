package universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import universidad.entity.Matricula;

public interface MatriculaRepository
        extends JpaRepository<Matricula, Integer> {

    boolean existsByEstudianteIdAndCursoCodigo(
            String estudianteId,
            String cursoCodigo);
}