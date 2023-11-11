package pe.edu.upao.sistemas.Plataformaviajes.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.sistemas.Plataformaviajes.DTO.PublicacionDTO;
import pe.edu.upao.sistemas.Plataformaviajes.Models.Experiencia;
import pe.edu.upao.sistemas.Plataformaviajes.Models.Itinerario;
import pe.edu.upao.sistemas.Plataformaviajes.Models.Publicacion;
import pe.edu.upao.sistemas.Plataformaviajes.Models.Recomendacion;
import pe.edu.upao.sistemas.Plataformaviajes.Services.ExperienciaServices;
import pe.edu.upao.sistemas.Plataformaviajes.Services.ItinerarioServices;
import pe.edu.upao.sistemas.Plataformaviajes.Services.PublicacionServices;
import pe.edu.upao.sistemas.Plataformaviajes.Services.RecomendacionServices;

import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")

public class PublicacionController {

    private final ExperienciaServices experienciaService;
    private final ItinerarioServices itinerarioService;
    private final RecomendacionServices recomendacionService;
    private final PublicacionServices publicacionServices;


    @Autowired
    public PublicacionController(ExperienciaServices experienciaService,
                                 ItinerarioServices itinerarioService,
                                 RecomendacionServices recomendacionService,
                                 PublicacionServices publicacionServices) {
        this.experienciaService = experienciaService;
        this.itinerarioService = itinerarioService;
        this.recomendacionService = recomendacionService;
        this.publicacionServices = publicacionServices;
    }

    @PostMapping("/crearPublicacion")
    public ResponseEntity<?> crearPublicacion(@RequestBody PublicacionDTO publicacionDTO) {
        switch (publicacionDTO.getTipo().toLowerCase()) {
            case "experiencia":
                Experiencia experiencia = experienciaService.crearDesdeDTO(publicacionDTO);
                return ResponseEntity.ok("Publicacion creada");
            case "itinerario":
                Itinerario itinerario = itinerarioService.crearDesdeDTO(publicacionDTO);
                return ResponseEntity.ok("Publicacion creada");
            case "recomendacion":
                Recomendacion recomendacion = recomendacionService.crearDesdeDTO(publicacionDTO);
                return ResponseEntity.ok("Publicacion creada");
            default:
                return new ResponseEntity<>("Tipo de publicación desconocido", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<?>> obtenerPublicaciones(@RequestParam(name = "tipo", defaultValue = "todas") String tipo) {
        List<?> publicaciones = publicacionServices.obtenerPublicaciones(tipo);
        return ResponseEntity.ok(publicaciones);
    }
}