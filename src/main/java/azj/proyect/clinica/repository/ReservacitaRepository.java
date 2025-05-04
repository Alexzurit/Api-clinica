package azj.proyect.clinica.repository;

import azj.proyect.clinica.entity.Reservacita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservacitaRepository extends JpaRepository<Reservacita, Integer> {
}
