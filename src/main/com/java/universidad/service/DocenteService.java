package universidad.service;

import universidad.entity.Docente;
import universidad.repository.DocenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteService {

    private final DocenteRepository repository;

    public DocenteService(DocenteRepository repository) {
        this.repository = repository;
    }

    public List<Docente> listar() {
        return repository.findAll();
    }

    public Docente guardar(Docente docente) {
        return repository.save(docente);
    }

    public void eliminar(String numEmpleado) {
        repository.deleteById(numEmpleado);
    }

    public Docente buscarPorId(String numEmpleado) {
        return repository.findById(numEmpleado)
                .orElseThrow(() ->
                        new RuntimeException("Docente no encontrado"));
    }
}