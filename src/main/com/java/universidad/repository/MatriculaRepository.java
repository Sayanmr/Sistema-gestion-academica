package universidad.repository;

import universidad.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository
        extends JpaRepository<Matricula,Integer> {
}