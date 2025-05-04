package azj.proyect.clinica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "especialidad")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idespecialidad")
    private int idespecialidad;

    @Column(name = "titulo")
    private String titulo;

    @OneToMany(mappedBy = "especialidad")
    @JsonIgnore //Esto evita que al serializar Especialidad, también se serialicen sus Doctores, cortando el bucle infinito.
    private List<Doctor> tbDoctor;
}
