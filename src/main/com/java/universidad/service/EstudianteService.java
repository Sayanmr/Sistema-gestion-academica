package universidad.service;

import universidad.dto.EstudianteDTO;
import universidad.entity.Estudiante;
import universidad.exception.EstudianteDuplicadoException;
import universidad.repository.EstudianteRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {

        this.repository = repository;
    }

    public List<EstudianteDTO> listar() {

        return repository.findAll()
                .stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    public EstudianteDTO guardar(EstudianteDTO dto) {

        if (repository.existsById(dto.getId())) {

            throw new EstudianteDuplicadoException(
                    "Ya existe un estudiante con ID "
                            + dto.getId());
        }

        Estudiante estudiante = convertirEntidad(dto);

        repository.save(estudiante);

        return dto;
    }

    public void eliminar(String id) {
        repository.deleteById(id);
    }

    private Estudiante convertirEntidad(EstudianteDTO dto) {

        Estudiante estudiante = new Estudiante();

        estudiante.setId(dto.getId());
        estudiante.setNombre(dto.getNombre());
        estudiante.setCarrera(dto.getCarrera());

        return estudiante;
    }

    private EstudianteDTO convertirDTO(Estudiante estudiante) {

        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(estudiante.getId());
        dto.setNombre(estudiante.getNombre());
        dto.setCarrera(estudiante.getCarrera());

        return dto;
    }
    public EstudianteDTO buscarPorId(String id) {

        Estudiante estudiante = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Estudiante no encontrado"));

        EstudianteDTO dto = new EstudianteDTO();

        dto.setId(estudiante.getId());
        dto.setNombre(estudiante.getNombre());
        dto.setCarrera(estudiante.getCarrera());

        return dto;
    }
}