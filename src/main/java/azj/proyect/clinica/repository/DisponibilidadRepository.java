package azj.proyect.clinica.repository;

import azj.proyect.clinica.entity.Disponibilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisponibilidadRepository extends JpaRepository<Disponibilidad, Integer> {
}
