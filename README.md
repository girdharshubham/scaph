# scaph
Scala Phantom Cassandra

Phantom is a reactive type-safe Scala driver for Apache Cassandra/Datastax Enterprise.

Testing the template with docker :
```
docker run -d -p 9042:9042 cassandra:latest
export CONTACTPOINT="localhost"
export PORT="9042"
export KEYSPACE="cas"
export TABLE="temperature"

sbt run
```
