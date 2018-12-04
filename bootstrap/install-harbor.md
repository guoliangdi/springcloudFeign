<h1 align="center">harbor installation</h1>

[![License](https://img.shields.io/badge/license-GPL-blue.svg)](LICENSE)
[![GitHub stars](https://img.shields.io/badge/follow-guoliangdi-green.svg)](https://github.com/guoliangD/springcloudFeign/)


## 一、github link
https://github.com/goharbor/harbor

### step 1: 参考
https://github.com/goharbor/harbor/blob/master/docs/installation_guide.md


### Prerequisites for the target host（硬件要求）


| Resource | Capacity | Description |
| ----     |  ------  | ---- |
| CPU      | minimal 2 CPU | 4 CPU is preferred |
| Mem | minimal 4GB	  | 8GB is preferred |
| Disk | minimal 40GB | 160GB is preferred |

### Prerequisites for the target host（软件包）

| Software | Version | Description |
| ----     |  ------  | ---- |
| Python      | version 2.7 or higher | Note that you may have to install Python on Linux distributions (Gentoo, Arch) that do not come with a Python interpreter installed by default |
| Docker engine | version 1.10 or higher	  | For installation instructions, please refer to: https://docs.docker.com/engine/installation/ |
| Docker Compose | version 1.6.0 or higher | For installation instructions, please refer to: https://docs.docker.com/compose/install/ |
| Openssl | latest is preferred | Generate certificate and keys for Harbor |

### Prerequisites for the target host（网络端口）

| Port | Protocol | Description |
| ----    |  ------  | ---- |
| 443   | HTTPS | Harbor portal and core API will accept requests on this port for https protocol |
| 4443 | HTTPS	  | Connections to the Docker Content Trust service for Harbor, only needed when Notary is enabled |
| 80  | HTTP | Harbor portal and core API will accept requests on this port for http protocol |


### step 1: 下载安装包(离线安装包)
https://github.com/goharbor/harbor/releases

`wget https://storage.googleapis.com/harbor-releases/release-1.6.0/harbor-online-installer-v1.6.2.tgz`

`tar xvf harbor-online-installer-v1.6.2.tgz`

### step 2: config harbor.cfg
* 配置hostname eg. 192.168.1.100 or  (reg.youdomain.com)
* ui_url_protocol(http or https. Default is http) 
* email settings

### step 3: run install.sh to install and start harbor
`cd harbor && sh install.sh`

### step 4: Managing Harbor's lifecycle
`Stopping Harbor:`

```
$ sudo docker-compose stop
Stopping nginx              ... done
Stopping harbor-portal      ... done
Stopping harbor-jobservice  ... done
Stopping harbor-core        ... done
Stopping registry           ... done
Stopping redis              ... done
Stopping registryctl        ... done
Stopping harbor-db          ... done
Stopping harbor-adminserver ... done
Stopping harbor-log         ... done

```

`Restarting Harbor after stopping:`

```
$ sudo docker-compose start
Starting log         ... done
Starting registry    ... done
Starting registryctl ... done
Starting postgresql  ... done
Starting adminserver ... done
Starting core        ... done
Starting portal      ... done
Starting redis       ... done
Starting jobservice  ... done
Starting proxy       ... done

```


### IMPORTANT NOTE：
$ sudo docker-compose down -v

$ vim harbor.cfg

$ sudo prepare

$ sudo docker-compose up -d