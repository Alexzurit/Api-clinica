package azj.proyect.clinica.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_rol")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int idRol;

    @Column(name = "nombre_rol")
    private String nombreRol;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private List<Permiso> permisos = new ArrayList<>();
}
