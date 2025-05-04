package azj.proyect.clinica.entity;
import jakarta.persistence.*;
import lombok.*;

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
}
