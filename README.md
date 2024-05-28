# Gerenciamento_de_Granja_De_Patos
Esta é uma API REST desenvolvida com Java e Spring Boot para gerenciar uma granja de patos. A aplicação permite o cadastro individual de patos, a venda de patos para clientes, e a geração de relatórios em formatos Excel e PDF.

#Funcionalidades:
<p1>Cadastro de Patos</p1>
Endpoint para cadastrar patos com detalhes como nome, status, preço e mãe.
Cada pato pode ser registrado com a indicação de sua mãe para melhor rastreamento.
Cadastro de Clientes
Endpoint para cadastrar clientes, incluindo nome e elegibilidade para desconto.
Cada cliente pode ser indicado como elegível ou não para desconto.
Venda de Patos
Endpoint para registrar vendas de patos para clientes cadastrados.
Aplicação de desconto de 20% para clientes elegíveis.
Registro automático da data da venda.
Listagem de Patos Vendidos
Endpoint para listar todos os patos vendidos, incluindo a data da venda e o cliente que comprou.
Geração de Relatórios
Endpoints para gerar relatórios de gerenciamento de patos em formatos Excel e PDF.
Relatórios incluem informações detalhadas sobre os patos cadastrados, patos vendidos e as respectivas transações.
Tecnologias Utilizadas
Java: Linguagem de programação principal.
Spring Boot: Framework para criar a API REST.
JPA/Hibernate: Para persistência de dados.
MySQL/PostgreSQL: Base de dados para armazenar informações.
Apache POI: Biblioteca para geração de relatórios em Excel.
JasperReports: Biblioteca para geração de relatórios em PDF.
Docker: Para containerização da aplicação.
Flyway: Para gerenciamento de migrações do banco de dados.
Requisitos de Instalação
Java 11 ou superior
Maven para gerenciamento de dependências
Docker para containerização da aplicação
Configuração Inicial
Criação do Projeto
O arquivo pom.xml foi inicialmente criado pelo Spring Initializr. A dependência do JasperReports foi adicionada manualmente.

xml
Copiar código
<dependency>
    <groupId>net.sf.jasperreports</groupId>
    <artifactId>jasperreports</artifactId>
    <version>6.17.0</version>
</dependency>
Configuração do Docker
Instale o Docker seguindo as instruções da documentação oficial.
Crie o arquivo docker-compose.yml para definir os serviços necessários.
yaml
Copiar código
version: '3.8'

services:
  db:
    image: mysql:8.0
    container_name: pato_db
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: patos
      MYSQL_USER: user
      MYSQL_PASSWORD: password
    ports:
      - "3306:3306"
    volumes:
      - db_data:/var/lib/mysql

  app:
    image: openjdk:11
    container_name: pato_app
    ports:
      - "8080:8080"
    volumes:
      - .:/app
    working_dir: /app
    command: mvn spring-boot:run
    depends_on:
      - db

volumes:
  db_data:
Configuração do Banco de Dados
No arquivo application.properties, configure as credenciais e URL do banco de dados:

properties
Copiar código
spring.datasource.url=jdbc:mysql://db:3306/patos
spring.datasource.username=user
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update

spring.flyway.enabled=true
spring.flyway.baseline-on-migrate=true
Iniciando a Aplicação
Após toda a configuração, utilize o comando abaixo no Git Bash para iniciar os serviços:

bash
Copiar código
docker-compose up
Estrutura do Projeto
Modelos
Cliente
Pato
Venda
DTOs
VendaRequest
Repositórios
ClienteRepository
PatoRepository
VendaRepository
Serviços
ClienteService
PatoService
VendaService
RelatorioExcelService
RelatorioPdfService
Controladores
ClienteController
PatoController
VendaController
RelatorioController
Relatórios
Geração de relatórios em Excel com Apache POI.
Geração de relatórios em PDF com JasperReports.
Diferenciais
Utilização de Docker para containerização.
Utilização do Flyway para gerenciamento de migrações do banco de dados.
Testes unitários para validação das funcionalidades.
Autor
Desenvolvido por [Seu Nome].

