package universidad.controller;

import universidad.entity.Docente;
import universidad.service.DocenteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    private final DocenteService service;

    public DocenteController(DocenteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Docente> listar() {
        return service.listar();
    }

    @GetMapping("/{numEmpleado}")
    public Docente obtenerPorId(@PathVariable String numEmpleado) {
        return service.buscarPorId(numEmpleado);
    }

    @PostMapping
    public Docente guardar(@RequestBody Docente docente) {
        return service.guardar(docente);
    }

    @PutMapping("/{numEmpleado}")
    public Docente actualizar(
            @PathVariable String numEmpleado,
            @RequestBody Docente docente) {

        docente.setNumEmpleado(numEmpleado);
        return service.guardar(docente);
    }

    @DeleteMapping("/{numEmpleado}")
    public void eliminar(@PathVariable String numEmpleado) {
        service.eliminar(numEmpleado);
    }
}