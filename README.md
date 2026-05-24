# TAREA2-DOO
# Integrantes:
 Matias Cabello
 Maximiliano Pinto
 Paulo Torres


#Justificacion UML:
 
-Creamos la superclase `Persona` (Herencia y Polimorfismo): Extrají los atributos comunes de los usuarios (`nombre`, `apellido`, `correo`) que originalmente pertenecían a `Empleado` hacia `Persona`. Ahora `Empleado` hereda de ella, dejando únicamente su `id` como atributo unico.

-Incorporamos la clase InvExterno: Para poder invitar a personas que no pertenecen a la empresa se hereda de la superclase 'Persona', Asi reunion y otras clases tratan a Empleados y InvExterno de forma polimorfica cuando se arman listas y se ve la asistencia/restraso.

-Adaptamos Asistencia e Invitacion: Como ahora existe la superclase 'Persona', ambas clases se relacionan con ella. Invitacion usa la interfaz 'Invitable' que posee 'Persona', y asi se puede invitar a cualquiera que la implemente sin modificar la logica de Reunion

-Creacion Informe Reunion: Añadimos la nueva clase ase encargada exclusivamente de tomar los datos y exportarlos a un archivo de texto. La separamos de la jerarquía de `Reunion` para evitar complicaciones innecesarias; la reunión almacena y gestiona su informacion, mientras que el informe maneja la informacion de Reunion
y la pone en un archivo.txt