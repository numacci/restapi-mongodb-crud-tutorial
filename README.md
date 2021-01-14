# restapi-mongodb-crud-tutorial

This is a tutorial project using Spring Boot and MongoDB to build a RESTful web service. 

### Prerequisites

* Java Development Kit (JDK) 11
* Docker and docker-compose

### How to Run

1. Start MongoDB

```Shell
$ cd /path/to/project/root
$ docker-compose up -d
# You can log into mongo-express at http://loca;host:8081
```

2. Start Spring application by `bootRun`

```Shell
$ ./gradlew bootRun
```

3. Test HTTP Request

* URL root : http://localhost:8080/api

* URL Examples:

| Method | Endpoint |
| --- | --- |
| GET | /customers/USR00001 |
| GET | /customers?gender=M&postCode=999-9999 |
| GET | /customers?from=2020-01-10&to=2021-01-20 |
| GET | /customers?minPrice=4000 |
| POST | /customers (with RequestBody) |
| POST | /customers/USR00004/orders (with RequestBody) |
| PATCH | /customers/USR00004 (with RequestBody) |
| DELETE | /customers/USR00004 |
