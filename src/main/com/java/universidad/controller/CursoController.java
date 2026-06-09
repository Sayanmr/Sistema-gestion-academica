package universidad.controller;

import universidad.entity.Curso;
import universidad.service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Curso> listar() {
        return service.listar();
    }

    @GetMapping("/{codigo}")
    public Curso obtenerPorCodigo(@PathVariable String codigo) {
        return service.buscarPorCodigo(codigo);
    }

    @PostMapping
    public Curso guardar(@RequestBody Curso curso) {
        return service.guardar(curso);
    }

    @PutMapping("/{codigo}")
    public Curso actualizar(
            @PathVariable String codigo,
            @RequestBody Curso curso) {

        service.buscarPorCodigo(codigo);

        curso.setCodigo(codigo);
        return service.guardar(curso);
    }

    @DeleteMapping("/{codigo}")
    public void eliminar(@PathVariable String codigo) {
        service.eliminar(codigo);
    }
}