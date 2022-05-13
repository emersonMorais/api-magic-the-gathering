
[![Build Status](https://travis-ci.org/mariazevedo88/travels-java-api.svg?branch=master)](https://travis-ci.org/mariazevedo88/travels-java-api) ![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/mariazevedo88/travels-java-api) ![GitHub repo size](https://img.shields.io/github/repo-size/mariazevedo88/travels-java-api)  ![GitHub](https://img.shields.io/github/license/mariazevedo88/travels-java-api)

<h2>Sobre o projeto<h2/>
<p align> API criada para auxiliar os jogadores de Magic The Gathering a negociarem suas listas de cartas do jogo. Foi construída com Java e Spring, a persistência dos dados foi feita no Banco Postgres SQL, e Banco H2 para testes locais.</P>


<p align="center">
  <a href="https://imgur.com/yz1c5YM">
     <img src="https://i.imgur.com/yz1c5YM.jpg" title="source: imgur.com" width="80%" height="400px" align-content="center"/>    
  </a>
</p>

<h3>Estrutura do Projeto<h3/>

<p>A arquitetura do projeto foi dividida em camadas de acordo com o aprendizado que obtive com o instrutor Nélio Alves da escola online Dev Superior.  </p>

* Entity - Representam as entidades do projeto, os atores principais e que geram as tabelas do banco de dados e relacionamentos entre si.

* Resource - São os recursos, os controladores da aplicação responsáveis pelas requisições HTTP. 

* Data Transfer Objetc(DTO) - essa Classe é responsável pela tranferência dos dados para que não ocorra uma comunicação direta entre Resources e Services, consequentemente temos uma maior segurança e organização do projeto. 

* Service - São os serviços da aplicação onde são adicionadas quaisquer outras regras com os dados vindos do Database. Essa classe realiza a comunicação com a classe Repository(descrita abaixo) e como resultado recebe os dados das Entidades, para aplicar as regras e enviar as informações  à classe Resource por meio da classe DTO.    

* Repository - Conforme mencionado é a camada responsável pelas chamadas no Banco de dados através do JPA do Java, também podem ser realizadas querys avançadas de busca desses dados.  

<h3>Funcionamento da API<h3/>

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

<h3>Tecnologias utilizadas<h3/>

* **Java 17 (Java - JDK: 17.0.2)**
* **Spring Boot**
* **Maven**
* **Banco de dados H2**
* **JPA/Hibernate**
* **Java Validation Bean**
* **Heroku**

<h3>Hospedagem<h3/>

* A hospedagem da API  foi realizada no Heroku e os testes das requisições com o aplicativo Postman. Segue abaixo o link do Heroku e do Postman para testes.

https://mgt-api-emerson.herokuapp.com/

https://www.postman.com/spacecraft-participant-54578206/workspace/mgt/collection/14128924-2f1d64cf-5740-408d-9447-ff12b2bba720?action=share&creator=14128924



