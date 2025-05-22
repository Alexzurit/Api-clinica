package azj.proyect.clinica.repository;

import azj.proyect.clinica.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends  JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByDni(String dni);
    Optional<Usuario> findByEmail(String email);
}