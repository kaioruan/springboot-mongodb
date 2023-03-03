# Workshop Spring Boot - MongoDB

Esse projeto foi desenvolvido durante estudo da linguagem Java!

Aqui você vai encontrar os detalhes de como foi o desenvolvimento do projeto e quais foram os requisitos técnicos necessários para a entrega do desafio.

# Descrição
Aplicação Backend com um intuito de Blog onde é possivel cadastrar, editar, remover usuários, adicionar postagem e comentários referente as postagens e filtrar buscas de acordo com o endpoint utilizado. 

# Habilidades desenvolvidas

Neste projeto, fui capaz de:

- Utilizar a linguagem Java;
- Utilizar o Spring Boot para desenvolvimento do projeto;
- Construir uma API CRUD com Hibernate e Spring Boot;
- Criar rotas para uma API;
- Utilizar o banco de dados MongoDB;
   
---

# Funcionamento da aplicação

Para iniciar o projeto, é necessário possuir:
  - Java JDK versão 17+.
  - Maven 3.9.0+.
  - Eclipse ou IDE similar com suporte ao Java.

---

## 📚 Documentação (endpoints BACKEND)

A porta utilizada para a requisição dos endpoints é 8080.

### 👨🏻‍🦱 Usuários
| Método | Funcionalidade                            | URL                        |
| ------ | ----------------------------------------- | -------------------------- |
| `GET`  | Retorna a lista de todos usuários cadastrados. | http://localhost:8080/users |

<details>
  <summary>A resposta da requisição é a seguinte, com status 200:</summary>

```json
[
    {
        "id": "640272f55aaded537531461b",
        "name": "Maria Brown",
        "email": "maria@gmail.com"
    },
    {
        "id": "640272f55aaded537531461c",
        "name": "Alex Green",
        "email": "alex@gmail.com"
    },
    {
        "id": "640272f55aaded537531461d",
        "name": "Bob Grey",
        "email": "bob@gmail.com"
    }
]
```

</details>
<br>
<br>

### 👨🏻‍🦱 Usuário Específico
| Método | Funcionalidade                                                | URL                            |
| ------ | ------------------------------------------------------------- | ------------------------------ |
| `GET`  | Busca um usuário especifico no banco de dados. | http://localhost:8080/users/640272f55aaded537531461b |

<details>
  <summary>A resposta da requisição é a seguinte, com status 201:</summary>

```json
{
    "id": "640272f55aaded537531461b",
    "name": "Maria Brown",
    "email": "maria@gmail.com"
}
```

</details>

<details>
  <summary>A requisição irá falhar nos seguintes casos:</summary>
  - A mensagem <code>'Objeto não encontrado'</code> caso não tenha esse id cadastrado no banco.
</details>

<br>
<br>

### 👨🏻‍🦱 Postagens de um Usuário
| Método   | Funcionalidade                                                                  | URL                           |
| -------- | ------------------------------------------------------------------------------- | ----------------------------- |
| `GET` | Ao acessar a rota, a requisição irá retornar um documento com todas as postagens deste usuário. | http://localhost:8080/users/640272f55aaded537531461b/posts |
<details>
  <summary>A resposta da requisição é a seguinte, com status 200:</summary>

```json
[
    {
        "id": "640272f55aaded537531461e",
        "date": "2018-03-21T00:00:00.000+00:00",
        "title": "Partiu Viagem!",
        "body": "Vou viajar para São Paulo, abraços!",
        "author": {
            "id": "640272f55aaded537531461b",
            "name": "Maria Brown"
        },
        "comments": [
            {
                "text": "Boa viagem mano",
                "date": "2018-03-21T00:00:00.000+00:00",
                "author": {
                    "id": "640272f55aaded537531461c",
                    "name": "Alex Green"
                }
            },
            {
                "text": "Aproveite",
                "date": "2018-03-22T00:00:00.000+00:00",
                "author": {
                    "id": "640272f55aaded537531461d",
                    "name": "Bob Grey"
                }
            }
        ]
    },
    {
        "id": "640272f55aaded537531461f",
        "date": "2018-03-23T00:00:00.000+00:00",
        "title": "Bom dia!",
        "body": "A viagem está sendo incrivel!",
        "author": {
            "id": "640272f55aaded537531461b",
            "name": "Maria Brown"
        },
        "comments": [
            {
                "text": "Tenha um ótimo dia",
                "date": "2018-03-23T00:00:00.000+00:00",
                "author": {
                    "id": "640272f55aaded537531461c",
                    "name": "Alex Green"
                }
            }
        ]
    }
]
```

