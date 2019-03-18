FROM openjdk:8-alpine

ADD memory_consumer.jar /opt/local/jars/memory_consumer.jar

CMD java $JVM_OPTS -cp /opt/local/jars/memory_consumer.jar MemoryConsumer
