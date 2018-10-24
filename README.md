
# Spring Boot

Demo aplikacji Spring Boot

## Prerekwizyty
1. Utworzyć katalog  
C:\springboot  
2. Pobrać i zainstalować do katalogu C:\springboot Java SE Development Kit 8u191  
https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html  

![](/images/jdk1.png)  
![](/images/jdk2.png)  
![](/images/jdk3.png)  
![](/images/jdk4.png)  
![](/images/jdk5.png)  
![](/images/jdk6.png)  

2. Pobrać i zainstalować Eclipse IDE, np. Eclipse SimRel  


http://www.eclipse.org/downloads/packages/installer

Zainstalowac Eclipse IDE for Java Developers
![](/images/eclipse1.png)  
![](/images/eclipse2.png)  
![](/images/eclipse3.png)  


3. Apache Maven
https://maven.apache.org/download.cgi  
http://apache.hippo.nl/maven/maven-3/3.5.4/binaries/apache-maven-3.5.4-bin.zip  

Plik apache-maven-3.5.4-bin.zip rozpakować do C:\springboot  


4. Apache Derby  
https://db.apache.org/derby/releases/release-10.14.2.0.cgi  
Plik db-derby-10.14.2.0-bin.zip rozpakować do C:\springboot  

Uruchomic bazę:   
> cd C:\springboot\db-derby-10.14.2.0-bin\bin  
> startNetworkServer  


5. curl  
https://curl.haxx.se/windows/dl-7.61.1_6/curl-7.61.1_6-win64-mingw.zip  
lub  
Insomnia  
https://insomnia.rest/  


## Zmienne środowiskowe

Windows 7 – Prawy klik My Computer i wybrac Properties > Advanced   
Windows 8 – Control Panel > System > Advanced System Settings  
Windows 10 – Win+s Environment Variables i wybrac Edit the system environment variables   

JAVA_HOME
C:\springboot\Java\jdk1.8.0_191

M2_HOME
C:\springboot\apache-maven-3.5.4\bin

MAVEN_HOME
C:\springboot\apache-maven-3.5.4


![](/images/env1.png)  
![](/images/env2.png)  
![](/images/env5.png)  
![](/images/env6.png)  



## Spring Boot  
1. pobierze https://github.com/demo102/demo/archive/master.zip  
2. rozpakuj demo-master.zip  
3. uruchom: mvn spring-boot:run  
4. zweryfikuj: curl http://localhost:7070/demo/hello  
5. posprzątaj: mvn clean  
6. przygotuj paczkę: mvn -DskipTests package  



linki:
https://start.spring.io/
https://mvnrepository.com/
https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html