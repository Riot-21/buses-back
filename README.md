# Backend - API de Buses

## Tecnologías Utilizadas
- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Maven**

### Configuración de la Base de Datos
1. Crear una base de datos en MySQL:
   ```sql
   CREATE DATABASE buses_db;
   ```
2. Configurar las credenciales en `application.properties` o `application.yml`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/buses_db
   spring.datasource.username=usuario
   spring.datasource.password=contraseña
   spring.jpa.hibernate.ddl-auto=update
   ```

### Ejecución del Proyecto
Para ejecutar el proyecto, usa el siguiente comando en la terminal:
```sh
mvn spring-boot:run
```

## Endpoints
### 1. Obtener todos los buses (con paginación y filtro de activos)
- **URL:** `GET /bus`
- **Parámetros opcionales:**
  - `page` (Número de página, por defecto `0`)
  - `size` (Cantidad de elementos por página, por defecto `10`)
  - `activo` (Filtrar por buses activos, por defecto `true`)
- **Ejemplo de petición:**
  ```sh
  GET http://localhost:8080/bus?page=0&size=10&activo=true
  ```
- **Ejemplo de respuesta:**
  ```json
  {
    "content": [
      {
        "id": 1,
        "numeroBus": "101",
        "placa": "ABC123",
        "caracteristicas": "Asientos cómodos",
        "marca": { "id": 1, "nombre": "Volvo" },
        "activo": true,
        "fechaCreacion": "2025-03-31T14:01:45"
      }
    ],
    "totalPages": 2,
    "totalElements": 20,
    "size": 10,
    "number": 0
  }
  ```

### 2. Obtener un bus por ID (TRAE SOLO CON CAMPO ACTIVO(TRUE))
- **URL:** `GET /bus/{id}`
- **Ejemplo de petición:**
  ```sh
  GET http://localhost:8080/bus/1
  ```
- **Ejemplo de respuesta:**
  ```json
  {
    "id": 1,
    "numeroBus": "101",
    "placa": "ABC123",
    "caracteristicas": "Asientos cómodos",
    "marca": { "id": 1, "nombre": "Volvo" },
    "activo": true,
    "fechaCreacion": "2025-03-31T14:01:45"
  }
  ```





