package azj.proyect.clinica.repository;

import azj.proyect.clinica.entity.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PermisoRepository extends JpaRepository<Permiso, Integer> {
}
