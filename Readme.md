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

4o. Pesquisa por id (GET)
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

5o. Delete por id
Abra uma nova entrada no Postman com o botão New:
Selecione DELETE
Pegue o id do usuário que você quer consultar e inclua na url
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


Confira os proceimentos juntamente com o Compass (cliente do mongo) para verificar se houve alterções no banco

Testando o TicketController com Postman