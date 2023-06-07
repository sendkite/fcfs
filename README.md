### 선착순 이벤트 흐름 익히기

### 도커 설정

````shell
docker pull mysql
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 --name mysql mysql

docker pull redis
docker run --name myredis -d -p 6379:6379 redis

docker ps
docker exec -it mysql bash
docker exec -it {PID} redis-cli


docker-compose up -d
````

### DB 설정

```shell
mysql -u root -p
create database coupon_example;
use coupon_example;
```

### redis

```shell
docker exec -it {PID} redis-cli

# increase
incr coupon_count
# 초기화
flushall
# set
sadd test 1
```

### kafka

```shell

# 토픽 생성
docker exec -it kafka kafka-topics.sh --bootstrap-server localhost:9092 --create --topic coupon_create

# consumer
docker exec -it kafka kafka-console-consumer.sh --topic coupon_create --bootstrap-server localhost:9092 --key-deserializer "org.apache.kafka.common.serialization.StringDeserializer" --value-deserializer "org.apache.kafka.common.serialization.LongDeserializer"

# producer
docker exec -it kafka kafka-console-producer.sh --topic testTopic --broker-list 0.0.0.0:9092

```

