package pe.edu.upao.sistemas.Plataformaviajes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienciaDTO {

    private String titulo;
    private String descripcion;
    private LocalDate fecha;
    private LocalTime hora;
    private Long autorId; // Suponiendo que pasamos el ID del autor
    private String lugar; // Nombre del lugar como un String
    private String paisCodigo; // Código del país seleccionado
    private List<String> urlsImagenes; // URLs de las imágenes asociadas

    // Si necesitas más datos específicos de la experiencia que no están en Publicacion,
    // puedes agregarlos aquí como nuevos campos.
}
