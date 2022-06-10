# camel-quarkus-native-kafka-bridge-post
Sample Camel Quarkus application which posts a message to kafka topic using kafka bridge

Command to generate Native image : 
 ` ./mvnw package -Dnative -Dquarkus.native.container-build=true -Dquarkus.native.container-runtime=docker `
 
 Command to check for messages in topic : 
 ` kubectl -n kafka run kafka-consumer -ti --image=quay.io/strimzi/kafka:0.29.0-kafka-3.2.0 --rm=true --restart=Never -- bin/kafka-console-consumer.sh --bootstrap-server my-cluster-kafka-bootstrap:9092 --topic devices --from-beginning `
