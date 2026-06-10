package universidad.exception;

public class DocenteDuplicadoException extends RuntimeException {

    public DocenteDuplicadoException(String mensaje) {
        super(mensaje);
    }
}