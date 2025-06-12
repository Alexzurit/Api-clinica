package azj.proyect.clinica.service;

import azj.proyect.clinica.entity.HMedico;
import azj.proyect.clinica.repository.HMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HMedicoService {
    @Autowired
    private HMedicoRepository hMedicoRepository;

    public List<HMedico> obtenerTodos(){
        return hMedicoRepository.findAll();
    }

    //Listar por id
    public Optional<HMedico> obtenerPorId(int idHMedico){
        return hMedicoRepository.findById(idHMedico);
    }

    //Guardar HM
    //public HMedico guardarHM
}
