package pe.edu.upao.sistemas.Plataformaviajes.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "publicaciones")
@Inheritance(strategy = InheritanceType.JOINED) // Esto permite la estrategia JOIN
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPublicacion;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private LocalTime hora;

    @ManyToOne
    @JoinColumn(name = "autor_id") // La referencia debe ser el nombre de la columna en la tabla de Usuario.
    private Usuario autor;

    // Si Lugar es una entidad, entonces esto es correcto. Si no, debería ser un String.
    @ManyToOne
    @JoinColumn(name = "lugar_id") // La referencia debe ser el nombre de la columna en la tabla de Lugar.
    private Lugar lugar;

    @ManyToOne
    @JoinColumn(name = "pais_codigo") // La referencia debe ser el nombre de la columna en la tabla de Pais.
    private Pais pais;

    // Otros atributos y métodos...
}
