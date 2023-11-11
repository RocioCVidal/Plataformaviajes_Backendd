package pe.edu.upao.sistemas.Plataformaviajes.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@Table (name = "usuario")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;

    @Column (nullable = false)
    private String nombre;

    @Column (nullable = false)
    private String apellidos;

    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    private Sexo sexo;

    @Temporal(TemporalType.DATE)
    @Column (nullable = false)
    private Date fecha_nacimiento;

    private String descripcion;

    @Column (nullable = false, unique = true)
    private String correo;

    @JsonIgnore
    @Column (nullable = false)
    private String contrasena;

    @Enumerated(EnumType.STRING)
    private TipoViajero tipo_viajero;

    private String fotoPerfilUrl;

    //El usuario podra agregar sus contactos(opcional)
    private String urlFacebook;
    private String urlTwiter;
    private String urlInstagram;

    // creacion de los Enum para los atributos que solo cuentan con 3 o pocas opciones

    //Clase Sexo
    public enum Sexo{
        MASCULINO, FEMENINO, OTRO
    }

    //Clase Tipo de viajero

    public enum TipoViajero {
        NOVATO, EXPERTO
    }
    public Usuario() {

    }
}