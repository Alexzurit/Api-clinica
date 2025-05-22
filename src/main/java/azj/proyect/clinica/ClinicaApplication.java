package azj.proyect.clinica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

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

	/*@Bean//se comenta para poder usar postman sin autenticacion que pide cuando se acabe o se implemente un login comentar
	//SecurityConfig
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/

}
