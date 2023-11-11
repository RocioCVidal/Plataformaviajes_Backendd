package pe.edu.upao.sistemas.Plataformaviajes.Models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



@Getter
@Entity
@Data
@Table (name = "experiencia")
public class Experiencia extends Publicacion {

    @OneToMany(mappedBy = "experiencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Imagen> imagenes = new ArrayList<>(); // Inicializa la lista para evitar NullPointerException

    // Constructor, getters y setters
    public Experiencia() {

    }

   /* public void setImagenes(List<Imagen> imagenes) {
        this.imagenes.clear();
        if (imagenes != null) {
            imagenes.forEach(this::addImagen);
        }
    }


    public void addImagen(Imagen imagen) {
        this.imagenes.add(imagen);
        imagen.setExperiencia(this);
    }

    public void removeImagen(Imagen imagen) {
        this.imagenes.remove(imagen);
        imagen.setExperiencia(null);
    }
    */

    // ...
}
