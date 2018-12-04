# Name: eureka-server
# Time: 2018

FROM java:8-jre

MAINTAINER GuoliangDi <digl@yiche.com>

RUN mkdir /app

WORKDIR /app

COPY ./target/eureka-server.jar /app

CMD ["java", "-Xmx200m", "-jar", "/app/eureka-server.jar"]

EXPOSE 30081