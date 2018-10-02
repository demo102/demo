#Bazowy obraz
FROM oraclelinux:7-slim

#https://github.com/oracle/docker-images/issues/47
RUN mkdir -p /usr/share/man/man1

WORKDIR /tmp

COPY dockerrepo/jdk-8u181-linux-x64.rpm .

RUN yum -y install jdk-8u181-linux-x64.rpm && yum clean all

#RUN java -version

COPY target/demo-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","./demo-0.0.1-SNAPSHOT.jar"]
