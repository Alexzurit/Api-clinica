package azj.proyect.clinica.entity;

import azj.proyect.clinica.enums.EstadoUsuario;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;

    //@Column(name = "dni") DNI SE VA
    //private String dni;

    @Column(name = "email")
    private String email;

    @Column(name = "password_hash")
    private String pass;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoUsuario estado;

    /*@Column(name = "fecha_creacion", insertable = false, updatable = false)
    private java.sql.Timestamp fechaCreacion;*/
    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private java.sql.Timestamp fechaCreacion;

    /*@ManyToMany
    @JoinTable(
            name = "tb_usuario_rol",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol")
    )*/
    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;
    //private List<Rol> roles; //relacion con el rol
    //private List<Rol> roles = new ArrayList<>(); //Lista modificable
}
