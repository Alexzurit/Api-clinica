package azj.proyect.clinica.service;

import azj.proyect.clinica.entity.Horario;
import azj.proyect.clinica.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {
    @Autowired
    private HorarioRepository horarioRepository;

    public List<Horario> obtenerTodos() { return horarioRepository.findAll(); }
}
