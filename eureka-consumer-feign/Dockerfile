# Name: eureka-consumer-feign
# Time: 2018

FROM java:8-jre

MAINTAINER GuoliangDi <digl@yiche.com>

RUN mkdir /app

WORKDIR /app

COPY ./target/eureka-consumer-feign.jar /app

CMD ["java", "-Xmx200m", "-jar", "/app/eureka-consumer-feign.jar"]

EXPOSE 30083