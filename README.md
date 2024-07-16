# Foro-hub

Esta es una API REST creada usando Spring

---

## Funcionalidades

Este proyecto es una API REST con las siguientes funcionalidades:

-API con rutas implementadas siguiendo las mejores prácticas del modelo REST y debe permitir a los usuarios: 
  -Crear un nuevo tópico;
  -Mostrar todos los tópicos creados;
  -Mostrar un tópico específico;
  -Actualizar un tópico;
  -Eliminar un tópico.

-Validaciones realizadas según las reglas de negocio.

-Implementación de una base de datos relacional para la persistencia de la información.

-Servicio de autenticación/autorización para restringir el acceso a la información.

---

## Tecnologías Utilizadas

Enumera las tecnologías principales que has utilizado en tu proyecto:

- Java JDK 17
- Spring Boot 3.3.1
- MySQL 8
- Maven 4
- Postman

---

##Endpoints

Los principales Endpoints de la aplicación son:

*Login de usuario previamente registrado en la BD con contraseña encriptada con Bcrypt:

```
POST /login
```
Este Endpoint te regresará un JWT

![Pasted Graphic 16](https://github.com/user-attachments/assets/a0d3ca1b-e9ca-4301-8a0d-be2a7419883c)

Mismo que deberas copiar para utilizarlo en la parte Authorization type Bearer token para acceder a los otros Endpoints:

![Pasted Graphic 14](https://github.com/user-attachments/assets/4edfe06f-6440-459e-b60c-68df456d62d0)


*Registro de un nuevo tópico:

```
POST /topics
```
Crea un nuevo tópico con los datos proporcionados.Este un ejemplo del cuerpo de la solicitud:

![image](https://github.com/user-attachments/assets/f1e79343-60b2-4605-a299-d1ace2b76771)

Y recibirá una respuesta similar a esta:

![image](https://github.com/user-attachments/assets/0ac18b38-e97d-4ae7-8e02-9b24d71330bf)


*Listado de tópicos:

```
GET /topics
```

Devuelve una lista paginada de todos los tópicos.

![image](https://github.com/user-attachments/assets/051d622c-3a1b-4c71-81e7-184825e4d364)


*Búsqueda de tópicos por nombre de curso:

```
GET /topics/search?courseName={nombre_del_curso}
```
Devuelve una lista paginada de tópicos que coinciden con el nombre del curso especificado.

![Pasted Graphic 17](https://github.com/user-attachments/assets/40e440ba-e30b-431b-ba92-0f0e3230382e)


*Obtención de información detallada de un tópico por ID:

```
GET /topics/{id}
```
Devuelve la información detallada de un tópico específico según su ID.

![Pasted Graphic 18](https://github.com/user-attachments/assets/3fe8394b-15f2-450e-87ce-8f1f906fe9a9)


*Actualización de un tópico existente:

```
PUT /topics/{id}
```
Actualiza los datos de un tópico existente según su ID.
![Pasted Graphic 19](https://github.com/user-attachments/assets/4960c9c3-f320-4cf8-bcfb-2046e3d817bb)


*Eliminación de un tópico por ID:

```
DELETE /topics/{id}
```
Elimina un tópico específico según su ID.
![Pasted Graphic 20](https://github.com/user-attachments/assets/65f17768-247f-45f0-812f-5798d3b98b6c)

