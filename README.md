# proyectofinal
proyecto final
Servicio de tres capas con conexión a API y SQLite
Este repositorio contiene un servicio desarrollado en Java que sigue una arquitectura de tres capas. El servicio se conecta tanto a la API de ChatGPT como al API Country. Además, utiliza una base de datos SQLite para almacenar ciertos datos.

Estructura del proyecto
El proyecto está estructurado de la siguiente manera:

src/: Carpeta principal del código fuente.
main/: Contiene el código principal del servicio.
java/: Contiene los archivos fuente de Java.
com/: Paquete principal del servicio.
example/: Paquete que contiene las clases del servicio.
api/: Paquete que contiene las clases relacionadas con la conexión a las APIs.
database/: Paquete que contiene las clases relacionadas con la base de datos SQLite.
presentation/: Paquete que contiene las clases relacionadas con la capa de presentación.
service/: Paquete que contiene las clases relacionadas con la capa de negocio.
resources/: Contiene los archivos de configuración y recursos del proyecto.
database/: Contiene el archivo de base de datos SQLite.
Requisitos previos
Asegúrate de tener instalado lo siguiente:

Java Development Kit (JDK) versión X.X.X o superior.
Maven versión X.X.X o superior.
Configuración
Clona este repositorio en tu máquina local:

bash
Copy code
git clone https://github.com/tu-usuario/repo.git
Actualiza las siguientes configuraciones en el archivo src/main/resources/config.properties:

properties
Copy code
chatgpt.api.key=your-chatgpt-api-key
country.api.key=your-country-api-key
Ejecuta el siguiente comando para compilar el proyecto:

bash
Copy code
mvn compile
Luego, ejecuta el siguiente comando para ejecutar el proyecto:

bash
Copy code
mvn exec:java -Dexec.mainClass="com.example.presentation.Main"
Uso
Una vez que el servicio se está ejecutando, puedes acceder a él a través de la siguiente URL:

arduino
Copy code
http://localhost:8080/
En la página de inicio, encontrarás diferentes opciones para interactuar con el servicio.

Contribuciones
Si deseas contribuir a este proyecto, puedes seguir estos pasos:

Haz un fork de este repositorio.
Crea una nueva rama para tu función o corrección de errores: git checkout -b feature/branch-name.
Realiza los cambios necesarios y guarda los archivos.
Realiza un commit de tus cambios: git commit -am 'Add some feature'.
Haz push a la rama: git push origin feature/branch-name.
Envía un pull request.
Agradecemos cualquier contribución que puedas hacer para mejorar este servicio.

Contacto
Si tienes alguna pregunta o sugerencia, no dudes en contactarnos a través de [email protected]
