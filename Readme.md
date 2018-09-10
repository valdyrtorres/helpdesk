Instruções de teste da api do HelpDesk

Postman

Para testar o Post faça:

1o. Obter o token

Selecione POST
Use a url: http://localhost:8080/api/auth

Na aba Body, escolha raw e a opção JSON(application/json)
Obs: Esse é o usuário default de administração criado ao iniciarmos nossa aplicação.

No corpo digite:
{
	"email":"admin@helpdesk.com",
	"password":"123456"
}

Clique o botão Send. A seguir você obtem o token. Copie esse token para a clipboard
Exemplo de resposta:
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBoZWxwZGVzay5jb20iLCJjcmVhdGVkIjoxNTI5NTQ5Nzg4NjQxLCJleHAiOjE1MzAxNTQ1ODh9.CBqF3PgHA_8B816IR4KYXwbmDkARwCpJO1nYNpQRKe9OkG1A3G7eZW3WLqFw_gxnufIp9F_ZSWGSYpVzHpUfpA",
    "user": {
        "id": "5b24481ab08b832fc08614bb",
        "email": "admin@helpdesk.com",
        "password": null,
        "profile": "ROLE_ADMIN"
    }
}

2o. Crie o usuário.

Abra uma nova entrada no Postman com o botão New:
Selecione POST
use a url: http://localhost:8080/api/user
Na aba Headers, crie o campo Authorization e nele coloque o token que você obteve do POST anterior.

Vá em Body e escolha raw e a opção JSON(application/json)

No corpo digite o usuário que você vai incluir com as opções correspondentes
{
  "email":"rildav@gmail.com",
  "password": "123456",
  "profile" : "ROLE_ADMIN"
}
clique no botão Send
Exemplo de resposta:
{
    "data": {
        "id": "5b2f1ff8bc3ecb2ef84fb870",
        "email": "rildav@gmail.com",
        "password": "$2a$10$7i8gzGcwZww3LHmXbNJr.OGEmNCcyLKX0jbPlpI.2H9GjStK5aXsS",
        "profile": "ROLE_ADMIN"
    },
    "errors": []
}

3o. Alterar o usuário
Abra uma nova entrada no Postman com o botão New:
Selecione PUT
use a url: http://localhost:8080/api/user
Na aba Headers, crie o campo Authorization e nele coloque o token que você obteve do POST do 1o. passo.
Pegue o id do usuário que você quer alterar e vá em Body e escolha raw e a opção JSON(application/json)
No corpo digite o usuário que você vai alterar com as opções correspondentes
{
  "id": "5b2f1ff8bc3ecb2ef84fb870",
  "email":"monkeydluffy@gmail.com",
  "password": "123456",
  "profile" : "ROLE_ADMIN"
}
clique no botão Send
Exemplo de resposta:
{
    "data": {
        "id": "5b2f1ff8bc3ecb2ef84fb870",
        "email": "monkeydluffy@gmail.com",
        "password": "$2a$10$wBi9Evb4PCoc6Ce.Q5XUDuV6pwy1vsfLHXGR9t.SPX56TA4Q.3xIK",
        "profile": "ROLE_ADMIN"
    },
    "errors": []
}

4o. Pesquisa usuário por id (GET)
Abra uma nova entrada no Postman com o botão New:
Selecione GET
Pegue o id do usuário que você quer consultar e inclua na url
use a url: http://localhost:8080/api/user/5b2f1ff8bc3ecb2ef84fb870
Na aba Headers, crie o campo Authorization e nele coloque o token que você obteve do POST do 1o. passo.
clique no botão Send
Exemplo de resposta:
{
    "data": {
        "id": "5b2f1ff8bc3ecb2ef84fb870",
        "email": "monkeydluffy@gmail.com",
        "password": "$2a$10$wBi9Evb4PCoc6Ce.Q5XUDuV6pwy1vsfLHXGR9t.SPX56TA4Q.3xIK",
        "profile": "ROLE_ADMIN"
    },
    "errors": []
}

5o. Delete usuário por id
Abra uma nova entrada no Postman com o botão New:
Selecione DELETE
Pegue o id do usuário que você quer deletar e inclua na url
use a url: http://localhost:8080/api/user/5b2f1ff8bc3ecb2ef84fb870
Na aba Headers, crie o campo Authorization e nele coloque o token que você obteve do POST do 1o. passo.
clique no botão Send
Exemplo de resposta:
{
    "data": null,
    "errors": []
}

