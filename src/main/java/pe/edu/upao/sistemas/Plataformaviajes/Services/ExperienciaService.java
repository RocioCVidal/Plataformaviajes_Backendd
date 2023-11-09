package pe.edu.upao.sistemas.Plataformaviajes.Services;

import pe.edu.upao.sistemas.Plataformaviajes.DTO.ExperienciaDTO;
import pe.edu.upao.sistemas.Plataformaviajes.Models.*;
import pe.edu.upao.sistemas.Plataformaviajes.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienciaService {

    private final ExperienciaRepository experienciaRepository;
    private final UsuarioRepository usuarioRepository;
    private final LugarRepository lugarRepository;
    private final PaisRepository paisRepository;

    @Autowired
    public ExperienciaService(ExperienciaRepository experienciaRepository,
                              UsuarioRepository usuarioRepository,
                              LugarRepository lugarRepository,
                              PaisRepository paisRepository) {
        this.experienciaRepository = experienciaRepository;
        this.usuarioRepository = usuarioRepository;
        this.lugarRepository = lugarRepository;
        this.paisRepository = paisRepository;
    }

    @Transactional
    public Experiencia crearExperienciaDesdeDTO(ExperienciaDTO experienciaDTO) {
        Experiencia experiencia = new Experiencia();
        experiencia.setTitulo(experienciaDTO.getTitulo());
        experiencia.setDescripcion(experienciaDTO.getDescripcion());
        experiencia.setFecha(experienciaDTO.getFecha());
        experiencia.setHora(experienciaDTO.getHora());

        Usuario autor = usuarioRepository.findById(experienciaDTO.getAutorId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        experiencia.setAutor(autor);

        Lugar lugar = lugarRepository.findByNombre(experienciaDTO.getLugar())
                .orElseGet(() -> {
                    Lugar nuevoLugar = new Lugar();
                    nuevoLugar.setNombre(experienciaDTO.getLugar());
                    return lugarRepository.save(nuevoLugar);
                });
        experiencia.setLugar(lugar);

        Pais pais = paisRepository.findById(experienciaDTO.getPaisCodigo())
                .orElseThrow(() -> new RuntimeException("País no encontrado"));
        experiencia.setPais(pais);

        if (experienciaDTO.getUrlsImagenes() != null) {
            List<Imagen> imagenes = experienciaDTO.getUrlsImagenes().stream()
                    .map(url -> {
                        Imagen imagen = new Imagen();
                        imagen.setUrl(url);
                        imagen.setExperiencia(experiencia);
                        return imagen;
                    })
                    .collect(Collectors.toList());
            experiencia.setImagenes(imagenes);
        }

        return experienciaRepository.save(experiencia);
    }
}


