package azj.proyect.clinica.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    //Relacionar
    @ManyToOne
    @JoinColumn(name = "id_disponibilidad")
    private Disponibilidad disponibilidad;

    @Column(name = "fecha")
    private LocalDateTime fecha;
    @Column(name = "estado")
    private Short estado;
    @Column(name = "motivo_consulta", columnDefinition = "TEXT")
    private String motivoCons;
}
