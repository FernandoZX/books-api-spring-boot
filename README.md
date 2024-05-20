# BOOKS and Author APIS

Proyecto de ejemplo de una rest API

[![MIT licensed][shield-mit]](LICENSE)
[![Java v21][shield-java]](https://openjdk.java.net/projects/jdk/21/)
[![Spring Framework v6][shield-spring]](https://jakarta.ee/specifications/platform/10/)
[![Spring Boot v3][shield-spring-boot]](https://jakarta.ee/specifications/platform/10/)
[![Docker][shield-docker]](https://www.docker.com/)
[![Oracle XE21c][shield-oracle]](https://www.oracle.com/database/technologies/appdev/xe/quickstart.html)

## Requisitos

Lista requerida para compilar y ejecutar el proyecto

* Open JDK 21
* Apache Maven 3.9.6

Los requisitos particular sera proveeido a la rama princial 'README.md'

## Compilado

En order para compilar el proyecto ejecuta el siguiente comando:

```bash
mvn clean package
```

If your default `java` is not from JDK 21 use (in `book-api-spring-boot` directory):

```bash
JAVA_HOME=<path_to_jdk_home> mvn package
```

## Configuracion

Las configuraciones seran actualizada en `application.yml` o variables de entorno

## Ejecucion

En orden que la aplicacion se ejecuto en Apache Tomcat

```bash
java -jar target/book-api-spring-boot-1.0.0-SNAPSHOT.jar
```

## Ejecucion En desarrollo

puedes abrir el editor de tu preferencia como Intellij o eclipse

compilar > ejecutar proyecto



