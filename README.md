# User API Ejercicio

API REST para guardar usuarios y obtenerlos utilizando springboot.
## Tech stack

- Java 8
- Springboot
- Gradle
- Docker & Docker compose
- Junit & Mockito

## Development

1. 🔨 Sientete libre de modificar el código 

    > Si modificas algún endpoint recuerda actualizar [endpoint documentation](./endpoints.md)

1. ⚙️  Build and test with Docker compose

    ```sh
    $ ./gradlew build && docker-compose build && docker-compose up
    ```

1. 🚀 Test the API with postman

##Runtime

1. Para correr el API debes ubicarte en la carpeta raíz del proyecto.
1. Una vez en la carpeta Raíz ejecuta el siguiente comando siempre que tengas instalado docker y docker-compose

    ```sh
    $ ./gradlew build && docker-compose build && docker-compose up
    ```
1. Con esto es suficiente para levantar el API, todas las variables de entorno y configuraciones se encuentran en [docker-compose-yml](./docker-compose.yml)

##Disclaimer
Si por algún motivo no logras instalar docker y docker-compose, no te preocupes, puedes correr el API desde tu IDE o desde el compilado ejercicioJava.jar luego de hacer build con gradle ubicado en .builds/libs. <br>
Recuerda configurar las variables de ambiente.


##Variables de ambiente
- **regexEmail**: `^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z][cl])$`
- **emailPattern**: `aaaaaaa@dominio.cl`
- **regexPassword**: `^(?=.{4,}$)(?=(?:.*[A-Z]))(?=.*[a-z])(?=(?:.*[0-9]){2}).*`
- **inValidPasswordMessage**: `La contraseña debe tener una mayúscula, al menos una minuscula y 2 digitos.`
