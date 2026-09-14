#FROM eclipse-temurin:21-jdk AS build
#WORKDIR /app
#
#COPY . .
#RUN chmod +x mvnw && ./mvnw clean package -DskipTests
#
#FROM eclipse-temurin:21-jre
#WORKDIR /app
#
#COPY --from=build /app/target/*.jar app.jar
#
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app.jar"]



FROM eclipse-temurin:21-jdk AS build

COPY . /usr/src/app
RUN mvn --batch-mode -f /usr/src/app/pom.xml clean package

FROM eclipse-temurin:21-jdk
ENV PORT 8080
EXPOSE 8080
COPY --from=BUILD /usr/src/app/target /opt/target
WORKDIR /opt/target

CMD ["/bin/bash", "-c", "find -type f -name '*-SNAPSHOT.jar' | xargs java -jar"]
