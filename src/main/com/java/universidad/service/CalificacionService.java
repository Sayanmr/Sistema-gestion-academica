package universidad.service;

import universidad.dto.CalificacionRequest;
import universidad.entity.Calificacion;
import universidad.entity.Curso;
import universidad.entity.Estudiante;
import universidad.repository.CalificacionRepository;
import universidad.repository.CursoRepository;
import universidad.repository.EstudianteRepository;
import org.springframework.stereotype.Service;
import universidad.dto.CalificacionDetalleDTO;

import java.util.List;

@Service
public class CalificacionService {

    private final CalificacionRepository repository;
    private final EstudianteRepository estudianteRepository;
    private final CursoRepository cursoRepository;

    public CalificacionService(
            CalificacionRepository repository,
            EstudianteRepository estudianteRepository,
            CursoRepository cursoRepository) {

        this.repository = repository;
        this.estudianteRepository = estudianteRepository;
        this.cursoRepository = cursoRepository;
    }

    public List<Calificacion> listar() {
        return repository.findAll();
    }

    public Calificacion buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Calificación no encontrada"));
    }

    public Calificacion guardar(CalificacionRequest request) {

        Estudiante estudiante =
                estudianteRepository.findById(request.getIdEstudiante())
                        .orElseThrow(() ->
                                new RuntimeException("Estudiante no encontrado"));

        Curso curso =
                cursoRepository.findById(request.getCodigoCurso())
                        .orElseThrow(() ->
                                new RuntimeException("Curso no encontrado"));

        Calificacion calificacion = new Calificacion();

        calificacion.setEstudiante(estudiante);
        calificacion.setCurso(curso);
        calificacion.setNota(request.getNota());

        return repository.save(calificacion);
    }

    public Calificacion actualizar(
            Integer id,
            CalificacionRequest request) {

        Calificacion existente = buscarPorId(id);

        existente.setNota(request.getNota());

        return repository.save(existente);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
    public List<CalificacionDetalleDTO> detalle() {

        return repository.obtenerDetalle();
    }

    public Double promedioEstudiante(String idEstudiante) {

        Double promedio =
                repository.promedioEstudiante(idEstudiante);

        return promedio == null ? 0.0 : promedio;
    }
}