</details>
<br>
<br>

### 👨🏻‍🦱 Criar um novo Usuário
| Método | Funcionalidade                              | URL                              |
| ------ | ------------------------------------------- | -------------------------------- |
| `POST`  | Cadastrar um novo usuário no banco de dados | http://localhost:8080/users/640272f55aaded537531461b/posts |

<details>
  <summary>A estrutura do <code>body</code> da requisição deverá seguir o padrão abaixo:</summary>

```json
{
     "name": "Maria Silva",
    "email": "maria@gmail.com"
}
```

</details>

<details>
  <summary>A resposta da requisição é o status 201.</summary>
</details>
<br>

### 👨🏻‍🦱 Deletar um Usuário
| Método | Funcionalidade                                | URL                              |
| ------ | --------------------------------------------- | -------------------------------- |
| `DELETE` | Remove um usuário do banco de dados. | http://localhost:8080/users/640275285aaded5375314620 |

<details>
  <summary>A resposta da requisição é o status 201.</summary>
</details>
<br>

### 👨🏻‍🦱 Atualizar um Usuário
| Método | Funcionalidade                            | URL                        |
| ------ | ----------------------------------------- | -------------------------- |
| `PUT`  | Atualizar informações referentes a um usuário | http://localhost:8080/users/640272f55aaded537531461b |

<details>
  <summary>A estrutura do <code>body</code> da requisição deverá seguir o padrão abaixo:</summary>

```json
{
     "name": "Maria Silva",
    "email": "maria@gmail.com"
}
```

</details>

<details>
  <summary>A resposta da requisição é o status 204.</summary>
</details>
<br>

### 🗒️ Buscar Postagens.
| Método | Funcionalidade                               | URL                        |
| ------ | -------------------------------------------- | -------------------------- |
| `GET` | Busca todas as postagens referente a um usuário. | http://localhost:8080/posts/640272f55aaded537531461e |

<details>
  <summary>A resposta da requisição é a seguinte, com status 200:</summary>

```json
{
    "id": "640272f55aaded537531461e",
    "date": "2018-03-21T00:00:00.000+00:00",
    "title": "Partiu Viagem!",
    "body": "Vou viajar para São Paulo, abraços!",
    "author": {
        "id": "640272f55aaded537531461b",
        "name": "Maria Brown"
    },
    "comments": [
        {
            "text": "Boa viagem mano",
            "date": "2018-03-21T00:00:00.000+00:00",
            "author": {
                "id": "640272f55aaded537531461c",
                "name": "Alex Green"
            }
        },
        {
            "text": "Aproveite",
            "date": "2018-03-22T00:00:00.000+00:00",
            "author": {
                "id": "640272f55aaded537531461d",
                "name": "Bob Grey"
            }
        }
    ]
}
```

</details>
<br>
<br>

### 🗒️ Buscar Postagens pelo titulo.
| Método | Funcionalidade                               | URL                        |
| ------ | -------------------------------------------- | -------------------------- |
| `GET` | Filtra todas as postagens que tem o titulo de busca. | http://localhost:8080/posts/titlesearch?text=bom%20dia |

<details>
  <summary>A resposta da requisição é a seguinte, com status 200:</summary>

```json
[
    {
        "id": "640272f55aaded537531461f",
        "date": "2018-03-23T00:00:00.000+00:00",
        "title": "Bom dia!",
        "body": "A viagem está sendo incrivel!",
        "author": {
            "id": "640272f55aaded537531461b",
            "name": "Maria Brown"
        },
        "comments": [
            {
                "text": "Tenha um ótimo dia",
                "date": "2018-03-23T00:00:00.000+00:00",
                "author": {
                    "id": "640272f55aaded537531461c",
                    "name": "Alex Green"
                }
            }
        ]
    }
]
```

</details>
<br>
<br>

