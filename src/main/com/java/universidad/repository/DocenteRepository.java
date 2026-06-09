package universidad.repository;

import universidad.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocenteRepository
        extends JpaRepository<Docente, String> {
}