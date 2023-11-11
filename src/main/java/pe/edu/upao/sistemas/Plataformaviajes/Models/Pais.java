package pe.edu.upao.sistemas.Plataformaviajes.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "paises") // Se recomienda que el nombre de la tabla esté en plural
public class Pais {

    @Id
    @Column(nullable = false, length = 3) // Asumiendo que el código del país tiene una longitud fija de 3
    private String codigo;

    @Column(nullable = false)
    private String nombre;

    // Los getters y setters son generados por Lombok con la anotación @Data.
}
