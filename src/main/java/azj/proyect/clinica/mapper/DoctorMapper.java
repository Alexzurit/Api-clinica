package azj.proyect.clinica.mapper;

import azj.proyect.clinica.dto.DoctorResponseDTO;
import azj.proyect.clinica.entity.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {
    public DoctorResponseDTO mapToDoctorResponseDTO(Doctor doctor) {
        DoctorResponseDTO dto = new DoctorResponseDTO();
        dto.setIdDoctor(doctor.getIdDoctor());
        dto.setNombres(doctor.getNombres());
        dto.setApellidos(doctor.getApellidos());
        dto.setDni(doctor.getDni());
        dto.setCmp(doctor.getCmp());
        dto.setCelular(doctor.getCelular());
        dto.setEstadoDoctor(doctor.getEstado());

        if (doctor.getUsuario() != null) {
            dto.setEmailUsuario(doctor.getUsuario().getEmail());
            if (doctor.getUsuario().getRol() != null) {
                dto.setNombreRol(doctor.getUsuario().getRol().getNombreRol());
            }
        }

        if (doctor.getEspecialidad() != null) {
            dto.setNombreEspecialidad(doctor.getEspecialidad().getNombre());
        }

        return dto;
    }
}
