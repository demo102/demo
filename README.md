# Demo


Demo aplikacji Spring Boot i kontenera Docker  

## Prerekwizyty

1. Java SE Development Kit 8 Downloads (https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. Apache Maven - https://maven.apache.org/download.cgi
3. Docker Community Edition (CE) (https://store.docker.com/search?offering=community&type=edition)
4. Edytor kodu - opcjonalnie
5. curl

https://hub.docker.com/

mvn spring-boot:run
curl http://localhost:8010/demo-app/api/demo/v1/
mvn clean


mvn -DskipTests package


build -t demo .


build -t demo .
docker exec -i -t tomcat13 /bin/bash

docker rm -f <CONTAINER ID>

1. Budowa obrazu
docker build -t demo .
#weryfikacja
docker image ls

2. Uruchomienie obrazu Dockera
docker run -p 5010:8010 demo


docker run --rm -d -p 5010:8010 --name demo1 demo 
docker exec -it <CONTAINER ID> /bin/bash


