<h1 align="center">docker installation</h1>

[![License](https://img.shields.io/badge/license-GPL-blue.svg)](LICENSE)
[![GitHub stars](https://img.shields.io/badge/follow-guoliangdi-green.svg)](https://github.com/guoliangD/springcloudFeign/)


### step 1: 安装依赖
`sudo yum install -y yum-utils device-mapper-persistent-data lvm2`

### step 2: 添加软件源信息
`sudo yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo`

### step 3: 更新并安装 Docker-CE
`sudo yum makecache fast`

`sudo yum -y install docker-ce`

### step 4: 开启Docker服务
`sudo systemctl start docker`

### step 5: 查看docker version
`sudo docker version`

### 注意：
```
# 官方软件源默认启用了最新的软件，您可以通过编辑软件源的方式获取各个版本的软件包。例如官方并没有将测试版本的软件源置为可用，你可以通过以下方式开启。同理可以开启各种测试版本等。
- vim /etc/yum.repos.d/docker-ce.repo
- 将 [docker-ce-test] 下方的 enabled=0 修改为 enabled=1
-
- 安装指定版本的Docker-CE:
- Step 1: 查找Docker-CE的版本:
- yum list docker-ce.x86_64 --showduplicates | sort -r
-   Loading mirror speeds from cached hostfile
-   Loaded plugins: branch, fastestmirror, langpacks
-   docker-ce.x86_64            17.03.1.ce-1.el7.centos            docker-ce-stable
-   docker-ce.x86_64            17.03.1.ce-1.el7.centos            @docker-ce-stable
-   docker-ce.x86_64            17.03.0.ce-1.el7.centos            docker-ce-stable
-   Available Packages
- Step2 : 安装指定版本的Docker-CE: (VERSION 例如上面的 17.03.0.ce.1-1.el7.centos)
- sudo yum -y install docker-ce-[VERSION]
```