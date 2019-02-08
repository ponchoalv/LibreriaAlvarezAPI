FROM openjdk:8-alpine

COPY target/uberjar/libreria-alvarez-api.jar ./app.jar

EXPOSE 3000

CMD ["java", "-jar", "./app.jar"]
