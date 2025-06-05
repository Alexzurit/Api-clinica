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
    @Column(name = "id_especialidad")
    private int idespecialidad;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private Short estado;

    @OneToMany(mappedBy = "especialidad")
    @JsonIgnore //Esto evita que al serializar Especialidad, también se serialicen sus Doctores, cortando el bucle infinito.
    private List<Doctor> tbDoctor;
}
