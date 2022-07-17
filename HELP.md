# imp command
docker-compose up -d
docker exec broker kafka-topics --bootstrap-server broker:9092 --create --topic topicname
docker exec --interactive --tty broker kafka-console-producer --bootstrap-server broker:9092 --topic topicname
docker exec --interactive --tty broker kafka-console-consumer --bootstrap-server broker:9092 --topic topicname --from-beginning
docker-compose down
