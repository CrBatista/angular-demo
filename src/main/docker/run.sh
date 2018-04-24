pgdata="$PWD/db";
initsql="$PWD/docker-entrypoint-initdb.d";
postgresContainerName="ericsson-postgres"

#Stop containers
docker rm -f $postgresContainerName

#run docker file
echo "Starting Postgres Ericsson DB"
docker run -d --name $postgresContainerName -e "POSTGRES_PASSWORD=ericsson" -e "POSTGRES_USER=ericsson" -e "POSTGRES_DB=ericsson" -e "PGDATA=$pgdata" -v $initsql:/docker-entrypoint-initdb.d -p 5432:5432 postgres:9.4