# 作业

## 集群搭建

参考：https://medium.com/big-data-engineering/hello-kafka-world-the-complete-guide-to-kafka-with-docker-and-python-f788e2588cfc

配置文件
https://gist.github.com/everpeace/7a317860cab6c7fb39d5b0c13ec2543e



```
> git clone https://github.com/wurstmeister/kafka-docker.git 
> cd kafka-docker

# Update KAFKA_ADVERTISED_HOST_NAME inside 'docker-compose.yml',
# For example, set it to 172.17.0.1
> vim docker-compose.yml 
> docker-compose up -d

# Optional - Scale the cluster by adding more brokers (Will start a single zookeeper instance)
> docker-compose scale kafka=3

# You can check the proceses running with:
> docker-compose ps

# Destroy the cluster when you are done with it
> docker-compose stop
```


## Kafka Shell
To start it just run the command:
```
> ./start-kafka-shell.sh <DOCKER_HOST_IP/KAFKA_ADVERTISED_HOST_NAME>
# In my case:
> ./start-kafka-shell.sh 172.17.0.1
```
## Hello Topic
From within the Kafka Shell, run the following to create and describe a topic:
```
> $KAFKA_HOME/bin/kafka-topics.sh --create --topic test \
--partitions 4 --replication-factor 2 \
--bootstrap-server `broker-list.sh`
> $KAFKA_HOME/bin/kafka-topics.sh --describe --topic test \
--bootstrap-server `broker-list.sh`
```
## Hello Producer
Initialize the producer and write messages to Kafka’s brokers.
```
> $KAFKA_HOME/bin/kafka-console-producer.sh --topic=test \
--broker-list=`broker-list.sh`
>> Hello World!
>> I'm a Producer writing to 'hello-topic'
```
## Hello Consumer
Initialize the consumer from another Kafka terminal and it will start reading the messages sent by the producer.
```
> $KAFKA_HOME/bin/kafka-console-consumer.sh --topic=test \
--from-beginning --bootstrap-server `broker-list.sh`
```
