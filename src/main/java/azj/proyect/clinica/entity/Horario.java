package azj.proyect.clinica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "idsede")
    private Sede sede;

    @Column(name = "fecha")
    private String fecha;
    @Column(name = "dia")
    private String dia;
    @Column(name = "hora")
    private String hora;
    @Column(name = "disponibilidad")
    private byte disponibilidad;

    //para relacion con tabla reservacita
    @OneToMany(mappedBy = "horario")
    @JsonIgnore
    private List<Reservacita> tbReservacita;
}
