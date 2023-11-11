package pe.edu.upao.sistemas.Plataformaviajes.Services;

import pe.edu.upao.sistemas.Plataformaviajes.DTO.SignUpDTO;
import pe.edu.upao.sistemas.Plataformaviajes.Exception.EntidadNoEncontradaException;
import pe.edu.upao.sistemas.Plataformaviajes.Exception.UsuarioYaExisteException;
import pe.edu.upao.sistemas.Plataformaviajes.Models.Pais;
import pe.edu.upao.sistemas.Plataformaviajes.Models.Usuario;
import pe.edu.upao.sistemas.Plataformaviajes.Repository.PaisRepository;
import pe.edu.upao.sistemas.Plataformaviajes.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioServices {

    private final UsuarioRepository usuarioRepository;
    private final PaisRepository paisRepository;

    @Autowired
    public UsuarioServices(UsuarioRepository usuarioRepository, PaisRepository paisRepository) {
        this.usuarioRepository = usuarioRepository;
        this.paisRepository = paisRepository;
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

    public Optional<Usuario> obtenerUsuarioPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    public Usuario registrarUsuario(SignUpDTO signUpDTO) {

        // Verificar si ya existe un usuario con el mismo correo
        if (usuarioRepository.findByCorreo(signUpDTO.getCorreo()).isPresent()) {
            throw new UsuarioYaExisteException("El correo indicado ya está registrado");
        }

        // Convertir SignUpDTO a entidad Usuario
        Usuario usuario = new Usuario();
        usuario.setNombre(signUpDTO.getNombre());
        usuario.setApellidos(signUpDTO.getApellidos());
        usuario.setSexo(Usuario.Sexo.valueOf(signUpDTO.getSexo()));
        usuario.setFechaNacimiento(signUpDTO.getFechaNacimiento()); // Asegúrate de que el formato de fecha sea el correcto
        usuario.setCorreo(signUpDTO.getCorreo());
        usuario.setContrasena(signUpDTO.getContrasena());

        Pais paisOrigen = paisRepository.findByNombreIgnoreCase((signUpDTO.getPaisOrigen()))
                .orElseThrow(() -> new EntidadNoEncontradaException("País de origen no encontrado"));

        Pais paisVive = paisRepository.findByNombreIgnoreCase((signUpDTO.getPaisVive()))
                .orElseThrow(() -> new EntidadNoEncontradaException("País de residencia no encontrado"));

        usuario.setPaisOrigen(paisOrigen);
        usuario.setPaisVive(paisVive);
        usuario.setDescripcion(signUpDTO.getDescripcion());

        usuario.setTipoViajero(Usuario.TipoViajero.valueOf(signUpDTO.getTipoViajero()));
        usuario.setFotoPerfilUrl(signUpDTO.getFotoPerfilUrl());
        usuario.setUrlFacebook(signUpDTO.getUrlFacebook());
        usuario.setUrlInstagram(signUpDTO.getUrlInstagram());
        usuario.setUrlTwiter(signUpDTO.getUrlTwiter());

        // Guardar el usuario en la base de datos
        return usuarioRepository.save(usuario);
    }


}