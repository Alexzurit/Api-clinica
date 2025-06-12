package azj.proyect.clinica.repository;

import azj.proyect.clinica.entity.HMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HMedicoRepository extends JpaRepository<HMedico, Integer>{
}
