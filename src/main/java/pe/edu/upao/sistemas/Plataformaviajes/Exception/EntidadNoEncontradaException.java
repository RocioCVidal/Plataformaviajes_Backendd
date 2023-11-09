package pe.edu.upao.sistemas.Plataformaviajes.Exception;

import org.springframework.http.HttpStatus;

public class EntidadNoEncontradaException extends RuntimeException {

    public EntidadNoEncontradaException(String message) {
        super(message);
    }

    // Si deseas, también puedes agregar un constructor que acepte una causa:
    public EntidadNoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }

    // Y si quieres incluir el código de estado HTTP dentro de la excepción:
    private HttpStatus status = HttpStatus.NOT_FOUND;

    public HttpStatus getStatus() {
        return status;
    }
}