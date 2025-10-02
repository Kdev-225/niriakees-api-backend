# Étape 1 : Utiliser une image Maven pour builder l'application
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copier le fichier pom.xml et télécharger les dépendances
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copier le code source et compiler
COPY src ./src
RUN mvn clean package -DskipTests

# Étape 2 : Image finale avec JDK 17
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copier le jar compilé depuis l'étape précédente
COPY --from=build /app/target/*.jar app.jar

# Exposer le port 8080
EXPOSE 8080

# Commande de lancement
ENTRYPOINT ["java", "-jar", "app.jar"]
