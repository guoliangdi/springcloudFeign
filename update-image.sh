#!/usr/bin/env bash

set -eo pipefail

REGISTRY_IP="172.20.4.27"
REGISTRY_NAME="springcloudfeign"
PROJECT_MODULE="eureka-provider"
HOST_PWD="bitauto"
HOST_USER="root"
HOST_IP="172.20.4.148"


K8S_UPDATE_IMAGE_VER=`docker images |grep ${REGISTRY_IP}/${REGISTRY_NAME}/${PROJECT_MODULE} |awk 'NR==1 {print $2}'`

sshpass -p ${HOST_PWD} ssh  -p 22 -o StrictHostKeyChecking=no ${HOST_USER}@${HOST_IP} kubectl set image deployment my-provider my-provider=${REGISTRY_IP}/${REGISTRY_NAME}/${PROJECT_MODULE}:${K8S_UPDATE_IMAGE_VER} -n default --record