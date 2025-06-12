package azj.proyect.clinica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "horario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private int idHorario;

    @Column(name = "dia_semana")
    private String diaSemana;
    @Column(name = "hora_inicio")
    private LocalTime horaInicio;
    @Column(name = "hora_fin")
    private LocalTime horaFin;
    @Column(name = "estado")
    private Short estado;

    @OneToMany(mappedBy = "horario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore //Cortar bucle de serialización
    private List<Disponibilidad> disponibilidades;
}
/*
@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public void crearEvento() {
        Evento evento = new Evento();
        evento.setHoraInicio(LocalTime.of(14, 30)); // 14:30 PM
        eventoRepository.save(evento);
    }

    public LocalTime obtenerHoraEvento(Long id) {
        return eventoRepository.findById(id).orElseThrow().getHoraInicio();
    }
}
para manejar estados:
public static final Short ESTADO_INACTIVO = 0;
public static final Short ESTADO_ACTIVO = 1;
public static final Short ESTADO_SUSPENDIDO = 2;

*/