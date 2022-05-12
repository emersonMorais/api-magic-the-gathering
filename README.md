add project entities# api-mgt-spring

[![Build Status](https://travis-ci.org/mariazevedo88/travels-java-api.svg?branch=master)](https://travis-ci.org/mariazevedo88/travels-java-api) ![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/mariazevedo88/travels-java-api) ![GitHub repo size](https://img.shields.io/github/repo-size/mariazevedo88/travels-java-api)  ![GitHub](https://img.shields.io/github/license/mariazevedo88/travels-java-api)

## Sobre o Projeto
<p align> API criada para auxiliar os jogadores de Magic The Gathering a negociarem suas listas de cartas do jogo. Foi construída com Java e Spring, a persistência dos dados foi feita no Banco H2.  </P>

<p align="center">
  <a href="https://imgur.com/yz1c5YM">
     <img src="https://i.imgur.com/yz1c5YM.jpg" title="source: imgur.com" width="80%" height="400px" align-content="center"/>    
  </a>
</p>

<<<<<<< HEAD
## Features
=======
## Funcionamento da API

A API  possui os seguintes endpoints:

:red_circle: Player: 
* Cria um player: `POST/v1/players`
* Lista todos os players: `GET/v1/players`

:large_blue_circle: Deck:  
* Insere um deck(recebe as cartas): `POST/v1/decks`
* Lista um deck(por id) com suas respectivas cartas:`/v1/decks/1`
* Lista um deck(por id) com suas respectivas cartas e qual o jogador associado:`/v1/decks/1`
* Lista todos os decks com suas respectivas cartas:`/v1/decks/1`

:white_circle: Card:  
* Insere um card na lista: `POST/v1/cards`
* Lista todas as cartas por ordem alfabética:`GET/v1/cards`
* Lista uma carta(por id)para consulta:`GET/v1/cards/1`
* Atualiza o preço e quantidade de uma carta(por id):`PUT/v1/cards/1`
* Deleta uma carta(por id) da lista:`DELETE/v1/cards/1` 

### Tecnologias utilizadas

* **Java 17 (Java - JDK: 17.0.2)**
* **Spring Boot**
* **Maven**
* **Banco de dados H2**
* **JPA/Hibernate**
* **Java Validation Bean**
* **Heroku**



