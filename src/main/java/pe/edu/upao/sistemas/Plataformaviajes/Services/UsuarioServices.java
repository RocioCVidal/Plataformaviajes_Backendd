package pe.edu.upao.sistemas.Plataformaviajes.Services;

import pe.edu.upao.sistemas.Plataformaviajes.Models.Usuario;
import pe.edu.upao.sistemas.Plataformaviajes.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioServices {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServices(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<String> validarUsuario(String correo, String contrasena) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByCorreo(correo);
        if (usuarioOptional.isEmpty()) {
            return Optional.of("Correo no encontrado.");
        }
        Usuario usuario = usuarioOptional.get();
        if (!usuario.getContrasena().equals(contrasena)) {
            return Optional.of("Contraseña incorrecta.");
        }
        return Optional.empty();
    }


}