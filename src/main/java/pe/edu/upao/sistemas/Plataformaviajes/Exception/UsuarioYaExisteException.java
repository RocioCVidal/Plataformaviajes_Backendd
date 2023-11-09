package pe.edu.upao.sistemas.Plataformaviajes.Exception;


public class UsuarioYaExisteException extends RuntimeException {

    public UsuarioYaExisteException(String mensaje) {
        super(mensaje);
    }

}
