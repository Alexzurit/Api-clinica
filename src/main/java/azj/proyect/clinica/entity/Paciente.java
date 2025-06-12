package azj.proyect.clinica.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*; //Para manejar la persistencia de datos
import lombok.*; //Para omitir getters y setters

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "paciente")
@Data //es de Lombok que incluye los S y G
@NoArgsConstructor
@AllArgsConstructor

public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private int idpaciente;


    //@Column(columnDefinition = "TEXT")
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "dni", nullable = false, unique = true)
    private String dni;
    @Column(name = "correo")
    private String correo;
    @Column(name = "celular")
    private String celular;
    @Column(name = "direccion", columnDefinition = "TEXT")
    private String direccion;
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "estado")
    private Short estado;

    //para relación en tabla Reservacitas
    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private List<Reservacita> tbReservacita;
}
