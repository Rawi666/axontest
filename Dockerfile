FROM maven:3-jdk-8 as builder

COPY . /home/maven/src
WORKDIR /home/maven/src
RUN mvn package

FROM openjdk:8-jre-slim
COPY --from=builder /home/maven/src/target/axontest-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app
ENTRYPOINT java -Djava.net.preferIPv4Stack=true -jar axontest-0.0.1-SNAPSHOT.jar
