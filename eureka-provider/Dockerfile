# Name: eureka-provider
# Time: 2018

FROM java:8-jre

MAINTAINER GuoliangDi <digl@yiche.com>

RUN mkdir /app

WORKDIR /app

COPY ./target/eureka-provider.jar /app

CMD ["java", "-Xmx200m", "-jar", "/app/eureka-provider.jar"]

EXPOSE 30082