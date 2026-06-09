package universidad.controller;

import universidad.dto.MatriculaDTO;
import universidad.entity.Matricula;
import universidad.service.MatriculaService;
import org.springframework.web.bind.annotation.*;
import universidad.dto.MatriculaDetalleDTO;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Matricula> listar() {
        return service.listar();
    }

    @PostMapping
    public Matricula crear(
            @RequestBody MatriculaDTO dto) {

        return service.crear(dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Integer id) {

        service.eliminar(id);
    }
    @GetMapping("/detalle")
    public List<MatriculaDetalleDTO> detalle() {

        return service.detalle();
    }
}