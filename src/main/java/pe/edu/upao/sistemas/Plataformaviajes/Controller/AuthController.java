package pe.edu.upao.sistemas.Plataformaviajes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upao.sistemas.Plataformaviajes.DTO.LoginDTO;
import pe.edu.upao.sistemas.Plataformaviajes.Services.UsuarioServices;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioServices usuarioService;

    @Autowired
    public AuthController(UsuarioServices usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/iniciarSesion")
    public ResponseEntity<?> iniciarSesion(@RequestBody LoginDTO loginDTO) {
        Optional<String> resultadoValidacion = usuarioService.validarUsuario(loginDTO.getCorreo(), loginDTO.getContrasena());

        return resultadoValidacion.<ResponseEntity<?>>map(s -> ResponseEntity.badRequest().body(s)).orElseGet(() -> ResponseEntity.ok("Inicio de sesión exitoso"));

    }
}
