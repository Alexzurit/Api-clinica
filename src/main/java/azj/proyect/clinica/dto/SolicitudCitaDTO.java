package azj.proyect.clinica.dto;

import lombok.Data;

@Data
public class SolicitudCitaDTO {
    private String dni;
    private int idDisponibilidad;
    private String motivo;
}
