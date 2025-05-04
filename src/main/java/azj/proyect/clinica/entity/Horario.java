package azj.proyect.clinica.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "horario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhorario")
    private int idHorario;

}
