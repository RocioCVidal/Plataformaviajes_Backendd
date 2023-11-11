package pe.edu.upao.sistemas.Plataformaviajes.Services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upao.sistemas.Plataformaviajes.DTO.PublicacionDTO;
import pe.edu.upao.sistemas.Plataformaviajes.Exception.EntidadNoEncontradaException;
import pe.edu.upao.sistemas.Plataformaviajes.Models.*;
import pe.edu.upao.sistemas.Plataformaviajes.Repository.*;

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
        recomendacion.setTitulo(publicacionDTO.getTitulo());
        recomendacion.setDescripcion(publicacionDTO.getDescripcion());

        Usuario usuario = usuarioRepository.findById(publicacionDTO.getUsuarioId())
                .orElseThrow(() -> new EntidadNoEncontradaException("Usuario no encontrado"));
        recomendacion.setUsuario(usuario);

        Lugar lugar = lugarRepository.findByNombre(publicacionDTO.getLugar())
                .orElseGet(() -> {
                    Lugar nuevoLugar = new Lugar();
                    nuevoLugar.setNombre(publicacionDTO.getLugar());
                    return lugarRepository.save(nuevoLugar);
                });
        recomendacion.setLugar(lugar);

       Pais pais = paisRepository.findByNombreIgnoreCase(publicacionDTO.getNombrePais())
               .orElseThrow(() -> new EntidadNoEncontradaException("No hay el pais"));
       recomendacion.setPais(pais);

        return recomendacionRepository.save(recomendacion);
    }
}
