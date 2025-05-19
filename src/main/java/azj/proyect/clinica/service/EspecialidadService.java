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
}