6o. Pesquisa todos usuários (GET)
Abra uma nova entrada no Postman com o botão New:
Selecione GET
use a url: http://localhost:8080/api/user/0/10
onde 0 significa a primeira página e quero que traga 10 registros
Na aba Headers, crie o campo Authorization e nele coloque o token que você obteve do POST do 1o. passo.
clique no botão Send
Exemplo de resposta:
{
    "data": {
        "id": "5b2f1ff8bc3ecb2ef84fb870",
        "email": "monkeydluffy@gmail.com",
        "password": "$2a$10$wBi9Evb4PCoc6Ce.Q5XUDuV6pwy1vsfLHXGR9t.SPX56TA4Q.3xIK",
        "profile": "ROLE_ADMIN"
    },
    "errors": []
}


Confira os procedimentos juntamente com o Compass (cliente do mongo) para verificar se houve alterções no banco

Testando o TicketController com Postman

1o. Obter o token

Selecione POST
Use a url: http://localhost:8080/api/auth

Na aba Body, escolha raw e a opção JSON(application/json)
Obs: Esse é o usuário default de administração criado ao iniciarmos nossa aplicação.

No corpo digite:
{
    "email":"admin@helpdesk.com",
    "password":"123456"
}

Clique o botão Send. A seguir você obtem o token. Copie esse token para a clipboard
Exemplo de resposta:
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBoZWxwZGVzay5jb20iLCJjcmVhdGVkIjoxNTI5NTQ5Nzg4NjQxLCJleHAiOjE1MzAxNTQ1ODh9.CBqF3PgHA_8B816IR4KYXwbmDkARwCpJO1nYNpQRKe9OkG1A3G7eZW3WLqFw_gxnufIp9F_ZSWGSYpVzHpUfpA",
    "user": {
        "id": "5b24481ab08b832fc08614bb",
        "email": "admin@helpdesk.com",
        "password": null,
        "profile": "ROLE_ADMIN"
    }
}

2o. Crie os usuários technician e customer.

Abra uma nova entrada no Postman com o botão New:
Selecione POST
use a url: http://localhost:8080/api/user
Na aba Headers, crie o campo Authorization e nele coloque o token que você obteve do POST anterior.

Vá em Body e escolha raw e a opção JSON(application/json)

No corpo digite o usuário que você vai incluir com as opções correspondentes
{
  "email":"technician@gmail.com",
  "password": "123456",
  "profile" : "ROLE_TECHNICIAN"
}
clique no botão Send

Criar o customer
No corpo digite o usuário que você vai incluir com as opções correspondentes
{
  "email":"customer@gmail.com",
  "password": "123456",
  "profile" : "ROLE_CUSTOMER"
}
clique no botão Send

3o. Obter o token do Customer

Selecione POST
Use a url: http://localhost:8080/api/auth

Na aba Body, escolha raw e a opção JSON(application/json)
Obs: Esse é o usuário default de administração criado ao iniciarmos nossa aplicação.

No corpo digite:
{
    "email":"customer@gmail.com",
    "password":"123456"
}

Clique o botão Send. A seguir você obtem o token. Copie esse token para a clipboard
Exemplo de resposta:
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjdXN0b21lckBnbWFpbC5jb20iLCJjcmVhdGVkIjoxNTMwMjIyODM5MTk0LCJleHAiOjE1MzA4Mjc2Mzl9.R-w6LK9hjT6rRdVkaSBndF0KrxuMG_14vk7MQipPzdQrZfA7dA1DE1i-oupIEUqkewtA5rZzXV8P1cfUbsZpyA",
    "user": {
        "id": "5b3556022491b7a9c0f61762",
        "email": "customer@gmail.com",
        "password": null,
        "profile": "ROLE_CUSTOMER"
    }
}


4o. Criar o ticket.

Abra uma nova entrada no Postman com o botão New:
Selecione POST
use a url: http://localhost:8080/api/ticket
Na aba Headers, crie o campo Authorization e nele coloque o token que você obteve do POST do customer para obter o token.

Vá em Body e escolha raw e a opção JSON(application/json)

