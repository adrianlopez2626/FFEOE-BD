# FFEOE-BaseDatos

Proyecto de backend desarrollado con **Spring Boot** y **Java 17**. Este repositorio contiene la API y la estructura de base de datos para la gestión del dominio del proyecto (impresoras, empleados, etc.).

## 📋 Requisitos Previos

Asegúrate de tener instalados los siguientes componentes a nivel de sistema antes de iniciar el proyecto:

- **Java Development Kit (JDK) 17** o superior.
- **Maven** (opcional, ya que el proyecto incluye el ejecutable `mvnw`).
- **MariaDB** instalado de manera local o mediante Docker.

## ⚙️ Configuración de la Base de Datos

El proyecto está preconfigurado para conectarse a una base de datos local de **MariaDB**. Revisa y ajusta (si es necesario) los parámetros en el archivo de entorno ubicado en:
`src/main/resources/application.properties`

**Credenciales y conexión esperadas por defecto:**
- **URL de conexión:** `jdbc:mariadb://localhost:3306/toner_db`
- **Nombre de la base de datos:** `toner_db`
- **Usuario:** `root`
- **Contraseña:** `admin123`

### Pasos previos en la base de datos:
Antes de arrancar el servidor, debes crear la base de datos en MariaDB:
```sql
CREATE DATABASE toner_db;
```
*No es necesario crear manualmente las tablas*. El proyecto usa Hibernate con la propiedad `spring.jpa.hibernate.ddl-auto=update`, lo que creará/actualizará automáticamente el esquema (las tablas para Empleados, Impresoras, etc.) en cuanto se inicie por primera vez.

## 🚀 Instalación y Empaquetado

Para compilar el proyecto y descargar todas las dependencias necesarias de Spring Boot y MariaDB, ejecuta en la raíz del proyecto:

En sistemas Linux/Mac:
```bash
./mvnw clean package -DskipTests
```

En sistemas Windows:
```cmd
mvnw.cmd clean package -DskipTests
```

## ▶️ Arranque del Proyecto (Despliegue)

Puedes iniciar o desplegar el servidor de las siguientes formas:

### Opción 1: Usando Spring Boot Maven Plugin (Recomendado para desarrollo)
Evitando la necesidad de compilar un `.jar`, en la consola o terminal dentro del directorio del proyecto lanza:
```bash
./mvnw spring-boot:run
```

### Opción 2: Ejecutando directamente el JAR (Recomendado para producción/servidor)
Tras utilizar el comando `package` del paso anterior, se habrá generado un ejecutable en la carpeta `target`.
```bash
java -jar target/FFEOE-BaseDatos-0.0.1-SNAPSHOT.jar
```

### Opción 3: A través de tu IDE
- Importa o abre la carpeta como un proyecto **Maven** en tu IDE de preferencia (IntelliJ IDEA, Eclipse, VS Code).
- Busca la clase de punto de entrada o *Main*: `src/main/java/com/jpa/FFEOE/BaseDatos/FfeoeBaseDatosApplication.java`.
- Haz clic derecho y pulsa en **Run FfeoeBaseDatosApplication** (Ejecutar).

---

## 📄 Documentación Adicional e Información de Acceso

- **Puerto del Servidor:** La aplicación se despliega a través de un servidor web Tomcat embebido y atiende peticiones en el puerto local **9000**: `http://localhost:9000`.
- **Ruta Base de la API (Base Path):** Para las peticiones a la API o repositorios exportados mediante REST, todas las URL base inician con el prefijo `/api` (configurado mediante `spring.data.rest.base-path=/api`).
- **Logs:** El nivel de logging para SQL está configurado a `DEBUG` para ver con alto detalle las consultas que la API ejecuta internamente. Esto es útil para el entorno de desarrollo y monitorización, y se puede modificar posteriormente.
