package azj.proyect.clinica.entity;
import jakarta.persistence.*; //Para manejar la persistencia de datos
import lombok.*; //Para omitir getters y setters

@Entity
@Table(name = "paciente")
@Data //es de Lombok que incluye los S y G
@NoArgsConstructor
@AllArgsConstructor

public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpaciente")
    private int idpaciente;

    @Column(name = "dni", nullable = false, unique = true)
    private int dni;

    //@Column(columnDefinition = "TEXT")
    @Column(name = "token")
    private String token;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;
    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "fechaNacimiento")
    private String fechaNacimiento;
    @Column(name = "direccion")
    private String direccion;
}
