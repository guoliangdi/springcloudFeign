<h1 align="center">kubernetes installation</h1>

[![License](https://img.shields.io/badge/license-GPL-blue.svg)](LICENSE)
[![GitHub stars](https://img.shields.io/badge/follow-guoliangdi-green.svg)](https://github.com/guoliangD/springcloudFeign/)


## 一、kubernetes link
https://www.kubernetes.org.cn/course/install

### Prerequisites for the target host（演示环境安装)
* host 192.168.56.60 和 192.168.56.61 机器上执行

### 1、关掉 selinux
`$ setenforce 0`

`$ sed -i "s/^SELINUX=enforcing/SELINUX=disabled/g" /etc/sysconfig/selinux`

### 2、关掉防火墙
`$ systemctl stop firewalld`

`$ systemctl disable firewalld`

### 3、关闭 swap
`$ swapoff -a`

`$ sed -i 's/.*swap.*/#&/' /etc/fstab`

### 4、配置转发参数
`$ vi  /etc/sysctl.d/k8s.conf`

`net.bridge.bridge-nf-call-ip6tables = 1`

`net.bridge.bridge-nf-call-iptables = 1`

`$ sysctl --system`

### 5、安装一些必备的工具
`$ yum install -y epel-release`

`$ yum install -y net-tools wget vim  ntpdate`

### 6、设置国内 yum 源
`$ vi /etc/yum.repos.d/kubernetes.repo`

[kubernetes]

name=Kubernetes

baseurl=https://mirrors.aliyun.com/kubernetes/yum/repos/kubernetes-el7-x86_64/

gpgcheck=0

gpgkey=https://mirrors.aliyun.com/kubernetes/yum/doc/rpm-package-key.gpg

enabled=1

### 7、yum makecache fast

### 8、修改主机名称和hosts
(1)、 修改192.168.56.60 机器:hostnamectl set-hostname k8s-60

(2)、修改192.168.56.61 机器: hostnamectl set-hostname k8s-61

(3)、修改192.168.56.60和192.168.56.61 vi /etc/hosts

192.168.56.60   k8s-60

192.168.56.61   k8s-61

## 二、安装命令组件k8s

### 1、查看可安装的版本

`yum list kubelet --showduplicates | sort -r`

### 2、安装kubeadm、kubectl、kubelet
`$ yum install -y kubelet-1.12.1 kubeadm-1.12.1 kubectl-1.12.1 kubernetes-cni-0.6.0`

`$ systemctl enable kubelet && systemctl start kubelet`

### 3、拉取k8s需要的镜像
docker pull mirrorgooglecontainers/kube-apiserver:v1.12.1

docker pull mirrorgooglecontainers/kube-controller-manager:v1.12.1

docker pull mirrorgooglecontainers/kube-scheduler:v1.12.1

docker pull mirrorgooglecontainers/kube-proxy:v1.12.1

docker pull mirrorgooglecontainers/etcd-amd64:3.2.24

docker pull mirrorgooglecontainers/pause-amd64:3.1

docker pull mirrorgooglecontainers/etcd:3.2.24

docker pull mirrorgooglecontainers/pause:3.1

docker pull coredns/coredns:1.2.2

docker pull registry.cn-shanghai.aliyuncs.com/gcr-k8s/flannel:v0.10.0-amd64

### 4、修改k8s需要的镜像名称
docker tag mirrorgooglecontainers/kube-apiserver:v1.12.1 k8s.gcr.io/kube-apiserver:v1.12.1

docker tag mirrorgooglecontainers/kube-controller-manager:v1.12.1 k8s.gcr.io/kube-controller-manager:v1.12.1

docker tag mirrorgooglecontainers/kube-scheduler:v1.12.1 k8s.gcr.io/kube-scheduler:v1.12.1

docker tag mirrorgooglecontainers/kube-proxy:v1.12.1 k8s.gcr.io/kube-proxy:v1.12.1

docker tag mirrorgooglecontainers/etcd-amd64:3.2.24 k8s.gcr.io/etcd-amd64:3.2.24

docker tag mirrorgooglecontainers/pause-amd64:3.1 k8s.gcr.io/pause-amd64:3.1

docker tag mirrorgooglecontainers/etcd:3.2.24 k8s.gcr.io/etcd:3.2.24

docker tag mirrorgooglecontainers/pause:3.1 k8s.gcr.io/pause:3.1

docker tag coredns/coredns:1.2.2 k8s.gcr.io/coredns:1.2.2

docker tag registry.cn-shanghai.aliyuncs.com/gcr-k8s/flannel:v0.10.0-amd64 quay.io/coreos/flannel:v0.10.0-amd64

### 5、删除镜像
docker rmi mirrorgooglecontainers/kube-apiserver:v1.12.1

docker rmi mirrorgooglecontainers/kube-controller-manager:v1.12.1

docker rmi mirrorgooglecontainers/kube-scheduler:v1.12.1

docker rmi mirrorgooglecontainers/kube-proxy:v1.12.1

docker rmi mirrorgooglecontainers/etcd-amd64:3.2.24

docker rmi mirrorgooglecontainers/pause-amd64:3.1

docker rmi mirrorgooglecontainers/etcd:3.2.24

docker rmi mirrorgooglecontainers/pause:3.1

docker rmi coredns/coredns:1.2.2

docker rmi registry.cn-shanghai.aliyuncs.com/gcr-k8s/flannel:v0.10.0-amd64 

### 6、查看镜像结果
`docker images | grep k8s`

![01](/bootstrap/k8s01.jpg)

### 在192.168.56.60机器上执行`

### 7、开始安装k8s
```
kubeadm init --kubernetes-version=v1.12.1 --pod-network-cidr=10.244.0.0/16 --apiserver-advertise-address=192.168.56.60
```

![02](/bootstrap/k8s02.jpg)

执行屏幕打印出的命令

mkdir -p $HOME/.kube

sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config

sudo chown $(id -u):$(id -g) $HOME/.kube/config

### 8、创建 flannel 网络

(1) sysctl net.bridge.bridge-nf-call-iptables=1

(2) wget  wget https://raw.githubusercontent.com/coreos/flannel/master/Documentation/kube-flannel.yml

(3) flannel 默认会使用主机的第一张网卡，如果你有多张网卡，需要通过配置单独指定。修改 kube-flannel.yml 中的以下部分

![03](/bootstrap/k8s03.jpg)

![04](/bootstrap/k8s04.jpg)

![05](/bootstrap/k8s05.jpg)


(4) 安装网络

** 手工先下载

`docker pull quay.io/coreos/flannel:v0.10.0-amd64`

如果很慢可以下载

`docker pull registry.cn-shenzhen.aliyuncs.com/cp_m/flannel:v0.10.0-amd64`

`docker tag registry.cn-shenzhen.aliyuncs.com/cp_m/flannel:v0.10.0-amd64 quay.io/coreos/flannel:v0.10.0-amd64`

** 创建网络  kubectl apply -f kube-flannel.yml


![06](/bootstrap/k8s06.jpg)


### 在192.168.56.61机器上执行

9、192.168.56.61加入集群
(1)、同样的类似192.168.56.60下载镜像

        3、拉取k8s需要的镜像

        4、修改k8s需要的镜像名称

        5、删除镜像

(2)、使用刚才在192.168.56.60创建master控制台提示加入集群命令

```
kubeadm join 192.168.56.60:6443 --token cgggwd.q5w883rkzbp44v6w --discovery-token-ca-cert-hash sha256:cae67bec80da916c8e140f4e66f2ce3aff2f8be3a8580f757cdfdfd1651337ba

```

(3)、在192.168.56.60上验证

![07](/bootstrap/k8s07.jpg)