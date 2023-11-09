package pe.edu.upao.sistemas.Plataformaviajes.Repository;

import pe.edu.upao.sistemas.Plataformaviajes.Models.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {
    // Aquí puedes agregar métodos personalizados si necesitas realizar consultas más específicas.
}
