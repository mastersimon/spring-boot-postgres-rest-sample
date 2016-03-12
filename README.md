
Demonstration of how to use:
- [x] Spring Boot
- [x] JPA
- [x] REST
- [x] Postgres

## Install local PostresSQL 9.5
If you like to run a postres DB locally, you can do this easily with  docker.

```bash
docker run --name postgres -e POSTGRES_PASSWORD=itblogging -p 5432:5432 -d postgres:9.5
```

*Note*: If you are using a Mac with VirtualBox, please keep in mind to add the port **5432** to the port forwarding settings of your virtual machine.

## GET all available persons
```bash
curl -X "GET" "http://localhost:8080/persons"
```

## CREATE a new person
```bash
curl -X "POST" "http://localhost:8080/persons" \
	-H "Content-Type: application/json" \
	-d $'{
	"first_name":"Simon",
	"last_name":"Michel"
}'
```

## READ a person by id
```bash
curl -X "GET" "http://localhost:8080/persons/1"
```

## UPDATE a person by id
```bash
curl -X "PATCH" "http://localhost:8080/persons/1" \
	-H "Content-Type: application/json" \
	-d $'{
	"first_name":"Simoooon",
	"last_name":"Micheeeeeel"
}'
```
