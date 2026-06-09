package universidad.controller;

import universidad.dto.CalificacionRequest;
import universidad.entity.Calificacion;
import universidad.service.CalificacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calificaciones")
public class CalificacionController {

    private final CalificacionService service;

    public CalificacionController(CalificacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Calificacion> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Calificacion obtenerPorId(
            @PathVariable Integer id) {

        return service.buscarPorId(id);
    }

    @PostMapping
    public Calificacion guardar(
            @RequestBody CalificacionRequest request) {

        return service.guardar(request);
    }

    @PutMapping("/{id}")
    public Calificacion actualizar(
            @PathVariable Integer id,
            @RequestBody CalificacionRequest request) {

        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Integer id) {

        service.eliminar(id);
    }
}