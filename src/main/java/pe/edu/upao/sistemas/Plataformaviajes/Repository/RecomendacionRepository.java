package pe.edu.upao.sistemas.Plataformaviajes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upao.sistemas.Plataformaviajes.Models.Recomendacion;

@Repository
public interface RecomendacionRepository extends JpaRepository<Recomendacion, Long> {
    // Métodos de consulta específicos para Recomendacion
}