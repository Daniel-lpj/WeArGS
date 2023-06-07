# WeArGS

Este projeto é uma API RESTful desenvolvida em Java utilizando o framework Spring Boot.

## Pré-requisitos

- JDK (Java Development Kit) 11 ou superior instalado
- Maven instalado (opcional, se você preferir usar o Maven como gerenciador de dependências)

## Instalação

1. Faça o clone deste repositório para o seu ambiente local:

```
git clone https://github.com/Daniel-lpj/WeArGS
```

2. Acesse o diretório do projeto:

```
cd WeArGS
```

3. (Opcional) Se você preferir usar o Maven, compile o projeto para baixar as dependências necessárias:

```
mvn clean install
```

## Configuração

1. Abra o arquivo application.properties no diretório src/main/resources do projeto.

2. Verifique as configurações de banco de dados, como URL, nome de usuário e senha. Certifique-se de ter um banco de dados configurado e as informações corretas fornecidas.


## Execução

1. Execute o aplicativo usando o Maven:

```
mvn spring-boot:run
```

Ou 

2. Execute o aplicativo compilado:

```
java -jar WeArGS.jar
```

## Testes

1. Utilize uma ferramenta como cURL, Postman ou Insomnia para enviar requisições HTTP para a API.

2. Acesse os endpoints disponíveis na API, como GET /api/recurso, POST /api/recurso, PUT /api/recurso/{id}, DELETE /api/recurso/{id}, etc. Consulte a documentação da API para obter informações sobre os endpoints e os dados esperados nas requisições.

3. Verifique os dados retornados pelas requisições, como JSON ou outros formatos de dados.
