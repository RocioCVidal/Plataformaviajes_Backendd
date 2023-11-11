package pe.edu.upao.sistemas.Plataformaviajes.Services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upao.sistemas.Plataformaviajes.DTO.PublicacionDTO;
<<<<<<< HEAD
=======
import pe.edu.upao.sistemas.Plataformaviajes.Exception.EntidadNoEncontradaException;
>>>>>>> c94374219f62287bbcd8cc8f74aeef24c0c2faf7
import pe.edu.upao.sistemas.Plataformaviajes.Models.*;
import pe.edu.upao.sistemas.Plataformaviajes.Repository.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class RecomendacionServices {

    private final RecomendacionRepository recomendacionRepository;
    private final UsuarioRepository usuarioRepository;
    private final LugarRepository lugarRepository;
    private final PaisRepository paisRepository;

    public RecomendacionServices(RecomendacionRepository recomendacionRepository, UsuarioRepository usuarioRepository, LugarRepository lugarRepository, PaisRepository paisRepository){
        this.recomendacionRepository = recomendacionRepository;
        this.usuarioRepository = usuarioRepository;
        this.lugarRepository = lugarRepository;
        this.paisRepository = paisRepository;
    }

    @Transactional
    public Recomendacion crearDesdeDTO(PublicacionDTO publicacionDTO){
        Recomendacion recomendacion = new Recomendacion();
<<<<<<< HEAD
        recomendacion.setTitulo(publicacionDTO.getTitulo());
        recomendacion.setTipo(publicacionDTO.getTipo());
        recomendacion.setDescripcion(publicacionDTO.getDescripcion());

        Usuario usuario = usuarioRepository.findById(publicacionDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
=======
        recomendacion.setTipo(publicacionDTO.getTipo());
        recomendacion.setTitulo(publicacionDTO.getTitulo());
        recomendacion.setDescripcion(publicacionDTO.getDescripcion());

        Usuario usuario = usuarioRepository.findById(publicacionDTO.getUsuarioId())
                .orElseThrow(() -> new EntidadNoEncontradaException("Usuario no encontrado"));
>>>>>>> c94374219f62287bbcd8cc8f74aeef24c0c2faf7
        recomendacion.setUsuario(usuario);

        Lugar lugar = lugarRepository.findByNombre(publicacionDTO.getLugar())
                .orElseGet(() -> {
                    Lugar nuevoLugar = new Lugar();
                    nuevoLugar.setNombre(publicacionDTO.getLugar());
                    return lugarRepository.save(nuevoLugar);
                });
        recomendacion.setLugar(lugar);

<<<<<<< HEAD
        Pais pais = paisRepository.findByNombreIgnoreCase(publicacionDTO.getNombrePais())
                .orElseThrow(() -> new RuntimeException("No hay el pais"));
        recomendacion.setPais(pais);
=======
       Pais pais = paisRepository.findByNombreIgnoreCase(publicacionDTO.getNombrePais())
               .orElseThrow(() -> new EntidadNoEncontradaException("No hay el pais"));
       recomendacion.setPais(pais);

>>>>>>> c94374219f62287bbcd8cc8f74aeef24c0c2faf7
        recomendacion.setFecha(LocalDate.from(LocalDateTime.now()));
        recomendacion.setHora(LocalTime.from(LocalDateTime.now()));

        return recomendacionRepository.save(recomendacion);
    }
}
