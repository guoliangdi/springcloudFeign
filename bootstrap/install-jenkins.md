<h1 align="center">jenkins installation</h1>


![GitHub](https://img.shields.io/github/license/mashape/apistatus.svg)

## 一、jenkins link
https://jenkins.io/doc/pipeline/tour/getting-started/

### Prerequisites for the target host
* jdk1.8
* docker

### step 1: 下载jenkins
`wget http://mirrors.jenkins.io/war-stable/latest/jenkins.war`

### step 2: 启动
`java -jar jenkins.war --httpPort=8080`

### step 3: 访问
Browse to http://localhost:8080


## 二、docker安装方式
https://hub.docker.com/_/jenkins/

### step 1: 安装
`sudo docker pull jenkins`

### step 2: 启动
`docker run --name myjenkins -p 8080:8080 -p 50000:50000 -v /var/jenkins_home jenkins`