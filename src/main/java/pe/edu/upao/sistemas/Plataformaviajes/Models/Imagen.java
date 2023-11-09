package pe.edu.upao.sistemas.Plataformaviajes.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "imagenes")
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImagen;

    private String url;

    // Relación inversa, muchas imágenes corresponden a una experiencia
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "experiencia_id") // Esto debe coincidir con la clave primaria de la entidad Experiencia.
    private Experiencia experiencia;

    // Lombok genera los constructores, getters y setters.
}
