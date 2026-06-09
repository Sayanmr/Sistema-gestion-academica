package universidad.controller;

import lombok.RequiredArgsConstructor;
import universidad.dto.EstudianteDTO;
import universidad.service.EstudianteService;

import org.springframework.web.bind.annotation.*;

import universidad.service.CalificacionService;
import universidad.service.MatriculaService;
import universidad.entity.Curso;

import java.util.List;
@RestController
@RequestMapping("/api/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    private final EstudianteService service;
    private final CalificacionService calificacionService;
    private final MatriculaService matriculaService;


    @GetMapping
    public List<EstudianteDTO> listar() {

        return service.listar();
    }

    @GetMapping("/{id}")
    public EstudianteDTO buscarPorId(
            @PathVariable String id) {

        return service.buscarPorId(id);
    }
    @GetMapping("/{id}/promedio")
    public Double promedio(
            @PathVariable String id) {

        return calificacionService
                .promedioEstudiante(id);
    }
    @GetMapping("/{id}/cursos")
    public List<Curso> cursos(
            @PathVariable String id) {

        return matriculaService
                .cursosDeEstudiante(id);
    }

    @PostMapping
    public EstudianteDTO guardar(
            @RequestBody EstudianteDTO dto) {

        return service.guardar(dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable String id) {

        service.eliminar(id);
    }

}