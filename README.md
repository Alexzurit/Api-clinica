# Sistema Web de Citas Médicas "San Juan"

## Descripción

Sistema web desarrollado con **Spring Boot** para la gestión integral de citas médicas del centro médico "San Juan". El proyecto implementa una arquitectura orientada a servicios (SOA) con API REST, proporcionando una solución completa para la administración de pacientes, médicos, especialidades y citas médicas.

## ¿Para qué sirve?

Este sistema permite:

- **Gestión de Pacientes**: Registro, actualización y consulta de información de pacientes
- **Administración de Médicos**: Control de especialistas, horarios y disponibilidad
- **Programación de Citas**: Reserva, modificación y cancelación de citas médicas
- **Gestión de Especialidades**: Categorización y organización de servicios médicos
- **Reportes y Consultas**: Generación de informes y estadísticas del centro médico
- **Autenticación y Autorización**: Control de acceso seguro al sistema

## Importancia

### Beneficios Clave:
- **Eficiencia Operativa**: Automatiza procesos manuales reduciendo tiempos de espera
- **Organización**: Centraliza la información médica en una sola plataforma
- **Accesibilidad**: Permite gestión remota desde cualquier dispositivo con internet
- **Escalabilidad**: Arquitectura preparada para crecimiento futuro
- **Seguridad**: Implementa mejores prácticas de seguridad en datos médicos
- **Experiencia del Usuario**: Interfaz intuitiva tanto para personal médico como administrativo

## Tecnologías Utilizadas

- **Backend**: Spring Boot 3.x
- **Base de Datos**: MySQL
- **API**: RESTful Web Services
- **Arquitectura**: DTO (Data Transfer Objects)
- **Seguridad**: Spring Security
- **Documentación**: OpenAPI/Swagger
- **Build Tool**: Maven
- **Java**: JDK 17+

## Instalación

### Prerrequisitos

- Java JDK 17 o superior
- Maven 3.6+
- MySQL 8.0+
- Git

### Pasos de Instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/tu-usuario/sistema-citas-medicas-san-juan.git
   cd sistema-citas-medicas-san-juan
   ```

2. **Configurar la base de datos**
   ```sql
   CREATE DATABASE citas_medicas_san_juan;
   CREATE USER 'app_user'@'localhost' IDENTIFIED BY 'tu_password';
   GRANT ALL PRIVILEGES ON citas_medicas_san_juan.* TO 'app_user'@'localhost';
   FLUSH PRIVILEGES;
   ```

3. **Configurar application.properties**
   ```properties
   server.port=8091
   spring.jpa.database=MYSQL
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.datasource.url=jdbc:mysql://localhost:3306/clinicadb?serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=
   spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
   ```

4. **Instalar dependencias y ejecutar**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. **Acceder al sistema**
   - API: `http://localhost:8091`

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/sanjuan/citasmedicas/
│   │       ├── controller/     # Controladores REST
│   │       ├── dto/           # Data Transfer Objects
│   │       ├── entity/        # Entidades JPA
│   │       ├── repository/    # Repositorios de datos
│   │       ├── service/       # Lógica de negocio
│   │       └── config/        # Configuraciones
│   └── resources/
│       ├── application.properties
│       └── data.sql          # Datos iniciales
```

## Endpoints Principales

### Pacientes
- `GET /api/pacientes` - Listar todos los pacientes
- `POST /api/pacientes` - Crear nuevo paciente
- `GET /api/pacientes/{id}` - Obtener paciente por ID
- `PUT /api/pacientes/{id}` - Actualizar paciente
- `DELETE /api/pacientes/{id}` - Eliminar paciente

### Médicos
- `GET /api/medicos` - Listar todos los médicos
- `POST /api/medicos` - Crear nuevo médico
- `GET /api/medicos/{id}` - Obtener médico por ID
- `PUT /api/medicos/{id}` - Actualizar médico

### Citas
- `GET /api/citas` - Listar todas las citas
- `POST /api/citas` - Programar nueva cita
- `GET /api/citas/{id}` - Obtener cita por ID
- `PUT /api/citas/{id}` - Modificar cita
- `DELETE /api/citas/{id}` - Cancelar cita

## Contribuir

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`)
3. Commit tus cambios (`git commit -m 'Agregar nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request


## Contacto

**Equipo de Desarrollo**
- Email: zarblexplay@gmail.com
- Proyecto: Sistema de Citas Médicas San Juan

---

⚕️ **Desarrollado con ❤️ para mejorar la atención médica**
