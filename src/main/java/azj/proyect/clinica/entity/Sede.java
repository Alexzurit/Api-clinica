package azj.proyect.clinica.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "sede")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsede")
    private int idsede;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "ruc")
    private String ruc;

    //para las relaciones en tabla Horarios
    @OneToMany(mappedBy = "sede")
    @JsonIgnore //Cortar bucle de serialización
    private List<Horario> tbHorario;
}
