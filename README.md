## Banco de Dados

Para criar o banco de dados no docker:
> docker pull postgres
> docker run --name postgres -e POSTGRES_PASSWORD=postgres -d postgres

Para acessar a linha de comando do banco de dados:
> docker exec -it postgres psql -U postgres

Executar o código do script presente na pasta resources/sql/criar-tabelas-spring-batch.sql no terminal.

Para verificar as tabelas criadas:
> \d

