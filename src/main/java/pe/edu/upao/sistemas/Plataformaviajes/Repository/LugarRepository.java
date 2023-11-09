package pe.edu.upao.sistemas.Plataformaviajes.Repository;

import pe.edu.upao.sistemas.Plataformaviajes.Models.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LugarRepository extends JpaRepository<Lugar, Long> {
    // Método para buscar un lugar por su nombre.
    Optional<Lugar> findByNombre(String nombre);
}
