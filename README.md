# DevSuperior projetos

Repositório contendo os desafios corrigidos em forma de projetos no curso de especialização no framework Spring, abordando assunos como:
- Módulo 01: Web services REST, padrão DTO, CRUD completo, tratamento de exceções, dados de auditoria e paginação de dados.
- Módulo 02: Testes automatizados (TDD, JUnit, mockar dependências com Mockito e MockBean, realizar assertions).
- Módulo 03: Validação e segurança (validação de dados com Bean Validation, autenticação e autorização com OAuth2 e JWT).
- Módulo 04: Domínio e ORM, autorizações (modelo conceitual complexo com ORM e seed de banco de dados, criar autorizações customizadas: em nível de serviço, conteúdo customizado para o usuário logado, refresh token, pré-autorização de métodos).
- Módulo 05: Consultas ao banco de dados (realizar consultas ao banco de dados com JPA e JPQL, problema das N+1 consultas, consultas nativas com SQL).
- Módulo 06: Docker, implantação, CI/CD (fundamentos de Docker, imagens e containers, Docker Hub, realizar build e implantação manual de um projeto Spring Boot na AWS, CI/CD com Heroku, AWS e Github Actions).
<br>

# Módulo 01 CRUD - Projeto: Client CRUD
API REST com CRUD completo e busca paginada de Clientes.

### Competências aplicadas:
Criar projeto Spring Boot, criar monorepo Git, organizar o projeto em camadas (Controlador REST, Serviço, Acesso a dados (Repository)), criar entidades, configurar perfil de teste do projeto, seeding da base de dados, criar web services REST (Parâmetros de rota @PathVariable, Parâmetros de requisição @RequestParam, Corpo de requisição @RequestBody, Resposta da requisição ResponseEntity<T>), padrão DTO, tratamento de exceções, Postman (coleções, ambientes), dados de auditoria, paginação de dados e associações entre entidades (N-N).


Link do projeto: <a href="https://github.com/CairoDeAndrade/ds-projects/tree/main/01module-project">Client Webservice</a>

## Tecnologias utilizadas
- Spring Boot
- JPA, Hibernate
- H2
- Postman
<br>

# Módulo 02 Testes automatizados - Projeto: TDD (Test-driven development) project
API REST crunstruída utilizando o método TDD, programando o sistema orientado aos testes já pré-escritos.

### Competências aplicadas: 
Fundamentos de testes automatizados (Tipos de testes, Benefícios, TDD - Test Driven Development, Boas práticas e padrões), JUnit tests (Repositories, Services, Resources (web), Integração) e Mockito & MockBean.

Link do projeto: <a href="https://github.com/CairoDeAndrade/ds-projects/tree/main/02module-project">TDD project</a>

## Tecnologias utilizadas
- Spring Boot
- JUnit
- JPA, Hibernate
- H2
- Postman
<br>

# Módulo 03 Validação e segurança - Projeto: Events API
API REST crunstruída utilizando o método TDD.

### Competências aplicadas:
Validação com Bean Validation (Annotations, Customizando a resposta HTTP, Validações personalizadas com acesso a banco), autenticação e autorização (Spring Security, OAuth 2.0, Token JWT, Autorização de rotas por perfil) e Postman (Variáveis de ambiente no projeto com coalescência).

Link do projeto: <a href="https://github.com/CairoDeAndrade/ds-projects/tree/main/03module-project">Events API</a>

## Tecnologias utilizadas
- Spring Boot
- Spring Security (OAuth2)
- JUnit
- JPA, Hibernate
- H2
- Postman
