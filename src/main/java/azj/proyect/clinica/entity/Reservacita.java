package azj.proyect.clinica.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reservacita")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservacita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreservacita")
    private int idReservacita;

    @ManyToOne
    @JoinColumn(name = "idpaciente")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "idhorario")
    private Horario horario;

    @Column(name = "estadoReserva")
    private String estadoReseva;
    @Column(name = "fechaReserva")
    private String fechaReserva;
}
