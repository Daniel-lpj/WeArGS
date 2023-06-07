# WeArGS

Este projeto é uma API RESTful desenvolvida em Java utilizando o framework Spring Boot.

## Integrantes
- Bruna Gabriela Moreira - 96283
- Daniel Luiz Paula Junior - 96235
- Luana Mitsudo Coelho - 93909
- Lucas de Morais Nascimento - 93267
- Luiz Henrique Paiola Viana - 96124


## Pitch

Acesse o vídeo do Pitch pelo link - https://youtu.be/PFTlK9E0SzM

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

2. Acesse os [endpoints](##Endpoints) disponíveis  para obter informações sobre os endpoints e os dados esperados nas requisições.

3. Verifique os dados retornados pelas requisições, como JSON ou outros formatos de dados.


## Endpoints
- Solo
    - [Cadastrar](#cadastrar-solo)
    - [Listar todos](#listar-solos)
    - [Apagar](#apagar-solo)
    - [Alterar](#alterar-solo)
    - [Mostrar os detalhes](#detalhar-solo)
- Sementes
    - [Cadastrar](#cadastrar-semente)
    - [Listar todas](#listar-sementes)
    - [Apagar](#apagar-semente)
    - [Alterar](#alterar-semente)
    - [Mostrar os detalhes](#detalhar-semente)

---

### Cadastrar Solo
`POST` /WeArGS/api/solo

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|--
| solo_id | int | sim | é o id de um solo previamente cadastrado
| usuario_id | int | sim | é o id do usuário logado
| semente_id | int | sim | é o id da semente previamente cadastrada
| tipo_solo | texto | sim | é o tipo do solo
| umidade_solo | texto | sim | é a umidade do solo
| ph_solo | texto | sim | é o ph do solo
| materia_organica | int | sim | é a quantidade de matéria orgânica no solo
| nutrientes | int | sim | é a quantidade de nutrientes no solo

**Exemplo de corpo do request**

```js
{
    "solo_id" : 1,
    "usuario_id" : 1,
    "semente_id" : 1,
    "tipo_solo": "Solo Fértil",
    "umidade_solo": "50",
    "ph_solo": "7",
    "materia_organica": 50,
    "nutrientes": 10
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 201 | solo cadastrado com sucesso
| 400 | erro na validação dos dados da requisição

---

### Detalhar Solo
`GET` /WeArGS/api/solo/{id}

**Exemplo de corpo da resposta**

```js
{
    "solo" : {
      "solo_id": 1,
      "solo_nome": "Solo 1"
    },
    "usuario_id" : 1,
    "semente_id" : 1,
    "tipo_solo": "Solo Fértil",
    "umidade_solo": "50",
    "ph_solo": "7",
    "materia_organica": 50,
    "nutrientes": 10
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 200 | dados retornados no corpo da resposta
| 404 | não foi encontrado solo com o id informado

---

### Listar Solos
`GET` /WeArGS/api/solo

**Exemplo de corpo da resposta**

```js
{ 
    "solo" : {
      "solo_id": 1,
      "solo_nome": "Solo 1"
    },
    "usuario_id" : 1,
    "semente_id" : 1,
    "tipo_solo": "Solo Fértil",
    "umidade_solo": "50",
    "ph_solo": "7",
    "materia_organica": 50,
    "nutrientes": 10
},
{
     "solo" : {
      "solo_id": 2,
      "solo_nome": "Solo 2"
    },
    "usuario_id" : 2,
    "semente_id" : 2,
    "tipo_solo": "Solo Infértil",
    "umidade_solo": "50",
    "ph_solo": "2",
    "materia_organica": 10,
    "nutrientes": 2
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 200 | dados retornados no corpo da resposta
| 404 | não foi encontrado solo com o id informado

---

### Apagar Solo
`DELETE` /WeArGS/api/solo/{id}

**Exemplo de corpo da resposta**

```js
{
    "mensagem": "Solo apagado com sucesso"
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 200 | dados apagados com sucesso
| 404 | não foi encontrado solo com o id informado

---

### Alterar Solo
`PUT` /WeArGS/api/solo/{id}

**Exemplo de corpo da resposta**

```js
{
    "mensagem": "Solo atualizado com sucesso"
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 200 | dados atualizados com sucesso
| 404 | não foi encontrado solo com o id informado

---


### Cadastrar Semente
`POST` /WeArGS/api/sementes

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|--
| semente_id | int | sim | é o id de uma semente previamente cadastrada
| solo_id | int | sim | é o id do solo previamente cadastrado
| clima_plantacao_id | int | sim | é o id de um clima de plantação previamente cadastrado
| descricao | texto | sim | é o descrição da sementes
| tipo_semente | texto | sim | é o tipo de semente
| epoca_plantio | texto | sim | é a época do plantio
| regiao | texto | sim | é a região de plantação da semente
| condicoes_solo | texto | sim | é a condição do solo
| requisito_luz | texto | sim | é a quantidade de luz incidente
| resistencia | texto | sim | é a resistência da semente
| periodo_colheita | texto | sim | é a período ideal para colheita


**Exemplo de corpo do request**

```js
{
    "semente_id" : 1,
    "solo_id" : 1,
    "clima_plantacao_id" : 1,
    "descricao": "Semente de fruto",
    "tipo_semente": "Semente adubada",
    "epoca_plantio": "12",
    "regiao": "Sul",
    "condicoes_solo": "10",
    "requisito_luz": "5",
    "resistencia": "10",
    "periodo_colheita": "12"
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 201 | semente cadastrada com sucesso
| 400 | erro na validação dos dados da requisição

---

### Detalhar Semente
`GET` /WeArGS/api/sementes/{id}

**Exemplo de corpo da resposta**

```js
{
    "semente_id" : 1,
    "solo_id" : 1,
    "clima_plantacao_id" : 1,
    "descricao": "Semente de fruto",
    "tipo_semente": "Sementes ortodoxas",
    "epoca_plantio": "12",
    "regiao": "Sul",
    "condicoes_solo": "10",
    "requisito_luz": "5",
    "resistencia": "10",
    "periodo_colheita": "12"
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 200 | dados retornados no corpo da resposta
| 404 | não foi encontrada semente com o id informado

---

### Listar Sementes
`GET` /WeArGS/api/sementes

**Exemplo de corpo da resposta**

```js
{
    "semente_id" : 1,
    "solo_id" : 1,
    "clima_plantacao_id" : 1,
    "descricao": "Semente de fruto",
    "tipo_semente": "Sementes ortodoxas",
    "epoca_plantio": "12",
    "regiao": "Sul",
    "condicoes_solo": "10",
    "requisito_luz": "5",
    "resistencia": "10",
    "periodo_colheita": "12"
},
{
    "semente_id" : 2,
    "solo_id" : 2,
    "clima_plantacao_id" : 2,
    "descricao": "Semente de flor",
    "tipo_semente": "Sementes de pastagem",
    "epoca_plantio": "1",
    "regiao": "Norte",
    "condicoes_solo": "10",
    "requisito_luz": "5",
    "resistencia": "10",
    "periodo_colheita": "1"
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 200 | dados retornados no corpo da resposta
| 404 | não foi encontrada semente com o id informado

---

### Apagar Semente
`DELETE` /WeArGS/api/sementes/{id}

**Exemplo de corpo da resposta**

```js
{
    "mensagem": "Semente apagada com sucesso"
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 200 | dados apagados com sucesso
| 404 | não foi encontrada semente com o id informado

---

### Alterar Semente
`PUT` /WeArGS/api/sementes/{id}

**Exemplo de corpo da resposta**

```js
{
    "mensagem": "Semente atualizada com sucesso"
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 200 | dados atualizados com sucesso
| 404 | não foi encontrada semente com o id informado

