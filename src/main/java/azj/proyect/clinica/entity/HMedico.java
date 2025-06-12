package azj.proyect.clinica.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "historial_medico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private int idHistorial;

    //a esto falta su relacion con la tabla cita
    @Column(name = "id_cita")
    private int idCita;

    //Al parecer este tambien
    @Column(name = "id_paciente")
    private int idPaciente;

    @Column(name = "fecha_Registro")
    private LocalDate fechaRegistro;
    @Column(name = "diagnostico", columnDefinition = "TEXT")
    private String diagnostico;
    @Column(name = "tratamiento", columnDefinition = "TEXT")
    private String tratamiento;
    @Column(name = "receta", columnDefinition = "TEXT")
    private String receta;
}
