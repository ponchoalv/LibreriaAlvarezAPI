FROM openjdk:8-alpine

COPY target/uberjar/libreria-alvarez-api.jar /libreria-alvarez-api/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/libreria-alvarez-api/app.jar"]
