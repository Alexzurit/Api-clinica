package azj.proyect.clinica.service;

import azj.proyect.clinica.dto.SolicitudCitaDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class RegistroCitaService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void registrarCita(SolicitudCitaDTO dto) {
        em.createNativeQuery("CALL registrar_cita_medica(:dni, :idDispon, :motivo)")
                .setParameter("dni", dto.getDni())
                .setParameter("idDispon", dto.getIdDisponibilidad())
                .setParameter("motivo", dto.getMotivo())
                .executeUpdate();
    }
}
