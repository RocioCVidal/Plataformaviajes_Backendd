package pe.edu.upao.sistemas.Plataformaviajes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upao.sistemas.Plataformaviajes.Models.Experiencia;
@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {
    // Métodos de consulta específicos para Experiencia
}