No corpo digite o ticket que você vai incluir com as opções correspondentes
{
  "title":"Test Ticket 1",
  "priority": "Normal",
  "description" : "Test Description",
  "image" : "byte test"
}
clique no botão Send
Exemplo de resposta:
{
    "data": {
        "id": "5b355a302491b7aae90f0499",
        "user": {
            "id": "5b3556022491b7a9c0f61762",
            "email": "customer@gmail.com",
            "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
            "profile": "ROLE_CUSTOMER"
        },
        "date": 1530223152212,
        "title": "Test Ticket 1",
        "number": 4152,
        "status": "New",
        "priority": "Normal",
        "assignedUser": null,
        "description": "Test Description",
        "image": "byte test",
        "changes": null
    },
    "errors": []
}

5o. Alterar o ticket.

Abra uma nova entrada no Postman com o botão New:
Selecione PUT
use a url: http://localhost:8080/api/ticket
Na aba Headers, crie o campo Authorization e nele coloque o token que você obteve do POST do customer para obter o token.

Vá em Body e escolha raw e a opção JSON(application/json)

No corpo digite o ticket que você vai alterar com o seu id
{
  "id":"5b355a302491b7aae90f0499",
  "title":"Test Ticket 1 changed",
  "priority": "Normal",
  "description" : "Test Description changed",
  "image" : "byte test"
}
clique no botão Send
Exemplo de resposta:
{
    "data": {
        "id": "5b355a302491b7aae90f0499",
        "user": {
            "id": "5b3556022491b7a9c0f61762",
            "email": "customer@gmail.com",
            "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
            "profile": "ROLE_CUSTOMER",
            "target": {
                "id": "5b3556022491b7a9c0f61762",
                "email": "customer@gmail.com",
                "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
                "profile": "ROLE_CUSTOMER"
            }
        },
        "date": 1530223152212,
        "title": "Test Ticket 1 changed",
        "number": 4152,
        "status": "New",
        "priority": "Normal",
        "assignedUser": null,
        "description": "Test Description changed",
        "image": "byte test",
        "changes": null
    },
    "errors": []
}

6o. Pesquisa ticket por id (GET)
Abra uma nova entrada no Postman com o botão New:
Selecione GET
Pegue o id do usuário que você quer consultar e inclua na url
use a url: http://localhost:8080/api/ticket/5b355a302491b7aae90f0499
Na aba Headers, crie o campo Authorization e nele coloque o token que você obteve do POST do 1o. passo.
clique no botão Send
Exemplo de resposta:
{
    "data": {
        "id": "5b355a302491b7aae90f0499",
        "user": {
            "id": "5b3556022491b7a9c0f61762",
            "email": "customer@gmail.com",
            "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
            "profile": "ROLE_CUSTOMER",
            "target": {
                "id": "5b3556022491b7a9c0f61762",
                "email": "customer@gmail.com",
                "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
                "profile": "ROLE_CUSTOMER"
            }
        },
        "date": 1530223152212,
        "title": "Test Ticket 1 changed",
        "number": 4152,
        "status": "New",
        "priority": "Normal",
        "assignedUser": null,
        "description": "Test Description changed",
        "image": "byte test",
        "changes": []
    },
    "errors": []
}

7o. Delete ticket por id (GET)
Abra uma nova entrada no Postman com o botão New:
Selecione DELETE
Pegue o id do usuário que você quer consultar e inclua na url
use a url: http://localhost:8080/api/ticket/5b355a302491b7aae90f0499
Na aba Headers, crie o campo Authorization e nele coloque o token que você obteve do POST do 1o. passo.
clique no botão Send
Exemplo de resposta:
{
    "data": null,
    "errors": []
}

8o. Pesquisa todos os tickets (GET) - Obs A consulta é feita por página e número de registros
Inclua alguns tickets para testar
Abra uma nova entrada no Postman com o botão New:
Selecione GET
use a url: http://localhost:8080/api/ticket/0/4
onde 0 significa a primeira página e quero que traga 4 registros
Na aba Headers, crie o campo Authorization e nele coloque o token que você obteve do POST do 1o. passo.


