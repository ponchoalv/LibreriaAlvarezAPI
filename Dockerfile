FROM openjdk:8-alpine

COPY target/uberjar/libreria.jar /libreria/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/libreria/app.jar"]
