package pe.edu.upao.sistemas.Plataformaviajes.Controller;

import pe.edu.upao.sistemas.Plataformaviajes.DTO.ExperienciaDTO;
import pe.edu.upao.sistemas.Plataformaviajes.Models.Experiencia;
import pe.edu.upao.sistemas.Plataformaviajes.Services.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/experiencias")
public class ExperienciaController {

    private final ExperienciaService experienciaService;

    @Autowired
    public ExperienciaController(ExperienciaService experienciaService) {
        this.experienciaService = experienciaService;
    }

    @PostMapping
    public ResponseEntity<Experiencia> crearExperiencia(@RequestBody ExperienciaDTO experienciaDTO) {
        Experiencia nuevaExperiencia = experienciaService.crearExperienciaDesdeDTO(experienciaDTO);
        return new ResponseEntity<>(nuevaExperiencia, HttpStatus.CREATED);
    }

    // Aquí puedes agregar otros métodos HTTP para manejar otras acciones como GET, PUT, DELETE, etc.
}


