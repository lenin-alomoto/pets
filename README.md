# 🐾 Pet Management API

Una aplicación REST construida en Java con Spring Boot y arquitectura hexagonal, para gestionar el registro y consulta de mascotas, consultando varios datos desde una API externa.

---

## 🌐 Descripción General

Esta aplicación permite:

- Registrar mascotas con datos básicos (nombre, edad, dirección, ciudad y raza).
- Consultar información de razas desde la API [The Dog API](https://api.thedogapi.com/v1/breeds).
- Enriquecer los datos del registro con peso, altura, grupo de raza, temperamento, etc.
- Consultar mascotas registradas aplicando diversos filtros.
- Seguridad mediante autenticación básica.
- Optimización con caché para evitar llamadas repetidas a la API externa.

---

## 🪧 Tecnologías Usadas

- Java 17
- Spring Boot 3.5.3
- Spring Data JPA
- Spring Security
- H2 Database (memoria)
- MapStruct (para mapeo entre capas)
- RestTemplate (consumo de API externa)
- JUnit 5 y Mockito (testing)
- Docker + Docker Compose

---

## 🔍 Características

### Registro de Mascotas

- Se realiza vía `POST /v1/app/mange-pet`
  - Estructura ejemplo:

    {
        "name": "Pecosa5",
        "age": 7,
        "adrres": "Madrigal",
        "city": "Quito",
        "breed": "Terrier"
    }
- Se recibe un `PetRequest` y se completa la información con datos de la API externa según la raza.

### Filtros Disponibles

`GET /v1/app/mange-pet/filter`

- Por grupo de raza
- Por raza
- Por rango de edad
- Por rango de peso (mínimo y máximo en kg)
- Por rango de altura (mínimo y máximo en cm)

Ejemplo de uso:

```http
GET /v1/app/mange-pet/filter?breed=Retriever&minWeight=20&maxWeight=30
```

### Seguridad

- Se usa **autenticación básica** configurada desde `application.properties` o usando variables de entorno.

#### Configuración por defecto (`application.properties`):

```properties
spring.security.user.name=${SECURITY_USER:springadmin}
spring.security.user.password=${SECURITY_PASSWORD:security123}
```

#### Uso con `.env` (para Docker Compose):

```env
SECURITY_USER=admin
SECURITY_PASSWORD=admin123
```

#### docker-compose.yml:

```yaml
services:
  pet-api:
    build:
      context: .
    ports:
      - "8080:8080"
    environment:
      - SECURITY_USER=${SECURITY_USER}
      - SECURITY_PASSWORD=${SECURITY_PASSWORD}
```

- Endpoints protegidos: `/v1/app/mange-pet/**`
- Consola H2 habilitada para desarrollo: `/h2-console`

### Caché

- Implementado con `@Cacheable("dogBreeds")` para evitar llamar a la API de perros en cada petición.
- El cache almacena todas las razas obtenidas en la primera llamada.

---

## 📂 Arquitectura

### Capas principales:

- **Dominio:**
  - modelos: `Pet`, `Measurement`, `PetFilter`
  - repository: `ManagePetRepositoryPort`, `PetApiRepositoryPort`
  - usecase: `ManagePetUseCase`, `PetApiUseCase`
- **Aplicación:** `ManagePetUseCaseImpl`, `PetApiUseCaseImpl`
- **Infraestructura:**
  - Adaptadores: `PetApiRepositoryAdapter`, `ManagerPetRepositoryAdapter`
  - Controlador: `PetController`
  - Mappers: `PetMapper`, `PetRestMapper`
  - DTOs: `PetRequest`, `PetResponse`, `PetFilterRequest`

### Base de Datos

- Entidad persistente `PetEntity` con campos para `minWeight`, `maxWeight`, `minHeight`, `maxHeight` para permitir filtros precisos.

---

## 🔍 Ejecución Local

1. Clona el repositorio:

```bash
git clone https://github.com/lenin-alomoto/pets.git
```

2. Ingresa a la carpeta: pets

```bash
cd pets
```

3. Si existe el .env siga al siguiente punto caso contrario créelo con lo siguiente:

   SECURITY\_USER=admin
   SECURITY\_PASSWORD=admin123

4. Ejecuta:

```bash
docker-compose --env-file .env up --build
```

5. Accede a:

- `http://localhost:8080/h2-console` para la base de datos
- `http://localhost:8080/v1/app/mange-pet` para los endpoints

---

### Solución a error común:

Si ves un error como:

```
unable to get image 'pets-app': error during connect: open //./pipe/dockerDesktopLinuxEngine
```

- Asegúrate de que **Docker Desktop esté ejecutándose**
- Ejecuta `docker info` para verificar conectividad
- Reinicia Docker si es necesario

---

## 📊 Testing

### Pruebas incluidas:

- Unitarias para adaptadores, use cases y controladores.
- Mock del API externa

---

## 📆 Mejoras Futuras

- Implementar JWT en lugar de autenticación básica
- Persistencia en base de datos relacional como PostgreSQL
- Paginar resultados del filtro
- Agregar Swagger / OpenAPI
- Monitoreo de salud de API externa

---

## 🙏 Autor

Lenin Alomoto\
Proyecto desarrollado para la prueba técnica en Java con Spring para hiberus

