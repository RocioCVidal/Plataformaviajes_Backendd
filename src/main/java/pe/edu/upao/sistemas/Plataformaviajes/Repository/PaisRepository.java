package pe.edu.upao.sistemas.Plataformaviajes.Repository;

<<<<<<< HEAD
import pe.edu.upao.sistemas.Plataformaviajes.Models.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, String> {
    // El método findById ya está incluido en JpaRepository.
}
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upao.sistemas.Plataformaviajes.Models.Pais;
import java.util.Optional;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
        Optional<Pais> findByNombreIgnoreCase(String nombre);

}
>>>>>>> origin/develop
