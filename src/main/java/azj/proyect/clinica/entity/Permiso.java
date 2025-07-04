package azj.proyect.clinica.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_permisos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permiso")
    private int idPermiso;

    @Column(name = "ruta")
    private String ruta;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

}
