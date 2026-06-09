package universidad.service;

import universidad.dto.MatriculaDTO;
import universidad.entity.Curso;
import universidad.entity.Estudiante;
import universidad.entity.Matricula;
import universidad.repository.CursoRepository;
import universidad.repository.EstudianteRepository;
import universidad.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final EstudianteRepository estudianteRepository;
    private final CursoRepository cursoRepository;

    public MatriculaService(
            MatriculaRepository matriculaRepository,
            EstudianteRepository estudianteRepository,
            CursoRepository cursoRepository) {

        this.matriculaRepository = matriculaRepository;
        this.estudianteRepository = estudianteRepository;
        this.cursoRepository = cursoRepository;
    }

    public List<Matricula> listar() {
        return matriculaRepository.findAll();
    }

    public Matricula crear(MatriculaDTO dto) {

        if (matriculaRepository
                .existsByEstudianteIdAndCursoCodigo(
                        dto.getIdEstudiante(),
                        dto.getCodigoCurso())) {

            throw new RuntimeException(
                    "El estudiante ya está matriculado en este curso");
        }
        Estudiante estudiante = estudianteRepository
                .findById(dto.getIdEstudiante())
                .orElseThrow(() ->
                        new RuntimeException("Estudiante no encontrado"));

        Curso curso = cursoRepository
                .findById(dto.getCodigoCurso())
                .orElseThrow(() ->
                        new RuntimeException("Curso no encontrado"));

        Matricula matricula = new Matricula();
        matricula.setEstudiante(estudiante);
        matricula.setCurso(curso);

        return matriculaRepository.save(matricula);
    }

    public void eliminar(Integer id) {
        matriculaRepository.deleteById(id);
    }
}