package azj.proyect.clinica.service;

import azj.proyect.clinica.entity.Permiso;
import azj.proyect.clinica.entity.Rol;
import azj.proyect.clinica.repository.PermisoRepository;
import azj.proyect.clinica.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermisoService {
    @Autowired
    private PermisoRepository permisoRepository;
    @Autowired
    private RolRepository rolRepository;

    public List<Permiso> obtenerTodos() { return permisoRepository.findAll(); }

    public Permiso guardarPermiso(Permiso permiso){
        Rol rol = rolRepository.findById(permiso.getRol().getIdRol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        permiso.setRol(rol);
        return permisoRepository.save(permiso);
    }

    public Optional <Permiso> obtenerPorId(int idPermiso) {
        return permisoRepository.findById(idPermiso);
    }

    public Permiso actualizarPermiso(int idPermiso, Permiso nuevoPermiso){
        Permiso permisoExistente = permisoRepository.findById(idPermiso)
                .orElseThrow(() -> new RuntimeException("Permiso no encontrado"));
        if (nuevoPermiso.getRol() != null){
            Rol rol = rolRepository.findById(nuevoPermiso.getRol().getIdRol())
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
            permisoExistente.setRol(rol);
        }

        permisoExistente.setRuta(nuevoPermiso.getRuta()); //

        return permisoRepository.save(permisoExistente);
    }
}
