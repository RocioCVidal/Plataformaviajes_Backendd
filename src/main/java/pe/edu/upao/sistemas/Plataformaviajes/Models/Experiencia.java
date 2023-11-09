package pe.edu.upao.sistemas.Plataformaviajes.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "experiencias")
@PrimaryKeyJoinColumn(name = "idPublicacion")
public class Experiencia extends Publicacion {

    // Asociación con la clase Imagen, una experiencia puede tener muchas imágenes.
    @OneToMany(mappedBy = "experiencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Imagen> imagenes = new ArrayList<>();

    // Lombok genera los constructores, getters y setters.
}
