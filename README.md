# Demo


Demo aplikacji Spring Boot i kontenera Docker  

## Prerekwizyty

1. Java SE Development Kit 8 Downloads https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
2. Apache Maven - https://maven.apache.org/download.cgi
3. Docker Community Edition (CE) https://store.docker.com/search?offering=community&type=edition
4. Edytor kodu - opcjonalnie
5. curl - opcjonalnie



## Spring Boot
1. pobierze https://github.com/demo102/demo/archive/master.zip
2. rozpakuj demo-master.zip
3. uruchom: mvn spring-boot:run
4. zweryfikuj: curl http://localhost:8010/demo-app/api/demo/v1/
5. posprzątaj: mvn clean
6. przygotuj paczkę: mvn -DskipTests package


## Docker

1. Zbuduj obraz
docker build -t demo .
2. Zweryfikuj czy się zbudowało
docker image ls
3. Uruchom obraz Dockera
docker run --rm -d -p 5010:8010 --name demo1 demo 
4. Połącz się z kontenerem
docker exec -it "CONTAINER ID" /bin/bash


linki:
https://hub.docker.com/
https://github.com/oracle/docker-images
