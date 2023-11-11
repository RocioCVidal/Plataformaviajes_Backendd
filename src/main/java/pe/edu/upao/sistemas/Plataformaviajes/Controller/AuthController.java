package pe.edu.upao.sistemas.Plataformaviajes.Controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.sistemas.Plataformaviajes.DTO.LoginDTO;
import pe.edu.upao.sistemas.Plataformaviajes.DTO.SignUpDTO;
import pe.edu.upao.sistemas.Plataformaviajes.DTO.UsuarioDTO;
import pe.edu.upao.sistemas.Plataformaviajes.Exception.EntidadNoEncontradaException;
import pe.edu.upao.sistemas.Plataformaviajes.Exception.UsuarioYaExisteException;
import pe.edu.upao.sistemas.Plataformaviajes.Models.Usuario;
import pe.edu.upao.sistemas.Plataformaviajes.Repository.UsuarioRepository;
import pe.edu.upao.sistemas.Plataformaviajes.Services.UsuarioServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioServices usuarioService;
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioServices usuarioServices;

    @Autowired
    public AuthController(UsuarioServices usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/iniciarSesion")
    public ResponseEntity<?> iniciarSesion(@RequestBody LoginDTO loginDTO) {
        Optional<String> resultadoValidacion = usuarioService.validarUsuario(loginDTO.getCorreo(), loginDTO.getContrasena());

        return resultadoValidacion.<ResponseEntity<?>>map(s -> ResponseEntity.badRequest().body(s)).orElseGet(() -> ResponseEntity.ok("Inicio de sesión exitoso"));

    }


    @PostMapping("/registrar")
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody SignUpDTO signUpDTO) {
        try {
            usuarioService.registrarUsuario(signUpDTO);
            return ResponseEntity.ok("Usuario registrado con éxito");
        } catch (UsuarioYaExisteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (EntidadNoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        // Aquí puedes agregar más capturas de excepciones si las necesitas
    }

    @GetMapping("/listaruser")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<UsuarioDTO> usuarios = usuarioServices.obtenerTodosLosUsuarios();
        return ResponseEntity.ok(usuarios);
    }
}