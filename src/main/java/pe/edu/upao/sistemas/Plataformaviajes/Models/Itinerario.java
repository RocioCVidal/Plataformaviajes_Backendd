package pe.edu.upao.sistemas.Plataformaviajes.Models;

import jakarta.persistence.*;
import lombok.Data;
<<<<<<< HEAD
import lombok.EqualsAndHashCode;
=======
>>>>>>> c94374219f62287bbcd8cc8f74aeef24c0c2faf7

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
@EqualsAndHashCode(callSuper = true)
=======
>>>>>>> c94374219f62287bbcd8cc8f74aeef24c0c2faf7
@Table(name = "itinerario")
@Entity
@Data
public class Itinerario extends Publicacion{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int duracion;

    @Column(nullable = false)
    private LocalDate fechainicio;

    @Column(nullable = false)
    private LocalDate fechaFin;

    @OneToMany(mappedBy = "itinerario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Actividad> actividades = new ArrayList<>();

<<<<<<< HEAD
    public Itinerario() {
        super();
        this.setTipo("itinerario");
    }
=======
>>>>>>> c94374219f62287bbcd8cc8f74aeef24c0c2faf7

}
