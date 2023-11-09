package pe.edu.upao.sistemas.Plataformaviajes.Models;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidos;
    private String sexo;
    private Date fecha_nacimiento;
    // Omitir otros campos para el ejemplo simplificado

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String contraseña;

    // Getters y setters simplificados con Lombok
    // ...
}