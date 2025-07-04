package azj.proyect.clinica.repository;

import azj.proyect.clinica.entity.Cita;
import azj.proyect.clinica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer>{
    @Query("SELECT c.paciente FROM Cita c WHERE c.disponibilidad.doctor.idDoctor = :idDoctor")
    List<Paciente> findPacientesByDoctorId(@Param("idDoctor") int idDoctor);

    /*Lo de abajoEsto carga citas completas con pacientes adjuntos */
    @Query("SELECT c FROM Cita c WHERE c.disponibilidad.doctor.idDoctor = :idDoctor")
    List<Cita> findCitasByDoctorId(@Param("idDoctor") int idDoctor);
}
