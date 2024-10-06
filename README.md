# Movie Web Service API

trabalho intermediario

-Este projeto é um web service em Java que faz requisições à OMDB API para buscar informações sobre filmes. Ele permite a pesquisa de filmes pelo título e o armazenamento local dessas informações. As rotas aceitam requisições GET e POST, e o formato de resposta é em JSON.

# Requisitos

- Java 11 ou superior
- Maven
- necessario uso de postman ou insomnia

O servidor estará disponível em http://localhost:8080.

# Rotas Disponíveis
Requisição:GET /movies/search?title={titulo_do_filme}  (sendo o titulo sempre em ingles ex:gigantes de aço = real steel)

Exemplo:GET http://localhost:8080/movies/search?title=real steel 

Resposta (JSON):
{
    "title": "Real Steel",
    "year": "2011",
    "plot": "In a near future where robot boxing is a top sport, a struggling ex-boxer feels he's found a champion in a discarded robot."
}

 POST /movies/save
 
 Salva um filme obtido da OMDB API no armazenamento local.
 
Requisição:POST /movies/save?title={titulo_do_filme}   (sendo o titulo sempre em ingles ex:gigantes de aço = real steel)

Exemplo:POST http://localhost:8080/movies/save?title=real steel

Resposta (Texto):Filme salvo: Real Steel (2011)

 GET /movies/list
 
 Lista todos os filmes salvos no armazenamento local.
 
 Requisição:GET /movies/list
 
 Exemplo:GET http://localhost:8080/movies/list
 
 Resposta (JSON):
 [
    {
        "title": "Real Steel",
        "year": "2011",
        "plot": "In a near future where robot boxing is a top sport, a struggling ex-boxer feels he's found a champion in a discarded robot."
    }
]

Exemplo de Uso

Para buscar um filme:
Requisição GET:curl -X GET "http://localhost:8080/movies/search?title={titulo_do_filme} "

Para salvar um filme:
Requisição POST:curl -X POST "http://localhost:8080/movies/save?title={titulo_do_filme} "

Para listar todos os filmes salvos:
Requisição GET:curl -X GET "http://localhost:8080/movies/list"

ver /sobre
Requisição GET:curl -X GET "http://localhost:8080/sobre
