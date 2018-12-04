<h1 align="center">gitlab installation</h1>

[![License](https://img.shields.io/badge/license-GPL-blue.svg)](LICENSE)
[![GitHub stars](https://img.shields.io/badge/follow-guoliangdi-green.svg)](https://github.com/guoliangD/springcloudFeign/)


## 一、官方指定安装方式
https://about.gitlab.com/install/#centos-7?version=ce

### step 1: 安装依赖
`sudo yum install -y curl policycoreutils-python openssh-server openssh-clients`

`sudo firewall-cmd --permanent --add-service=http`

`sudo systemctl reload firewalld`

### step 2: 添加软件源信息
`curl -sS https://packages.gitlab.com/install/repositories/gitlab/gitlab-ce/script.rpm.sh | sudo bash`

### step 3: 安装 gitlab-ce
`sudo EXTERNAL_URL="http://gitlab.example.com" yum install -y gitlab-ce`

### step 4: 配置并启动gitlab-ce
`gitlab-ctl reconfigure`

## 二、docker安装方式
https://hub.docker.com/r/gitlab/gitlab-ce/

### step 1: 安装
`sudo docker pull gitlab/gitlab-ce:latest`

### step 2: 启动
```
sudo docker run --detach \
    --hostname gitlab.example.com \
    --publish 443:443 --publish 80:80 --publish 22:22 \
    --name gitlab \
    --restart always \
    --volume /srv/gitlab/config:/etc/gitlab \
    --volume /srv/gitlab/logs:/var/log/gitlab \
    --volume /srv/gitlab/data:/var/opt/gitlab \
    gitlab/gitlab-ce:latest
```
    

### step 3: 配置
`docker exec -it gitlab /bin/bash`

`vi /etc/gitlab/gitlab.rb`



### IMPORTANT NOTE：
* root login