package universidad.controller;

import universidad.dto.EstudianteDTO;
import universidad.service.EstudianteService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(
            EstudianteService service) {

        this.service = service;
    }

    @GetMapping
    public List<EstudianteDTO> listar() {

        return service.listar();
    }

    @GetMapping("/{id}")
    public EstudianteDTO buscarPorId(
            @PathVariable String id) {

        return service.buscarPorId(id);
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