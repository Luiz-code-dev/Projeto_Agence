# Projeto_Agence

# End Point <br/>

auth <br/>
1 - POST http://localhost:8080/api/v1/auth <br/>
 <br/>
{ <br/>
"login": "admin", <br/>
"senha": "fleetmg@!" <br/>
} <br/>
 <br/>
Cadastrar Funcionario <br/>
2 - POST http://localhost:8080/api/v1/funcionarios <br/>
 <br/>
{ <br/>
"id": 6, <br/>
"nome": "Ana", <br/>
"matricula": "142536" <br/>
} <br/>
 <br/>

excluir funcionario <br/>
3- DELETE http://localhost:8080/api/v1/funcionarios/2 <br/>
 <br/>

Lista funcionarios <br/>
4-  GET http://localhost:8080/api/v1/funcionarios <br/>
 <br/>

Cadastrar Carros <br/>
5- POST http://localhost:8080/api/v1/carros <br/>
 <br/>
{ <br/>
"id": 6, <br/>
"modelo": "Chevrolet", <br/>
"marca": "chevet", <br/>
"dataFabricacao": "2020-08-10T17:05:56.153+00:00", <br/>
"carroUsado": true, <br/>
"nomeFuncionario": "Luiz" <br/>
} <br/>
 <br/>
excluir carro <br/>
6- DELETE http://localhost:8080/api/v1/carros/2 <br/>
 <br/>

Lista carros <br/>
7- GET http://localhost:8080/api/v1/carros <br/>
 <br/>
Lista Carros Usados <br/>
8 -  GET http://localhost:8080/api/v1/carros/retirados <br/>
 <br/>


