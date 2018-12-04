<h1 align="center">sonarqube installation</h1>

[![License](https://img.shields.io/badge/license-GPL-blue.svg)](LICENSE)
[![GitHub stars](https://img.shields.io/badge/follow-guoliangdi-green.svg)](https://github.com/guoliangD/springcloudFeign/)


## 一、sonar link
https://www.sonarqube.org/downloads/

### Get the LTS (Long-term Support): SonarQube 6.7.x
* jdk1.8
* postgresql & mysql

### step 1: 下载sonar
`wget https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-6.7.6.zip`

### step 2: 启动
`./sonar.sh start`

### step 3: 访问
Browse to http://localhost:9000


## 二、docker安装方式
https://hub.docker.com/_/sonarqube/

### step 1: 安装postgres & sonarqube
`docker pull postgres`  * 依赖postgres数据库

`docker pull sonarqube`

### step 2: 启动postgresql

`docker run --name db -e POSTGRES_USER=sonar -e POSTGRES_PASSWORD=sonar -d postgres`

`docker run --name sq --link db -e SONARQUBE_JDBC_URL=jdbc:postgresql://db:5432/sonar -p 9000:9000 -d sonarqube`

* POSTGRES_USER POSTGRES_PASSWORD 指定postgresql的用户名密码

### step 3: 访问
Browse to http://localhost:9000

### IMPORTANT NOTE：
mvn sonar:sonar