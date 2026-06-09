package universidad.controller;

import universidad.entity.Estudiante;
import universidad.service.EstudianteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Estudiante> listar() {
        return service.listar();
    }

    @PostMapping
    public Estudiante guardar(
            @RequestBody Estudiante estudiante) {

        return service.guardar(estudiante);
    }

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable String id) {

        service.eliminar(id);
    }
}