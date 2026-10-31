# Atelier 6 : Docker

```bash
cd entreprise-microservice
mvn clean package -DskipTests
docker build . -t <username>/entreprises:v1
docker run -d -p 8080:8080 <username>/entreprises:v1
```
Test: http://localhost:8080/api/entreprises/IT