#Bazowy obraz
FROM oraclelinux:7-slim
#docker run -it demo

#https://github.com/oracle/docker-images/issues/47
RUN mkdir -p /usr/share/man/man1

VOLUME /tmp
WORKDIR /tmp

COPY dockerrepo/jdk-8u181-linux-x64.rpm .

RUN yum -y install jdk-8u181-linux-x64.rpm && yum clean all

RUN java -version

COPY target/demo-0.0.1-SNAPSHOT.jar .

#EXPOSE 8010
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","./demo-0.0.1-SNAPSHOT.jar"]