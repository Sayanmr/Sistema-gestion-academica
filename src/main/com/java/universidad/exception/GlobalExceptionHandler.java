package universidad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EstudianteDuplicadoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String manejarEstudianteDuplicado(
            EstudianteDuplicadoException ex) {

        return ex.getMessage();
    }

    @ExceptionHandler(DocenteDuplicadoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String manejarDocenteDuplicado(
            DocenteDuplicadoException ex) {

        return ex.getMessage();
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String manejarNoEncontrado(RuntimeException ex) {

        return ex.getMessage();
    }
}