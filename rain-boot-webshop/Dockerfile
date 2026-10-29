# Tar en färdig image med Maven och Java 21 (JDK) och bygger vidare på det för att kompilera projektet
FROM maven:3.10.0-eclipse-temurin-21 AS build
WORKDIR /app/
COPY pom.xml .
COPY src src
# Packar ihop allt till en .jar-fil och skippar alla tester (contextLoads-testet kräver en databas)
RUN mvn clean package -DskipTests

# Tar en färdig image med Java 21 JRE (ingen Maven) och bygger vidare på det.
FROM eclipse-temurin:21-jre
WORKDIR /app/
# kopierar jar-filen rain-boot-webshop-0.0.1-SNAPSHOT.jar från förra steget (build) till app.jar 
COPY --from=build /app/target/rain-boot-webshop-0.0.1-SNAPSHOT.jar app.jar
# talar om att appen i containern lyssnar på port 8080
EXPOSE 8080
# Kommandot som körs när containern startar: startar backenden med java -jar
#["java",   "-jar",   "app.jar"]
#  ─────    ──────    ─────────
# program   "kör en    vilken
#           jar-fil"   fil
ENTRYPOINT ["java", "-jar", "app.jar"]