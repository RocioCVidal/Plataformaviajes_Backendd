package pe.edu.upao.sistemas.Plataformaviajes.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
<<<<<<< HEAD
=======
import lombok.NoArgsConstructor;
>>>>>>> c94374219f62287bbcd8cc8f74aeef24c0c2faf7
import org.springframework.data.annotation.Id;

@Entity
@Data
@AllArgsConstructor

public class Actividad {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "itinerario_id")
    private Itinerario itinerario;


    public Actividad() {

    }

    public Actividad(String descripcion, Itinerario itinerario){
        this.descripcion = descripcion;
        this.itinerario = itinerario;
    }
}
