
# Spring Boot

Demo aplikacji Spring Boot

```
curl -H "Content-Type: application/json" -X POST -d '{	"komunikat": "to jest test", "msg": "1"}' http://localhost:7060/post
```
```
mvn spring-boot:run
mvn package
java -jar demo-0.0.1-SNAPSHOT.jar
mvn clean  
```

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

SQL:  
> ij> connect 'jdbc:derby://localhost:1527/demo';


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

PATH=%JAVA_HOME%\bin;%MAVEN_HOME%\bin;%PATH%


![](/images/env1.png)  
![](/images/env2.png)  
![](/images/env5.png)  
![](/images/env6.png)  



## Spring Boot
1. https://start.spring.io/  
2. Wybrać Web
![](/images/spring1.png)  

3. Wygenerowany demo1.zip rozpakować do C:\springboot\eclipse-workspace

4. Z linii polecen przejść do C:\springboot\eclipse-workspace\demo1
i wykonac polecenie  
mvn eclipse:eclipse

5. Zaimportować projekt demo1 do Eclipse

Wybrać katalog C:\springboot\eclipse-workspace\demo1  
![](/images/import1.png)  
![](/images/import2.png)  
![](/images/import3.png)  

Z linii polecen przejść do C:\springboot\eclipse-workspace\demo1  
i wykonac polecenie  
mvn spring-boot:run  


## Schronisko

1. Wygenerować projekt  

![](/images/schronisko1.png)  

2. pom.xml  
```xml
<dependency>
	<groupId>org.apache.derby</groupId>
    	<artifactId>derbyclient</artifactId>
		<version>10.14.2.0</version>
</dependency>
```

3. Model  
```java
package com.example.schronisko.model;
```

```java
@Entity
public class Pies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nazwa;
	@Column(name="race")
	private String rasa;
		
}
```
> Alt + Shift + s r  

4. DAO https://pl.wikipedia.org/wiki/Data_Access_Object  

```java
package com.example.schronisko.dao;
```

```java
package com.example.schronisko.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.schronisko.model.Pies;

@Repository
public interface PiesRepository extends JpaRepository<Pies, Long> {

}
```
> application.properties

```
spring.datasource.url=jdbc:derby://localhost:1527/demo;create=true
spring.datasource.driver-class-name=org.apache.derby.jdbc.ClientDriver
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
```


Uruchomić bazę danych:  
> c:\springboot\Java\db-derby-10.14.2.0-bin\bin\startNetworkServer  

Uruchomić klienta sql:  
> c:\springboot\Java\db-derby-10.14.2.0-bin\bin\ij
> ij> connect 'jdbc:derby://localhost:1527/demo';
> ij> select * from pies;

5. Kontroler

```java
package com.example.schronisko.view;
```

```java
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.schronisko.dao.PiesRepository;
import com.example.schronisko.model.Pies;
```

```java
@RestController
@RequestMapping(value = "/psy")
public class PiesController {

```

```java
private final static Logger LOG = LoggerFactory.getLogger(PiesController.class);
```


```java
	@Autowired
	private PiesRepository piesRepository;

	@GetMapping("/")
	public List<Pies> psy() {
		LOG.info("pobieram psy");
		return piesRepository.findAll();
	}

	@GetMapping("/{id}")
	public Pies pies(@PathVariable Long id) {
		LOG.info("pobieram psa, id={}", id);
		return piesRepository.findById(id).get();
	}

	@PostMapping("/")
	public Pies zapiszPsa(@RequestBody Pies pies) {
		pies = piesRepository.save(pies);
		return pies;
	}

	@PutMapping("/{id}")
	public Pies edytujPsa(@PathVariable Long id, @RequestBody Pies piesDto) {
		Pies pies = piesRepository.findById(id).get();
		pies.setNazwa(piesDto.getNazwa());
		pies.setRasa(piesDto.getRasa());
		pies.setUwagi(piesDto.getUwagi());

		pies = piesRepository.save(pies);
		return pies;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> usunPsa(@PathVariable Long id) {
		try {

			piesRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			LOG.error("Blad aplikacji", e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
```

5. Serwis

```java
package com.example.schronisko.view;
```




```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.schronisko.dao.PiesRepository;
import com.example.schronisko.model.Pies;
```

```java
@Service
public class PiesService {

	private final static Logger LOG = LoggerFactory.getLogger(PiesService.class);

	@Autowired
	private PiesRepository piesRepository;

	public Pies zapiszPsa(Pies pies) {
		LOG.debug("zapisuje psa");

		return piesRepository.save(pies);
	}
}
```
Wróć do PiesController  

```java
	@Autowired
	private PiesService piesService;
```

```java
	@PostMapping("/")
	public Pies zapiszPsa(@RequestBody Pies pies) {
		LOG.info("zapisuje psa");
//		pies = piesRepository.save(pies);
		pies = piesService.zapiszPsa(pies);
		return pies;
	}
```

## Stronka

1. Wygenerować projekt  

![](/images/stronka1.png)  

2. Model

```java
package com.example.stronka.model;

public class Kot {

	private String nazwa;
	private String rasa;

	//Getters and setters
```

## Spring Acutator
```xml
	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
	</dependency>
```
Dopisać w application.properties:  
```
management.endpoints.web.exposure.include=*  
management.endpoint.health.show-details=always
```  

http://localhost:7060/actuator  
http://localhost:7060/actuator/threaddump 

http://localhost:7060/actuator/health  
```
{
  "status": "UP",
  "details": {
    "diskSpace": {
      "status": "UP",
      "details": {
        "total": 126607159296,
        "free": 65025572864,
        "threshold": 10485760
      }
    }
  }
}
```
https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/actuate/system/DiskSpaceHealthIndicator.html  


## Devtools

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
	<optional>true</optional>
</dependency>
```

### Testy

pom.xml
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>
```

```java
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
```

```java
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
```

```java
	@Autowired
	private MockMvc mvc;
	@Test
	public void testujHello() throws Exception {
		mvc.perform(get("/hello"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.xxx").value("ala ma kota"));
		
	}
```

> mvn test

> mvn -DskipTests spring-boot:run


### Konspumpcja

```java
@Configurable
@SpringBootApplication
public class SchroniskoApplication {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
```

PiesController:  
```java
@Autowired
private RestTemplate restTemplate;

```

```java
	ResponseEntity<String> helloRes = restTemplate.getForEntity("http://localhost:7060/hello", String.class);

	ResponseEntity<String> helloRes = restTemplate.getForEntity("http://localhost:7060/hello", String.class);

	LOG.trace(helloRes.getBody());
	ObjectMapper mapper = new ObjectMapper();
	JsonNode root = mapper.readTree(helloRes.getBody());
		
	LOG.trace("czas={}", root.path("czas"));


```




Przydatne linki:  
https://start.spring.io/  
https://mvnrepository.com/  
https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html  

Alternatyw dla Tomcata: http://undertow.io/  