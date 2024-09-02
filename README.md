challenge of backend developer Java Spring Boot

> 1._ Architecture of the challenge
![Screenshot from 2024-09-01 21-45-07](https://github.com/user-attachments/assets/c771b3c4-e6a6-4dbb-a98f-33dbf864f1e9)

> 2.- el proyecto fue solventado utiliaando el siguiente esquema, utilizando microservicios donde se esquematizo el resultado

![Screenshot from 2024-09-01 21-47-39](https://github.com/user-attachments/assets/09908102-bfca-422f-a09d-97b907a26716)


para la solucion se opto por la utilizacion de un config server, en el cual se centraliza toda la configuracion de la aplicacion.
![Screenshot from 2024-09-01 21-46-20](https://github.com/user-attachments/assets/4370d5ea-602d-414d-a65d-ef55016e5b09)

dentro de la solucion se agreo un micro para el servidor de eureka para pdoer monitorear los servicios
![Screenshot from 2024-09-01 21-37-13](https://github.com/user-attachments/assets/4abc2f12-cd10-4357-ac30-908ebc6adfe9)
por medio de este server se puede visualizar que los servicios esten corrienedo en este caso los servicios:
> **msvc-member** el micro que se encarga de la logica de los usuarios
> **msvc-saving** micro que se encarga de la logica de las cuentas

>3.- uso de servidor de gateway para condensar la comunicacion por un solo path como es **localhost:8080**
![Screenshot from 2024-09-01 22-00-22](https://github.com/user-attachments/assets/86d0a000-7eee-46f3-b34d-f9eb99547733)






