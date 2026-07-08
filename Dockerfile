FROM maven:3.9.11-openjdk-25

WORKDIR /starlink

COPY . .

RUN mvn clean install

CMD mvn spring-boot:run