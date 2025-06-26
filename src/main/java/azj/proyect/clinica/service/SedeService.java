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

    public Sede guardarSede(Sede sede) {
        return sedeRepository.save(sede);
    }

    public Sede actualizarSede(int id, Sede sedeActualizada) {
        return sedeRepository.findById(id).map(sede -> {
            sede.setNombre(sedeActualizada.getNombre());
            sede.setDireccion(sedeActualizada.getDireccion());
            sede.setDistrito(sedeActualizada.getDistrito());
            sede.setEstado(sedeActualizada.getEstado());
            return sedeRepository.save(sede);
        }).orElseThrow(() -> new RuntimeException("Sede no encontrada con ID: " + id));
    }

}