clique no botão Send
Exemplo de resposta:
{
    "data": {
        "content": [
            {
                "id": "5b3639612491b7cb132ee1ab",
                "user": {
                    "id": "5b3556022491b7a9c0f61762",
                    "email": "customer@gmail.com",
                    "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
                    "profile": "ROLE_CUSTOMER",
                    "target": {
                        "id": "5b3556022491b7a9c0f61762",
                        "email": "customer@gmail.com",
                        "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
                        "profile": "ROLE_CUSTOMER"
                    }
                },
                "date": 1530280289407,
                "title": "Test Ticket 4",
                "number": 8496,
                "status": "New",
                "priority": "Normal",
                "assignedUser": null,
                "description": "Test Description changed",
                "image": "byte test",
                "changes": null
            },
            {
                "id": "5b3639582491b7cb132ee1aa",
                "user": {
                    "id": "5b3556022491b7a9c0f61762",
                    "email": "customer@gmail.com",
                    "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
                    "profile": "ROLE_CUSTOMER",
                    "target": {
                        "id": "5b3556022491b7a9c0f61762",
                        "email": "customer@gmail.com",
                        "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
                        "profile": "ROLE_CUSTOMER"
                    }
                },
                "date": 1530280280345,
                "title": "Test Ticket 3",
                "number": 7215,
                "status": "New",
                "priority": "Normal",
                "assignedUser": null,
                "description": "Test Description changed",
                "image": "byte test",
                "changes": null
            },
            {
                "id": "5b3639542491b7cb132ee1a9",
                "user": {
                    "id": "5b3556022491b7a9c0f61762",
                    "email": "customer@gmail.com",
                    "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
                    "profile": "ROLE_CUSTOMER",
                    "target": {
                        "id": "5b3556022491b7a9c0f61762",
                        "email": "customer@gmail.com",
                        "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
                        "profile": "ROLE_CUSTOMER"
                    }
                },
                "date": 1530280276251,
                "title": "Test Ticket 2",
                "number": 8843,
                "status": "New",
                "priority": "Normal",
                "assignedUser": null,
                "description": "Test Description changed",
                "image": "byte test",
                "changes": null
            },
            {
                "id": "5b36394f2491b7cb132ee1a8",
                "user": {
                    "id": "5b3556022491b7a9c0f61762",
                    "email": "customer@gmail.com",
                    "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
                    "profile": "ROLE_CUSTOMER",
                    "target": {
                        "id": "5b3556022491b7a9c0f61762",
                        "email": "customer@gmail.com",
                        "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
                        "profile": "ROLE_CUSTOMER"
                    }
                },
                "date": 1530280271319,
                "title": "Test Ticket 1",
                "number": 5134,
                "status": "New",
                "priority": "Normal",
                "assignedUser": null,
                "description": "Test Description changed",
                "image": "byte test",
                "changes": null
            }
        ],
        "totalPages": 1,
        "totalElements": 4,
        "last": true,
        "size": 4,
        "number": 0,
        "sort": null,
        "numberOfElements": 4,
        "first": true
    },
    "errors": []
}

