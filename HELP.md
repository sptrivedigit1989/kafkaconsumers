# imp command
#1 docker-compose up -d
#2 docker exec broker kafka-topics --bootstrap-server broker:9092 --create --topic topicname
#3 docker exec --interactive --tty broker kafka-console-producer --bootstrap-server broker:9092 --topic topicname
#4 docker exec --interactive --tty broker kafka-console-consumer --bootstrap-server broker:9092 --topic topicname --from-beginning
#5 docker-compose down
