package azj.proyect.clinica.service;

import azj.proyect.clinica.entity.Especialidad;
import azj.proyect.clinica.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService {
    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Especialidad> obtenerTodos(){ return especialidadRepository.findAll(); }

    public Optional<Especialidad> obtenerPorId(int idespecialidad) {
        return especialidadRepository.findById(idespecialidad);
    }
    //Guardar especialidad
    public Especialidad guardarEspecialidad(Especialidad especialidad){
        return especialidadRepository.save(especialidad);
    }
    //Actualizar especialidad
    public Especialidad actualizarEspecialidad(int idespecialidad, Especialidad nuevaEspecialidad){
        Especialidad especialidadExistente = especialidadRepository.findById(idespecialidad)
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));
        especialidadExistente.setTitulo(nuevaEspecialidad.getTitulo());
        return especialidadRepository.save(especialidadExistente);
    }
    //Eliminar especialidad
    public void eliminarEspecialidad (int idespecialidad){
        if (!especialidadRepository.existsById(idespecialidad)){
            throw new RuntimeException("Especialidad no encontrada");
        }
        especialidadRepository.deleteById(idespecialidad);
    }
}
