package azj.proyect.clinica.service;

import azj.proyect.clinica.entity.Sede;
import azj.proyect.clinica.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeService {
    @Autowired
    private SedeRepository sedeRepository;

    public List <Sede> obtenerTodos() { return sedeRepository.findAll(); }
}
