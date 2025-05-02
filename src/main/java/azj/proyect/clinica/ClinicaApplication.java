package azj.proyect.clinica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class ClinicaApplication {
	//VERIFICAR AUTOMATICAMENTE LA CONEXION
	// Hola
	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(ClinicaApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void testConnection() throws SQLException {
		System.out.println("Conexion activa: " + dataSource.getConnection().isValid(2));
		//Si es true (se conectó a la DB) de lo contrario seria false creo jajajja
	}


}
