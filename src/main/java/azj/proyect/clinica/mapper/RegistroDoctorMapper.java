package azj.proyect.clinica.mapper;

import azj.proyect.clinica.dto.RegistroDoctorDTO;
import azj.proyect.clinica.entity.Doctor;
import azj.proyect.clinica.entity.Especialidad;
import azj.proyect.clinica.entity.Rol;
import azj.proyect.clinica.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegistroDoctorMapper {
    public Usuario toUsuario(RegistroDoctorDTO dto, Rol rol, String hashedPassword) {
        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setPass(hashedPassword);
        usuario.setEstado(dto.getEstado());
        //usuario.setRoles(roles);
        usuario.setRol(rol);
        return usuario;
    }

    public Doctor toDoctor(RegistroDoctorDTO dto, Usuario usuario, Especialidad especialidad) {
        Doctor doctor = new Doctor();
        doctor.setNombres(dto.getNombres());
        doctor.setApellidos(dto.getApellidos());
        doctor.setDni(dto.getDni());
        doctor.setCmp(dto.getCmp());
        doctor.setCelular(dto.getCelular());
        doctor.setEstado(dto.getEstadoDoctor());
        doctor.setEspecialidad(especialidad);
        doctor.setDisponibilidades(new ArrayList<>());
        return doctor;
    }


}
