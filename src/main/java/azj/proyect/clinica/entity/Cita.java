package azj.proyect.clinica.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "cita")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private int idCita;

    //Relacionar
    @ManyToOne
    @Column(name = "id_paciente")
    private Paciente paciente;
    //Relacionar
    @ManyToOne
    @Column(name = "id_disponibilidad")
    private Disponibilidad disponibilidad;

    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "estado")
    private Short estado;
    @Column(name = "motivo_consulta", columnDefinition = "TEXT")
    private String motivoCons;
}
