## Banco de Dados

Para criar o banco de dados no docker:
> docker pull postgres

> docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=postgres -d postgres

Para acessar a linha de comando do banco de dados:
> docker exec -it postgres psql -U postgres

Executar o código do script presente na pasta resources/sql/criar-tabelas-spring-batch.sql no terminal.

Para verificar as tabelas criadas:
> \d

Para verificar o status da execução de um trabalho (job) no terminal:
> docker exec postgres psql -U postgres -c 'select * from BATCH_JOB_EXECUTION;'