9o. Busca tickets por parâmetros (GET)
Você deve comentar o parâmetro "assigned" dentro do código e criar a variável "assigned" com valor true.
Abra uma nova entrada no Postman com o botão New:
Selecione GET
use a url: localhost:8080/api/ticket/0/4/0/Test/New/Normal/false
onde 0 significa a primeira página e quero que traga 4 registros
Na aba Headers, crie o campo Authorization e nele coloque o token que você obteve do POST do 1o. passo.
clique no botão Send
Exemplo de resposta:
{
    "data": {
        "content": [
            {
                "id": "5b3639612491b7cb132ee1ab",
                "user": {
                    "id": "5b3556022491b7a9c0f61762",
                    "email": "customer@gmail.com",
                    "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
                    "profile": "ROLE_CUSTOMER",
                    "target": {
                        "id": "5b3556022491b7a9c0f61762",
                        "email": "customer@gmail.com",
                        "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
                        "profile": "ROLE_CUSTOMER"
                    }
                },
                "date": 1530280289407,
                "title": "Test Ticket 4",
                "number": 8496,
                "status": "New",
                "priority": "Normal",
                "assignedUser": null,
                "description": "Test Description changed",
                "image": "byte test",
                "changes": null
            },
            {
                "id": "5b3639582491b7cb132ee1aa",
                "user": {
                    "id": "5b3556022491b7a9c0f61762",
                    "email": "customer@gmail.com",
                    "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
                    "profile": "ROLE_CUSTOMER",
                    "target": {
                        "id": "5b3556022491b7a9c0f61762",
                        "email": "customer@gmail.com",
                        "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
                        "profile": "ROLE_CUSTOMER"
                    }
                },
                "date": 1530280280345,
                "title": "Test Ticket 3",
                "number": 7215,
                "status": "New",
                "priority": "Normal",
                "assignedUser": null,
                "description": "Test Description changed",
                "image": "byte test",
                "changes": null
            },
            {
                "id": "5b3639542491b7cb132ee1a9",
                "user": {
                    "id": "5b3556022491b7a9c0f61762",
                    "email": "customer@gmail.com",
                    "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
                    "profile": "ROLE_CUSTOMER",
                    "target": {
                        "id": "5b3556022491b7a9c0f61762",
                        "email": "customer@gmail.com",
                        "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
                        "profile": "ROLE_CUSTOMER"
                    }
                },
                "date": 1530280276251,
                "title": "Test Ticket 2",
                "number": 8843,
                "status": "New",
                "priority": "Normal",
                "assignedUser": null,
                "description": "Test Description changed",
                "image": "byte test",
                "changes": null
            },
            {
                "id": "5b36394f2491b7cb132ee1a8",
                "user": {
                    "id": "5b3556022491b7a9c0f61762",
                    "email": "customer@gmail.com",
                    "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
                    "profile": "ROLE_CUSTOMER",
                    "target": {
                        "id": "5b3556022491b7a9c0f61762",
                        "email": "customer@gmail.com",
                        "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
                        "profile": "ROLE_CUSTOMER"
                    }
                },
                "date": 1530280271319,
                "title": "Test Ticket 1",
                "number": 5134,
                "status": "New",
                "priority": "Normal",
                "assignedUser": null,
                "description": "Test Description changed",
                "image": "byte test",
                "changes": null
            }
        ],
        "last": true,
        "totalPages": 1,
        "totalElements": 4,
        "size": 4,
        "number": 0,
        "sort": null,
        "first": true,
        "numberOfElements": 4
    },
    "errors": []
}

10o. Alterar o status.

Abra uma nova entrada no Postman com o botão New:
Selecione PUT
use a url: http://localhost:8080/api/ticket/5b3639612491b7cb132ee1ab/Resolved
Na aba Headers, crie o campo Authorization e nele coloque o token que você obteve do POST do customer para obter o token.

Vá em Body e escolha raw e a opção JSON(application/json)

No corpo digite o ticket que você vai alterar com o seu id
{
  "id":"5b3639612491b7cb132ee1ab",
  "title":"Test Ticket 4",
  "priority": "Normal",
  "description" : "Test Description changed",
  "image" : "byte test"
}
clique no botão Send
{
    "data": {
        "id": "5b3639612491b7cb132ee1ab",
        "user": {
            "id": "5b3556022491b7a9c0f61762",
            "email": "customer@gmail.com",
            "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
            "profile": "ROLE_CUSTOMER",
            "target": {
                "id": "5b3556022491b7a9c0f61762",
                "email": "customer@gmail.com",
                "password": "$2a$10$lE2VISxNXpvgs/WFua3c0eEt9CKu5fPyqKSCtU602lFycshDkaVo.",
                "profile": "ROLE_CUSTOMER"
            }
        },
        "date": 1530280289407,
        "title": "Test Ticket 4",
        "number": 8496,
        "status": "Resolved",
        "priority": "Normal",
        "assignedUser": null,
        "description": "Test Description changed",
        "image": "byte test",
        "changes": null
    },
    "errors": []
}

11o. Resumo total summary (GET)
Abra uma nova entrada no Postman com o botão New:
Selecione GET
use a url: http://localhost:8080/api/ticket/summary

Na aba Headers, crie o campo Authorization e nele coloque o token que você obteve do POST do 1o. passo.
clique no botão Send
Exemplo de resposta:
{
    "data": {
        "amountNew": 3,
        "amountResolved": 1,
        "amountApproved": 0,
        "amountDisapproved": 0,
        "amountAssigned": 0,
        "amountClosed": 0
    },
    "errors": []
}