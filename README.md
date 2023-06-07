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

2. Acesse os endpoints disponíveis [Endpoints](##Endpoints) para obter informações sobre os endpoints e os dados esperados nas requisições.

3. Verifique os dados retornados pelas requisições, como JSON ou outros formatos de dados.


## Endpoints
- Solo
    - [Cadastrar](#cadastrar-solo)
    - [Listar todas](#listar-solo)
    - [Apagar](#apagar-solo)
    - [Alterar](#alterar-solo)
    - [Mostrar os detalhes](#detalhar-solo)
- Roupa
    - [Cadastrar](#cadastrar-roupa)
    - [Listar todas](#listar-roupa)
    - [Apagar](#apagar-roupa)
    - [Alterar](#alterar-roupa)
    - [Mostrar os detalhes](#detalhar-roupa)

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

### Listar Solo
`GET` /WeArGS/api/solo

**Exemplo de corpo da resposta**

```js
{ "solo" : {
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


### Cadastrar Roupa
`POST` /wear/api/ropupa

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|--
| id | int | sim | é o id de uma roupa
| nome | texto | sim | é o nome da roupa
| codigo | texto | sim | é o código da roupa
| preco | int | sim | é o preço da roupa
| cor | lista | não | são as cores disponíveis para a roupa
| tamanho | lista | não | são os tamanhos disponíveis para a roupa

**Exemplo de corpo do request**

```js
{
    "id" : 1,
    "nome": "Camiseta",
    "codigo": "123",
    "preco": 50,00,
    "cor": ["Azul", "Preto"],
    "tamanho": ["P", "M", "G"]
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 201 | experimentar cadastrado com sucesso
| 400 | erro na validação dos dados da requisição

---

### Detalhar Roupa
`GET` /wear/api/roupa/{id}

**Exemplo de corpo da resposta**

```js
{
    "roupa": {
        "id" : 1,
        "nome": "Camiseta"
    },
    "codigo": "123",
    "preco": 50,00,
    "cor": ["Azul", "Preto"],
    "tamanho": ["P", "M", "G"]
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 200 | dados retornados no corpo da resposta
| 404 | não foi encontrada roupa com o id informado

---

### Listar Roupa
`GET` /wear/api/roupa

**Exemplo de corpo da resposta**

```js
{
   "roupa": {
        "id" : 1,
        "nome": "Camiseta"
    },
    "codigo": "123",
    "preco": 50,00,
    "cor": ["Azul", "Preto"],
    "tamanho": ["P", "M", "G"]
},
{
    "roupa": {
        "id" : 2,
        "nome": "Calça"
    },
    "codigo": "321",
    "preco": 100,00,
    "cor": ["Azul", "Preto", "Branco"],
    "tamanho": ["P", "M", "G"]
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 200 | dados retornados no corpo da resposta
| 404 | não foi encontrada roupa com o id informado

---

### Apagar Roupa
`DELETE` /wear/api/roupa/{id}

**Exemplo de corpo da resposta**

```js
{
    "mensagem": "Roupa apagada com sucesso"
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 200 | dados apagados com sucesso
| 404 | não foi encontrada roupa com o id informado

---

### Alterar Roupa
`PUT` /wear/api/roupa/{id}

**Exemplo de corpo da resposta**

```js
{
    "mensagem": "Roupa atualizada com sucesso"
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 200 | dados atualizados com sucesso
| 404 | não foi encontrada roupa com o id informado

