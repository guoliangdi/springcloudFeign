## 使用指南( How to get/use it) ** CI/CD **：

- 1、new project by idea 

- 2、push project to gitlab

- 3、新建 jenkins pipeline 任务 


### step 1: config pipeline script

~~ 参考：Jenkinsfile.node.groovy ~~

![jenkins01](/bootstrap/jenkins01.png)

* 1.1 gitlab config webhook

- Settings >> Integrations >> Webhooks

![gitlab01](/bootstrap/gitlab01.png)

![gitlab02](/bootstrap/gitlab02.png)

![gitlab03](/bootstrap/gitlab03.png)

* 1.2 mvn build

~~ 参考：build-image.sh ~~

* 1.3 update pod application

~~ 参考：update-image.sh ~~


### step 2: kubernetes new deployment

~~ 参考：main.eureka-k8s.yaml ~~

### step 3: kubernetes service 

~~ 参考：main.eureka-k8s.yaml ~~

### 常见问题

- harbor http 认证问题

`vim /etc/docker/daemon.json` * 增加如下配置

```
{
  "registry-mirrors": ["https://harbor_ip"],
  "insecure-registries":["harbor_ip:harbor_port","harbor_ip"]
}
```

`systemctl daemon-reload`

`systemctl restart docker`

- kubernetes nodeSelector 指定node不能访问pod

- ps：不能指定 master node.

- kubernetes deployment labels and service labels 标签不一致,不能访问

- ps：deployment 和 service labels run or app  需要编写一致
