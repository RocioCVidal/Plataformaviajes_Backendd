package pe.edu.upao.sistemas.Plataformaviajes.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lugares") // Se recomienda que el nombre de la tabla esté en plural
public class Lugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLugar;

    @Column(nullable = false)
    private String nombre;

    // Los getters y setters son generados por Lombok con la anotación @Data.
}
