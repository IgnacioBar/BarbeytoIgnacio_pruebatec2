# Aplicación de Gestión de Turnos 

Este repositorio contiene el desarrollo del backend para una aplicación de gestión de turnos, realizado como parte de la Prueba Técnica Nº 2 - Java Avanzado.

## Descripción del Caso

Una entidad gubernamental necesita del desarrollo de un "turnero" (aplicación de gestión de turnos), donde se puedan almacenar en una base de datos turnos para diferentes trámites y ciudadanos asignados a los mismos.

Los turnos son numéricos y se asignan según orden de llegada. Al mismo tiempo, poseen un estado, el cual puede ser "En espera" o "Ya atendido".

## Funcionalidades

La aplicación permite a los usuarios realizar las siguientes operaciones:

1. **Agregar un Nuevo Turno:** Los usuarios pueden ingresar información sobre un nuevo turno, incluyendo número, fecha y descripción del trámite a realizar. Cada turno está asignado a un ciudadano.

2. **Listar Turnos:** La aplicación muestra la lista de todos los turnos junto con los ciudadanos asignados a los mismos, en base a una fecha brindada por el usuario. Se utiliza una tabla para la presentación de los datos.

3. **Filtrado de Turnos:** Los usuarios pueden seleccionar si desean ver los turnos "En Espera" (que aún no han sido atendidos) o los "Ya atendidos". El filtro principal es la fecha indicada por el usuario, además del estado del turno.

## Requisitos Técnicos

- Desarrollado en Java utilizando Servlets para el backend.
- JSP se emplea para el frontend con Java, con el uso de plantillas o Bootstrap si es necesario.
- Se utiliza JPA para acceder a la base de datos, configurando una fuente de datos y las entidades/tablas con sus atributos y relaciones.
- Colecciones y objetos se utilizan para gestionar los datos antes de interactuar con la base de datos.
- Se emplean funciones lambda, optionals, utils o streams al menos una vez en el código para una mayor consideración respecto al nivel y optimización del código desarrollado.

## Estructura del Proyecto

- `/src`: Contiene los archivos fuente del proyecto Java.
- `/WebContent`: Contiene los archivos JSP y recursos estáticos para el frontend.
- `/Web-INF`: Contiene archivos de configuración y recursos para el servlet.
- `README.md`: Este archivo, proporcionando información sobre el proyecto.

## Autor

Ignacio Barbeyto Madruga - ignacio.barbeyto@gmail.com

