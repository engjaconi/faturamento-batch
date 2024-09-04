#!/bin/bash
set -e

# This script is used to drop and recreate the meta-data tables

docker exec postgres psql -f apagar-tabelas-spring.sql -U postgres
docker exec postgres psql -f criar-tabelas-spring.sql -U postgres
