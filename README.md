# examen-SpringBoot-Maven-JPA-Java17-MySQL

Diagrama de base de datos
![image](https://github.com/antomunozg/examen-Spring-Maven-JPA/assets/128544282/7da365f0-8832-4c71-ad07-ca7c3525f69b)

Crear una base de datos en MySQL llamada "examendb"
Al estar implementado JPA las entidades seran creadas automaticamente cambiando la propiedad de UPDATE en CREATE en la linea 6
![image](https://github.com/antomunozg/examen-Spring-Maven-JPA/assets/128544282/35207ac3-357e-4a90-aa30-563a07ada7a3)

Para seguir un orden especifico en la solucion del problema planteado en la prueba tecnica se debe realizar los siguientes pasos para consumir los servicios:

NOTA: Los EndPoint y JSON de cada servicio estan en el archivo compartido en el proyecto con la coleccion de Request para uso en Postman.

1. Crear Estudiante:
   *POST
   *http://localhost:8080/estudiantes/

2. Crear Examen con preguntas y opciones:
   *POST
   *http://localhost:8080/examenes/crear
  
3. Asociar Estudiante a Examen:
   *POST
   *localhost:8080/estudiantes/{idEstudiante}/asociar-examen/{idExamen}
   
4. Registrar respuestas de estudiante:
   *POST
   *http://localhost:8080/respuestas/registrar

5. Obtener calculo de respuestas del examen asociado al estudiante:
   *GET
   *localhost:8080/respuestas/recopilar/{estudianteId}/{examenId}

Adicionalmente realice unos servicios para crear preguntas y asociar a examen y crear opciones y asociar a preguntas:

  1. Crear pregunta a examen:
     *POST
     *http://localhost:8080/preguntas/registrar-en-examen/{IdExamen}

  2. Crear opcion a pregunta:
     *POST
     *http://localhost:8080/opciones/crear-y-asociar-a-pregunta/{IdPregunta}


