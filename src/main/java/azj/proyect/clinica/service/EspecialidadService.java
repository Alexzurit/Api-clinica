package azj.proyect.clinica.service;

import azj.proyect.clinica.entity.Especialidad;
import azj.proyect.clinica.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadService {
    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Especialidad> obtenerTodos(){ return especialidadRepository.findAll(); }
}
