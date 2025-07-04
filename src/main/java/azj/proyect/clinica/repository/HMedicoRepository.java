package azj.proyect.clinica.repository;

import azj.proyect.clinica.entity.HMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HMedicoRepository extends JpaRepository<HMedico, Integer>{
    @Query("SELECT h FROM HMedico h WHERE h.cita.paciente.idpaciente = :idPaciente")
    List<HMedico> findByPacienteId(@Param("idPaciente") int idPaciente);

}
