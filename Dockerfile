FROM openjdk:17-oracle
ADD target/ordem-servico*.jar app
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "app"]