package universidad.exception;

public class EstudianteDuplicadoException
        extends RuntimeException {

    public EstudianteDuplicadoException(String mensaje) {
        super(mensaje);
    }
}