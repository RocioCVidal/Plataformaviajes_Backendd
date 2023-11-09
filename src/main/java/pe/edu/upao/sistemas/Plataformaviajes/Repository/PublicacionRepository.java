package pe.edu.upao.sistemas.Plataformaviajes.Repository;

import pe.edu.upao.sistemas.Plataformaviajes.Models.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
    // Métodos personalizados para Publicacion, si son necesarios, pueden ir aquí.
}
