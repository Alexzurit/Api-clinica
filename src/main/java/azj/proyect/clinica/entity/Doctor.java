package azj.proyect.clinica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "doctor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doctor")
    private int id_doctor;

    @Column(name = "nombres")
    private String nombres;
    /*@Column(name = "apellidoPat")
    private String apellidoPat;
    @Column(name = "apellidoMat")
    private String apellidoMat;*/

    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "dni")
    private String dni;
    @Column(name = "cmp")
    private String cmp;
    @Column(name = "correo")
    private String correo;
    @Column(name = "celular")
    private String celular;
    @Column(name = "estado")
    private Short estado;
    @ManyToOne //(fetch = FetchType.LAZY) //evita que al listar doctores, Spring cargue automáticamente toda la entidad Especialidad
    @JoinColumn(name = "id_especialidad")
    private Especialidad especialidad;

    //para las relaciones en tabla Horarios
    @OneToMany(mappedBy = "doctor")
    @JsonIgnore //Cortar bucle de serialización
    private List<Horario> tbHorario;

}
