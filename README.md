# springboot_and_kafka

#build mutil kafka with port custom
* bin\windows\kafka-server-start.bat config\server.properties --override listeners=PLAINTEXT://:9090 --override broker.id=2 --override log.dirs=/tmp/kafka-logs-2