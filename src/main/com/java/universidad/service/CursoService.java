package universidad.service;

import universidad.entity.Curso;
import universidad.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public List<Curso> listar() {
        return repository.findAll();
    }

    public Curso guardar(Curso curso) {
        return repository.save(curso);
    }

    public void eliminar(String codigo) {
        repository.deleteById(codigo);
    }

    public Curso buscarPorCodigo(String codigo) {
        return repository.findById(codigo)
                .orElseThrow(() ->
                        new RuntimeException("Curso no encontrado"));
    }
}