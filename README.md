<h1 align="center"> ReciclavilleAPI</h1>

<p align="center">
  <a href="https://www.java.com/">
    <img alt="Java" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white">
  </a>
  <a href="https://spring.io/projects/spring-boot">
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white">
  </a>
  <a href="https://maven.apache.org/">
    <img alt="Build with Maven" src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white">
  </a>
  <a href="https://flywaydb.org/">
    <img alt="Flyway" src="https://img.shields.io/badge/Flyway-1B7B42?style=for-the-badge&logo=flyway&logoColor=white">
  </a>
  <a href="https://www.postgresql.org/">
    <img alt="PostgreSQL" src="https://img.shields.io/badge/PostgreSQL-336791?style=for-the-badge&logo=postgresql&logoColor=white">
  </a>
    <a href="https://www.postman.com/">
    <img alt="Postman" src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white">
    </a>
</p>

> 🛠️ Projeto desenvolvido como parte da Avaliação Final do módulo Backend do programa **Joinville +tec**, com o objetivo de praticar o uso do **Spring Framework**, **APIs Rest**, **desenvolvimento web e software** e integração com **banco de dados relacional**.

##  Descrição

O ReciclavilleAPI é uma API Rest que facilita o gerenciamento de compensamento de carbono que sua empresa emite.
O usuário pode cadastrar novas declarações de embalagens utilizadas em seus produtos, calcular o quanto precisam 
reciclar para compensar o carbono emitido com suas embalagens e visualizar informações sobre os materiais declarados.

> [!NOTE]
> Este projeto segue o padrão MVC e os princípios da arquitetura REST.



##  Tecnologias

-  **Java 21**
-  **Spring Boot** – Web, DevTools, Lombok, JPA
-  **Maven** – Gerenciador de dependências e build
-  **MapStruct** – Framework para mapeamento de dados (Mappers)
- ️**Flyway** – Ferramenta de migração de banco de dados
-  **PostgreSQL** – Banco de dados relacional
-  **Postman** – Plataforma para teste de APIs


##  Endpoints e Funcionalidades Disponíveis

####  Client
| Método | Endpoint                          | Descrição                                     |
|--------|-----------------------------------|-----------------------------------------------|
| GET    | `/clients`                      | Lista todos os clientes                       |
| GET    | `/clients/{id}`                 | Busca um cliente por ID                       |
| POST   | `/clients`                      | Cadastrar um novo cliente                     |
| PUT    | `/clients/{id}`                 | Atualiza dados de um cliente existente por id |
| DELETE | `/clients/{id}`                 | Remove um cliente por id                      |

####  Material
| Método | Endpoint                        | Descrição                                      | 
|--------|---------------------------------|------------------------------------------------|
| GET    | `/materials`               | Lista todos os materiais                       |
| GET    | `/materials/{id}`          | Busca um material por ID                       |
| POST   | `/materials`               | Cadastra um novo material                      |
| PUT    | `/materials/{id}`          | Atualiza dados de um material existente por id |
| DELETE | `/materials/{id}`          | Remove um material por id                      |

####  Declaration
| Método | Endpoint                        | Descrição                    |
|--------|---------------------------------|------------------------------|
| GET    | `/declarations`               | Lista todas as declarações   |
| GET    | `/declarations/{id}`          | Busca uma declaração por ID  |
| POST   | `/declarations`               | Cria uma nova declaração     |
| DELETE | `/declarations/{id}`          | Remove uma declaração por ID |

####  Dashboard
| Método | Endpoint                        | Descrição                                                                   |
|--------|---------------------------------|-----------------------------------------------------------------------------|
| GET    | `/Dashboard`               | retorna uma lista de dados dos materiais e o total de toneladas a compensar |


#### URL padrão para colar no postman

```bash
http://localhost:8080
```

##  Como Executar

###  Pré-requisitos

- **Java JDK 21**
- **PostgreSQL**
-  **Git**

###  Passos para rodar

**1. Clone o repositório:**

```bash
git clone https://github.com/louisemorais/Reciclaville.git
cd Reciclaville
```
**2. Crie o banco vazio no PostgreSQL**:
   ```sql
   CREATE DATABASE reciclavilleDB;
```
**3. Edite o arquivo ``application.properties``:**
```
### Banco de dados ###
spring.datasource.url=${DB_URL} //url com o nome do seu banco
spring.datasource.username=${DB_USERNAME} // seu username do banco
spring.datasource.password=${DB_PASSWORD}//sua senha do postgre
spring.datasource.driver-class-name=org.postgresql.Driver

### JPA/Hibernate ###
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

### Flyway ###
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration

### Jackson(JSON) ###
spring.jackson.serialization.fail-on-empty-beans=false
spring.jackson.default-property-inclusion=non_null

### Logs ###
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```


**4. Execute a aplicação com Maven Wrapper:**

#### Linux/macOS

```bash
./mvnw spring-boot:run
```

####  Windows

```bash
mvnw.cmd spring-boot:run
```
<br>

---


##  Desenvolvedora

<p align="center">
  <a href="https://github.com/louisemorais">
    <img src="https://github.com/louisemorais.png" width="120" style="border-radius: 50%;" alt="Louise Morais"/>
  </a>
</p>

<p align="center">
  Feito com 💙 por <a href="https://github.com/louisemorais"> louisemorais</a><br
  ><a href="https://www.linkedin.com/in/louisemorais/"><img style="margin-top: 12px" src="https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn"/>

</p>
