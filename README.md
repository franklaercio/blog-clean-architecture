<h2 align="center"> 
  ☕ Blog Clean Architecture
</h1>

<p align="center">
  <a href="https://www.linkedin.com/in/frank-laercio/">
    <img alt="Made by franklaercio" src="https://img.shields.io/badge/Linkedin-Made%20by%20franklaercio-blue">
  </a>
  
  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/franklaercio/blog-clean-architecture?color=%2304D361">
  
  <a href="https://github.com/franklaercio/blog-clean-architecture/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/franklaercio/blog-clean-architecture">
  </a>
  
  <img alt="Code size" src="https://img.shields.io/github/languages/code-size/franklaercio/blog-clean-architecture">

  <img alt="License" src="https://img.shields.io/badge/license-MIT-brightgreen">
   <a href="https://github.com/franklaercio/blog-clean-architecture/stargazers">
    <img alt="Stargazers" src="https://img.shields.io/github/stars/franklaercio/blog-clean-architecture?style=social">
  </a>
</p>

### Resumo

Este respositório contém um exemplo prático de uma implementação de uma Arquitetura de Software baseada na proposta de Clean Architecture. Em resumo, esse conceito foi baseado no livro, publicado em 2012, por Robert C. Martin com contribuições de James Grenning e Simon Brown. Esse conteúdo pode ser melhor detalhado no seguinte [post: _the clean architecture_](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html). <br/>

De modo a desenvolver na prática foram utilizadas as tecnologias listadas abaixo:

- Spring Boot 2.5.5
- Java 11 SE
- Postgresql 12.6

### Como obter o projeto

Para obter o projeto é bem simples, basta apenas executar os comandos abaixo:

```
# Clone este repositório
$ git clone https://github.com/franklaercio/blog-clean-architecture.git

# Acesse a pasta do projeto
$ cd blog-clean-architecture

# Acesse a pasta do projeto
$ gradle build
```

### Scripts automatizados e conexão ao banco de dados

Primeiramente para ter acesso ao banco de dados deve-se seguir os seguintes passos:

1. Criar o usuário do banco de dados Postgresql como sendo **postgres** e com a senha **postgres**.
2. Criar uma _database_ denominada **db_blog**.
3. Verificar se porta **5432** está disponível para conexão.

Caso queira ajustar o banco de dados é simples, basta apenas acessar o arquivo [application.yml](http://https://github.com/franklaercio/blog-clean-architecture/src/main/resources/application.yml) e alterar as configuração a seguir:

```yml
spring:
  datasource:
    driver-class-name: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/db_blog
    username: postgres
    password: postgres
```

### Estrutura do projeto

A estrutura do projeto é baseada seguindo o modelo de Arquitetura Limpa (_Arquitetura Limpa_). <br/>

Dessa forma, primeiro foi atribuído as camadas necessárias para Clean Architecture como sendo _configs_, _entities_, _gateways_, _controllers_ e _usecases_. Após isso, foi iniciada a implementação respeitando a premissa de que nenhuma camada deve conhecer a outra e que cada contexto esteja bem definido e separado. <br/>

- _Configs_: camada reservada para configurações globais do projeto.
- _Entities_: camada de domínio, mais interna na proposta da arquitetura.
- _Gateways_: local onde ocorre saídas para banco de dados, _apis_ e integrações como Reddis ou Filas.
- _Controllers_: local onde chega as solicitações externas provindas do padrão REST.
- _Usecases_: local onde fica concentrado as regras de negócio e validações.

A seguir podemos observar como a estrutura do projeto está definida.

```
└── blog-clean-architecture
    └── src
	└── main
	    └── java
		└── com.github.blog
			├── configs
			├── entities
			│   └── enums
			├── gateways
			|   ├── convert
			|   |   ├── request
			|   |   └── response
			|   ├── impl
			|   └── jpa
			├── controllers
			│   └── data
			|   |   ├── request
			│       └── response
			└── usecases
			    ├── convert
			    |   ├── request
			    |   └── response
			    ├── data
			    |   ├── request
			    |   └── response
			    ├── exceptions
			    ├── impl
			    └── utils

```

<p>
   <img alt="Imagem da proposta da clean architecture" src="assets/images/clean-architecture.jpg" />
<p>

### Licença

Este projeto é licenciado seguindo a normas da MIT License - veja o arquivo LICENSE.md para maiores detalhes.

Feito com :hearts: by Frank Laércio :wave:!
