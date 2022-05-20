## Calculadora de idade API Java
**Project info:** Este conteudo consiste em retornar a idade a partir da data de nascimento de uma pessoa.   
**Tech usada:** Para construir este simples microserviço utilizei Java 11, e Spring.

###### Rotas

**get** _/pessoa/idade/{dd-mm-aaaa}_ : **200** retorna a idade da pessoa. **400:** Bad request.

**get** _/pessoa/{id}_ : **200** retorna os dados da pessoa (id e data de nascimento). **404** Not found.

**get** _/pessoa_ : **200** retorna lista de todas as pessoas.

**post** _/pessoa_ : **200** adiciona uma pessoa. Para este simples projeto e retornado os dados da pessoa cadastrada. **400** Bad Request.


###### Usar o repositorio

- via linha de comando
$ git clone https://github.com/scecilia028/idade-java-api.git (ou fazer o download do arquivo compactado)

- Clique direito -> Maven -> Update Project... -> [idade-java-api]
 
- Clique direito - Run As.. -> Maven Build... 
  - Em goals, use: spring-boot:run -> apply -> Run
